import java.util.*;
import model.*;

public class Main {
    /*
     * 9.2 Requisitos
     * • Configuração inicial do sistema no terminal - SEM PERSISTENCIA DE DADOS.
     * • Criação de menus no terminal para cadastro de PESSOAS (tutores, adotantes e funcionários).
     *  ◦ As pessoas podem ser ao mesmo tempo adotantes, tutores(doadores) e/ou funcionarios;
     *  ◦ Não teremos login na primeira entrega, nem níveis de permissão de usuário ainda.
     * • Geração de relatórios simples no terminal (ex: listagem de usuários cadastrados).
     */

     //Arthur Augusto, Arthur Silva, Felipe Witkowsky, Henriquy Dias

    public static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static int idFuncionario = 0;
    public static int idAdotante = 0;
    public static int idTutor = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema do PatasAmigas");

        boolean running = true;
        while (running) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar nova pessoa");
            System.out.println("2. Exibir informações de uma pessoa");
            System.out.println("3. Editar informações de uma pessoa");
            System.out.println("4. Relatório das pessoas cadastradas");
            System.out.println("5. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    criarPessoa(scanner);
                    break;
                case 2:
                    exibirPessoa(scanner);
                    break;
                case 3:
                    editarPessoa(scanner);
                    break;
                case 4:
                    relatorio();
                    break;
                case 5:
                    running = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void criarPessoa(Scanner scanner) {
        System.out.println("\n--- Criar Nova Pessoa ---");

        System.out.print("Nome Completo: ");
        String nome = scanner.nextLine();

        System.out.print("Data de Nascimento: ");
        String dataDeNascimento = scanner.nextLine();

        System.out.print("Gênero (digite o número correspondente): ");
        System.out.println("\n1 - Homem");
        System.out.println("2 - Mulher");
        System.out.println("3 - Não-binário");
        int generoEscolha = scanner.nextInt();

        String genero = switch (generoEscolha) {
            case 1 -> "Homem";
            case 2 -> "Mulher";
            case 3 -> "Não-binário";
            default -> {
                System.err.println("Você digitou um número inválido.");
                yield "Indefinido";
            }
        };

        scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Pessoa novaPessoa = new Pessoa(nome, dataDeNascimento, genero, cpf,
                endereco, telefone, email, senha);

        System.out.println("Primeira parte do cadastro feita.");
        System.out.println(novaPessoa);

        boolean cadastrando = true;
        do {
            System.out.println("Esta pessoa será um: ");
            System.out.println("1 - Funcionário");
            System.out.println("2 - Tutor");
            System.out.println("3 - Adotante");
            int escolha = scanner.nextInt();

            // A partir da escolha, verifica: a pessoa registrada já tem um id correspondente com a opção escolhida?
            switch(escolha){
                case 1:
                    idFuncionario++;
                    System.out.println("Cadastrando Funcionário. ID: " + idFuncionario);

                    scanner.nextLine();
                    System.out.println("Data de Contratação: ");
                    String dataDeContratacao = scanner.nextLine();

                    System.out.println("Cargo: ");
                    String cargo = scanner.nextLine();

                    System.out.println("Salário: ");
                    float salario = scanner.nextFloat();

                    scanner.nextLine();
                    System.out.println("Departamento: ");
                    String departamento = scanner.nextLine();

                    Funcionario novoFuncionario = new Funcionario(
                            novaPessoa.getNome(),
                            novaPessoa.getDataDeNascimento(),
                            novaPessoa.getGenero(),
                            novaPessoa.getCpf(),
                            novaPessoa.getEndereco(),
                            novaPessoa.getTelefone(),
                            novaPessoa.getEmail(),
                            novaPessoa.getSenha(),
                            idFuncionario, dataDeContratacao, cargo, salario, departamento
                    );
                    pessoas.add(novoFuncionario);
                    cadastrando = false;
                    break;
                case 2:
                    idTutor++;
                    System.out.println("Cadastrando Tutor. ID: " + idTutor);

                    System.out.println("Número de Animais sob Custódia: ");
                    int numDeAnimais = scanner.nextInt();

                    scanner.nextLine();
                    System.out.println("Histórico de Adoções: ");
                    String adocoesTutor = scanner.nextLine();

                    System.out.println("Status: ");
                    String statusTutor = scanner.nextLine();

                    Tutor novoTutor = new Tutor(
                            novaPessoa.getNome(),
                            novaPessoa.getDataDeNascimento(),
                            novaPessoa.getGenero(),
                            novaPessoa.getCpf(),
                            novaPessoa.getEndereco(),
                            novaPessoa.getTelefone(),
                            novaPessoa.getEmail(),
                            novaPessoa.getSenha(),
                            idTutor, numDeAnimais, adocoesTutor, statusTutor
                    );
                    pessoas.add(novoTutor);
                    cadastrando = false;
                    break;
                case 3:
                    idAdotante++;
                    System.out.println("Cadastrando Adotante. ID: " + idAdotante);

                    System.out.println("Preferências de Adoção: ");
                    String preferenciasDeAdocao = scanner.nextLine();

                    System.out.println("Histórico de Adoções Realizadas: ");
                    String adocoesAdotante = scanner.nextLine();

                    System.out.println("Status: ");
                    String statusAdotante = scanner.nextLine();

                    Adotante novoAdotante = new Adotante(
                            novaPessoa.getNome(),
                            novaPessoa.getDataDeNascimento(),
                            novaPessoa.getGenero(),
                            novaPessoa.getCpf(),
                            novaPessoa.getEndereco(),
                            novaPessoa.getTelefone(),
                            novaPessoa.getEmail(),
                            novaPessoa.getSenha(),
                            idAdotante, preferenciasDeAdocao, adocoesAdotante, statusAdotante
                    );
                    pessoas.add(novoAdotante);
                    cadastrando = false;
                    break;
                default:
                    System.out.println("Por favor, digite um número válido.");
                    break;
            }
            // Deseja adicionar mais algum cargo?
            // 1 - Sim | 2 - Não
            // Sim: cadastrando = true
            // Não: cadastrando = false
        } while (cadastrando);
    }

    private static void exibirPessoa(Scanner scanner) {
        System.out.println("Você deseja obter as informações de que pessoa?");
        System.out.println("1 - Um Funcionário");
        System.out.println("2 - Um Tutor");
        System.out.println("3 - Um Adotante");
        int opcao = scanner.nextInt();

        int id;
        boolean achado = false;
        switch(opcao) {
            case 1:
                System.out.println("Digite o ID do funcionário: ");
                id = scanner.nextInt();
                for (Pessoa pessoa : pessoas){
                    Map<String, Integer> papeisPessoa = pessoa.getPapeis();
                    if(papeisPessoa.get("idFuncionario") == id) {
                        System.out.println(pessoa);
                        achado = true;
                        break;
                    }
                }
                if(!achado){
                    System.out.println("Não conseguimos achar este ID. Tente novamente.");
                }
                break;
            case 2:
                System.out.println("Digite o ID do tutor: ");
                id = scanner.nextInt();
                for (Pessoa pessoa : pessoas){
                    Map<String, Integer> papeisPessoa = pessoa.getPapeis();
                    if(papeisPessoa.get("idTutor") == id) {
                        System.out.println(pessoa);
                        achado = true;
                        break;
                    }
                }
                if(!achado){
                    System.out.println("Não conseguimos achar este ID. Tente novamente.");
                }
            case 3:
                System.out.println("Digite o ID do adotante: ");
                id = scanner.nextInt();
                for (Pessoa pessoa : pessoas){
                    Map<String, Integer> papeisPessoa = pessoa.getPapeis();
                    if(papeisPessoa.get("idAdotante") == id) {
                        System.out.println(pessoa);
                        achado = true;
                        break;
                    }
                }
                if(!achado){
                    System.out.println("Não conseguimos achar este ID. Tente novamente.");
                }
            default:
                System.out.println("Digite um número válido.");
                break;
        }
    }

    private static void editarPessoa(Scanner scanner) {
        Pessoa pessoa = new Pessoa();
        System.out.println("\n--- Editar Pessoa ---");

        System.out.print("Nome (" + pessoa.getNome() + "): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) pessoa.setNome(nome);

        System.out.print("Data de Nascimento (" + pessoa.getDataDeNascimento() + "): ");
        String dataDeNascimento = scanner.nextLine();
        if (!dataDeNascimento.isEmpty()) pessoa.setDataDeNascimento(dataDeNascimento);

        System.out.print("Gênero (" + pessoa.getGenero() + "): ");
        String genero = scanner.nextLine();
        if (!genero.isEmpty()) pessoa.setGenero(genero);

        System.out.print("CPF (" + pessoa.getCpf() + "): ");
        String cpf = scanner.nextLine();
        if (!cpf.isEmpty()) pessoa.setCpf(cpf);

        System.out.print("Endereço (" + pessoa.getEndereco() + "): ");
        String endereco = scanner.nextLine();
        if (!endereco.isEmpty()) pessoa.setEndereco(endereco);

        System.out.print("Telefone (" + pessoa.getTelefone() + "): ");
        String telefone = scanner.nextLine();
        if (!telefone.isEmpty()) pessoa.setTelefone(telefone);

        System.out.print("Email (" + pessoa.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) pessoa.setEmail(email);

        System.out.print("Senha (" + pessoa.getSenha() + "): ");
        String senha = scanner.nextLine();
        if (!senha.isEmpty()) pessoa.setSenha(senha);

        /*
        // Verifica os ids que a pessoa tem
        Gostaria de atualizar os atributos de + cargo + desta pessoa?
        Sim | Não
        Chamada de funções com if/else para atualizar cada atributo dos outros cargos
         */

        System.out.println("Informações da pessoa atualizadas com sucesso!");
    }

    private static void relatorio(){
        int i = 1;
        for (Pessoa pessoa: pessoas) {
            System.out.println(i + "º Pessoa: ");
            System.out.println(pessoa.toString());
            i++;
        }
    }
}
