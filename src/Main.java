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
    public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public static ArrayList<Tutor> tutores = new ArrayList<>();
    public static ArrayList<Adotante> adotantes = new ArrayList<>();

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
            System.out.println("4. Relatórios");
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
                    relatorio(scanner);
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
        int escolhaContinuar;
        do {
            System.out.println("Esta pessoa será um: ");
            System.out.println("1 - Funcionário");
            System.out.println("2 - Tutor");
            System.out.println("3 - Adotante");
            int escolha = scanner.nextInt();

            // A partir da escolha, verifica: a pessoa registrada já tem um id correspondente com a opção escolhida?
            Map<String, Integer> papeisPessoa = novaPessoa.getPapeis();
            System.out.println(novaPessoa);
            switch(escolha){
                case 1:
                    if(papeisPessoa.containsKey("idFuncionario")){
                        System.out.println("Essa pessoa já está cadastrada como Funcionário!");
                        break;
                    }
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
                    funcionarios.add(novoFuncionario);
                    novaPessoa.addPapel("idFuncionario", idFuncionario);
                    cadastrando = false;
                    break;
                case 2:
                    if(papeisPessoa.containsKey("idTutor")){
                        System.out.println("Essa pessoa já está cadastrada como Tutor!");
                        break;
                    }
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
                    tutores.add(novoTutor);
                    novaPessoa.addPapel("idTutor", idTutor);
                    cadastrando = false;
                    break;
                case 3:
                    if(papeisPessoa.containsKey("idAdotante")){
                        System.out.println("Essa pessoa já está cadastrada como Adotante!");
                        break;
                    }
                    idAdotante++;
                    System.out.println("Cadastrando Adotante. ID: " + idAdotante);

                    scanner.nextLine();
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
                    adotantes.add(novoAdotante);
                    novaPessoa.addPapel("idAdotante", idAdotante);
                    cadastrando = false;
                    break;
                default:
                    System.err.println("Por favor, digite um número válido.");
                    break;
            }
            do {
                System.out.println("Deseja adicionar mais algum cargo?");
                System.out.println("1 - Sim | 2 - Não");
                escolhaContinuar = scanner.nextInt();
                if(escolhaContinuar == 1){
                    System.out.println("\n");
                    cadastrando = true;
                } else if(escolhaContinuar == 2){
                    cadastrando = false;
                } else {
                    System.out.println("Digite uma opção válida.");
                }
            } while (escolhaContinuar != 1 && escolhaContinuar != 2);
        } while (cadastrando);
        pessoas.add(novaPessoa);
    }

    private static void exibirPessoa(Scanner scanner) {
        int id, escolha;
        boolean achado = false;
        do {
            System.out.println("Você deseja obter as informações de que pessoa?");
            System.out.println("1 - Um Funcionário");
            System.out.println("2 - Um Tutor");
            System.out.println("3 - Um Adotante");
            int opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    System.out.println("Digite o ID do funcionário: ");
                    id = scanner.nextInt();
                    for (Pessoa pessoa : funcionarios){
                        if(pessoa.containsKey("idFuncionario")){
                            if(pessoa.pegaValor("idFuncionario") == id) {
                                System.out.println(pessoa);
                                achado = true;
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Digite o ID do tutor: ");
                    id = scanner.nextInt();
                    for (Pessoa pessoa : tutores){
                        if(pessoa.containsKey("idTutor")){
                            if(pessoa.pegaValor("idTutor") == id) {
                                System.out.println(pessoa);
                                achado = true;
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o ID do adotante: ");
                    id = scanner.nextInt();
                    for (Pessoa pessoa : adotantes){
                        if(pessoa.containsKey("idAdotante")){
                            if(pessoa.pegaValor("idAdotante") == id) {
                                System.out.println(pessoa);
                                achado = true;
                                break;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Digite um número válido.");
                    break;
            }
            if(!achado){
                do {
                    System.err.println("Não conseguimos achar este ID.");
                    System.out.println("Deseja tentar novamente? \n1 - Sim | 2 - Não");
                    escolha = scanner.nextInt();
                    if(escolha == 2) {
                        achado = true;
                    } else if(escolha == 1){
                        System.out.println("\n");
                    } else {
                        System.err.println("Digite uma opção válida.");
                    }
                } while(escolha != 1 && escolha != 2);
            }
        } while(!achado);
    }

    private static void editarPessoa(Scanner scanner) {
        int opcaoEscolhida = 0;
        int idDaPessoa;
        boolean rodando = true;
        boolean ehFuncionario = false;
        boolean ehTutor = false;
        boolean ehAdotante = false;
        Pessoa pessoaEditando = null;
        System.out.println("\n--- Editar Pessoa ---");

        while(rodando) {
            System.out.println("Você gostaria de editar que pessoa?");
            System.out.println("1 - Funcionário");
            System.out.println("2 - Tutor");
            System.out.println("3 - Adotante");
            opcaoEscolhida = scanner.nextInt();
            if(opcaoEscolhida != 1 && opcaoEscolhida != 2 && opcaoEscolhida != 3 && opcaoEscolhida != 4){
                System.out.println("Opção inválida!");
            } else {
                rodando = false;
            }
        }

        if(opcaoEscolhida == 1){
            System.out.println("Digite o ID do Funcionário: ");
            idDaPessoa = scanner.nextInt();
            for (Pessoa pessoa : funcionarios){
                if(pessoa.containsKey("idFuncionario")){
                    if(pessoa.pegaValor("idFuncionario") == idDaPessoa){
                        System.out.println("Funcionário identificado.");
                        System.out.println(pessoa);
                        editarDadosBasicosPessoa(scanner, pessoa);
                        pessoaEditando = pessoa;
                        ehFuncionario = true;
                    }
                }
            }
        } else if(opcaoEscolhida == 2){
            System.out.println("Digite o ID do Tutor: ");
            idDaPessoa = scanner.nextInt();
            for (Pessoa pessoa : tutores){
                if(pessoa.containsKey("idTutor")){
                    if(pessoa.pegaValor("idTutor") == idDaPessoa){
                        System.out.println("Tutor identificado.");
                        System.out.println(pessoa);
                        editarDadosBasicosPessoa(scanner, pessoa);
                        pessoaEditando = pessoa;
                        ehTutor = true;
                    }
                }
            }
        } else {
            System.out.println("Digite o ID do Adotante: ");
            idDaPessoa = scanner.nextInt();
            for (Pessoa pessoa : adotantes){
                if(pessoa.containsKey("idAdotante")){
                    if(pessoa.pegaValor("idAdotante") == idDaPessoa){
                        System.out.println("Adotante identificado.");
                        System.out.println(pessoa);
                        editarDadosBasicosPessoa(scanner, pessoa);
                        pessoaEditando = pessoa;
                        ehAdotante = true;
                    }
                }
            }
        }

        if(ehFuncionario){
            System.out.println("\n- Edite os atributos específicos de funcionário -");

            Funcionario funcionario = (Funcionario) pessoaEditando;

            System.out.println("Data de Contratação (" + funcionario.getDataContratacao() + "): ");
            String dataDeContratacao = scanner.nextLine();
            if (!dataDeContratacao.isEmpty()) funcionario.setDataContratacao(dataDeContratacao);

            System.out.println("Cargo (" + funcionario.getCargo() + "): ");
            String cargo = scanner.nextLine();
            if(!cargo.isEmpty()) funcionario.setCargo(cargo);

            System.out.println("Salário: (" + funcionario.getSalario() + "): ");
            float salario = scanner.nextFloat();
            if(salario > 0) funcionario.setSalario(salario);

            scanner.nextLine();
            System.out.println("Departamento: (" + funcionario.getDepartamento() + "): ");
            String departamento = scanner.nextLine();
        if(!departamento.isEmpty()) funcionario.setDepartamento(departamento);
        }

        if(ehTutor){
            System.out.println("\n- Editar atributos específicos de tutor -");

            Tutor tutor = (Tutor) pessoaEditando;

            System.out.println("Número de Animais (" + tutor.getNumDeAnimais() + "): ");
            int numDeAnimais = scanner.nextInt();
            if(numDeAnimais > 0) tutor.setNumDeAnimais(numDeAnimais);

            scanner.nextLine();
            System.out.println("Adoções (" + tutor.getAdocoes() + "): ");
            String adocoes = scanner.nextLine();
            if(!adocoes.isEmpty()) tutor.setAdocoes(adocoes);

            System.out.println("Status (" + tutor.getStatus() + "): ");
            String status = scanner.nextLine();
            if(!status.isEmpty()) tutor.setStatus(status);
        }

        if(ehAdotante){
            System.out.println("\n- Editar atributos específicos de adotante -");

            Adotante adotante = (Adotante) pessoaEditando;

            System.out.println("Preferências de Adoção (" + adotante.getPreferenciasDeAdocao() + "): ");
            String preferenciasDeAdocao = scanner.nextLine();
            if(!preferenciasDeAdocao.isEmpty()) adotante.setPreferenciasDeAdocao(preferenciasDeAdocao);

            System.out.println("Adoções (" + adotante.getAdocoes() + "): ");
            String adocoes = scanner.nextLine();
            if(!adocoes.isEmpty()) adotante.setAdocoes(adocoes);

            System.out.println("Status (" + adotante.getStatus() + "): ");
            String status = scanner.nextLine();
            if(!status.isEmpty()) adotante.setStatus(status);
        }

        System.out.println("Informações da pessoa atualizadas com sucesso!");
        System.out.println(pessoaEditando);
    }

    private static void editarDadosBasicosPessoa(Scanner scanner, Pessoa pessoa){
        scanner.nextLine();
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
    }

    private static void relatorio(Scanner scanner){
        boolean opcaoEscolhidaValida = false;
        if(pessoas.isEmpty()){
            System.err.println("\nAinda não há pessoas registradas no sistema.");
            opcaoEscolhidaValida = true;
        }
        while(!opcaoEscolhidaValida) {
            System.out.println("Qual relatório você deseja?");
            System.out.println("1 - Pessoas Registradas");
            System.out.println("2 - Lista de Funcionários");
            System.out.println("3 - Lista de Tutores");
            System.out.println("4 - Lista de Adotantes");
            System.out.println("5 - Sair");

            int relatorioDesejado = scanner.nextInt();
            if(relatorioDesejado == 1){
                for(Pessoa pessoa : pessoas){
                    System.out.println(pessoa);
                    opcaoEscolhidaValida = true;
                }
            } else if(relatorioDesejado == 2){
                for(Pessoa pessoa : funcionarios){
                    System.out.println(pessoa);
                    opcaoEscolhidaValida = true;
                }
            } else if(relatorioDesejado == 3){
                for(Pessoa pessoa : tutores){
                    System.out.println(pessoa);
                    opcaoEscolhidaValida = true;
                }
            } else if(relatorioDesejado == 4){
                for(Pessoa pessoa : adotantes){
                    System.out.println(pessoa);
                    opcaoEscolhidaValida = true;
                }
            } else if(relatorioDesejado == 5){
                opcaoEscolhidaValida = true;
            } else {
                System.err.println("Opção inválida!");
            }
        }
    }
}
