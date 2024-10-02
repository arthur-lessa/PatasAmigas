import java.util.Scanner;
import model;
import model.Funcionario;
import model.Pessoa;

public class Main {
    /*
     * 9.2 Requisitos
• Configuração inicial do sistema no terminal - SEM PERSISTENCIA DE DADOS.
• Criação de menus no terminal para cadastro de PESSOAS (tutores, adotantes e funcionários).
◦ As pessoas podem ser ao mesmo tempo adotantes, tutores(doadores) e/ou funcionarios;
◦ Não teremos login na primeira entrega, nem níveis de permissão de usuário ainda.
• Geração de relatórios simples no terminal (ex: listagem de usuários cadastrados).
     */

     //Arthur Augusto, Arthur Silva, Felipe Witkowsky, Henriquy Dias
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

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
                    pessoa = criarPessoa(scanner);
                    break;
                case 2:
                    exibirPessoa(pessoa);
                    break;
                case 3:
                    editarPessoa(scanner, pessoa);
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

    private static Pessoa criarPessoa(Scanner scanner) {
        int i = 0;
        String genero = new String();

        System.out.println("\n--- Criar Nova Pessoa ---");

        System.out.print("Nome Completo: ");
        String nome = scanner.nextLine();

        System.out.print("Data de Nascimento: ");
        String dataDeNascimento = scanner.nextLine();

        System.out.print("Gênero (digite o número correspondente): ");
        System.out.println("1 - Homem");
        System.out.println("2 - Mulher");
        System.out.println("3 - Não-binário");
        int generoEscolha = scanner.nextInt();

        switch(generoEscolha) {
            case 1:
                genero = "Homem";
                break;
            case 2:
                genero = "Mulher";
                break;
            case 3:
                genero = "Não-binário";
                break;
            default:
                System.err.println("Você digitou um número inválido.");
                genero = "Indefinido";
                break;
        }

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

        // Você pode definir o ID da pessoa conforme necessário (ex: auto-incremento ou geração manual)
        int idPessoa = 1; // Exemplo de ID fixo

        Pessoa pessoaCadastrando = new Pessoa(nome, dataDeNascimento, genero, cpf, endereco, telefone, email, senha);

        int escolhaTipo = 0;
        do{


        System.out.println("- Finalizada primeira parte do cadastro. -");
        System.out.println("Defina qual será o \"tipo\" de pessoa no sistema.");
        System.out.println("1 - Funcionário");
        System.out.println("2 - Tutor");
        System.out.println("3 - Adotante");
        escolhaTipo = scanner.nextInt();
        switch (escolhaTipo) {
            case 1:
            System.out.print("Data de Nascimento: ");
            String dataDeContratacao = scanner.nextLine();

                Funcionario funcionario = new Funcionario(pessoaCadastrando.getNome()
                , pessoaCadastrando.getDataDeNascimento(), pessoaCadastrando.getGenero()
                , pessoaCadastrando.getCpf(), pessoaCadastrando.getEndereco(), 
                pessoaCadastrando.getTelefone(), pessoaCadastrando.getEmail(), 
                pessoaCadastrando.getSenha(), dataDeContratacao)
                break;
            case 2:

                break;
            case 3: 


                break;
            default:
                break;
        }
        while(escolhaTipo!=1 && escolhaTipo!=2 && escolhaTipo!=3)
        
        return novaPessoa;
    }

    private static void exibirPessoa(Pessoa pessoa) {
        System.out.println("\n--- Informações da Pessoa ---");
        System.out.println(pessoa.toString());
    }

    private static void editarPessoa(Scanner scanner, Pessoa pessoa) {
        System.out.println("\n--- Editar Pessoa ---");

        System.out.print("Nome (" + pessoa.getNome() + "): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) pessoa.setNome(nome);

        System.out.print("Sobrenome (" + pessoa.getSobrenome() + "): ");
        String sobrenome = scanner.nextLine();
        if (!sobrenome.isEmpty()) pessoa.setSobrenome(sobrenome);

        System.out.print("Email (" + pessoa.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) pessoa.setEmail(email);

        System.out.print("Logradouro (" + pessoa.getLogradouro() + "): ");
        String logradouro = scanner.nextLine();
        if (!logradouro.isEmpty()) pessoa.setLogradouro(logradouro);

        System.out.print("Número (" + pessoa.getNumero() + "): ");
        String numero = scanner.nextLine();
        if (!numero.isEmpty()) pessoa.setNumero(numero);

        System.out.print("Bairro (" + pessoa.getBairro() + "): ");
        String bairro = scanner.nextLine();
        if (!bairro.isEmpty()) pessoa.setBairro(bairro);

        System.out.print("Cidade (" + pessoa.getCidade() + "): ");
        String cidade = scanner.nextLine();
        if (!cidade.isEmpty()) pessoa.setCidade(cidade);

        System.out.print("Estado (" + pessoa.getEstado() + "): ");
        String estado = scanner.nextLine();
        if (!estado.isEmpty()) pessoa.setEstado(estado);

        System.out.print("País (" + pessoa.getPais() + "): ");
        String pais = scanner.nextLine();
        if (!pais.isEmpty()) pessoa.setPais(pais);

        System.out.print("Nacionalidade (" + pessoa.getNacionalidade() + "): ");
        String nacionalidade = scanner.nextLine();
        if (!nacionalidade.isEmpty()) pessoa.setNacionalidade(nacionalidade);

        System.out.println("Informações da pessoa atualizadas com sucesso!");
    }

    private static void relatorio(){
        // For para listar as pessoas cadastradas
    }
}
