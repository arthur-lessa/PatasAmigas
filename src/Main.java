import java.util.*;
import model.*;
import services.*;

public class Main {
    /*
     * 9.2 Requisitos
     * • Configuração inicial do sistema no terminal - SEM PERSISTENCIA DE DADOS.
     * • Criação de menus no terminal para cadastro de PESSOAS (tutores, adotantes e funcionários).
     *  ◦ As pessoas podem ser ao mesmo tempo adotantes, tutores(doadores) e/ou funcionarios;
     *  ◦ Não teremos login na primeira entrega, nem níveis de permissão de usuário ainda.
     * • Geração de relatórios simples no terminal (ex: listagem de usuários cadastrados).
     */

    /*
     * TODO:
     * organizar classes separadas para Pessoa, Funcionário, Tutor e Adotante
     * ajustar no método editarDadosBasicosPessoa o gênero para opções numéricas
     */

    //Arthur Augusto, Arthur Silva, Felipe Witkowsky, Henriquy Dias

    /* Criação de ArrasyLists correspondentes a cada entidade que irá 
    participar do processo de adoção */
    public static ArrayList<Pessoa> pessoas = new ArrayList<>();
    public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public static ArrayList<Tutor> tutores = new ArrayList<>();
    public static ArrayList<Adotante> adotantes = new ArrayList<>();

    // Atribuindo às entidades um id para que possam ser 
    //localizadas e identificadas com maior facilidade
    public static int idFuncionario = 0;
    public static int idAdotante = 0;
    public static int idTutor = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* Inicializando o sistema e mostrando as opções para o usuário: */
        System.out.println("Sistema do PatasAmigas");
        boolean running = true;
        while (running) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar nova pessoa");
            System.out.println("2. Cadastrar novo animal");
            System.out.println("3. Exibir informações de uma pessoa");
            System.out.println("4. Editar informações de uma pessoa");
            System.out.println("5. Relatórios");
            System.out.println("6. Sair");

            /* De acordo com a escolha do usuário, será realizada
            a ação correspondente ao descrito no menu de inicialização,
            e caso a escolha numérica do usuário não entre nas opções
            abordadas na inicialização, é sugerido ao usuário que 
            tente novamente. */
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Services.criarPessoa(scanner);
                    break;
                case 2:
                    Services.criarAnimal(scanner);
                    break;
                case 3:
                    Services.exibirPessoa(scanner);
                    break;
                case 4:
                    Services.editarPessoa(scanner);
                    break;
                case 5:
                    Services.relatorio(scanner);
                    break;
                case 6:
                    running = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
