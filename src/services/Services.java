package services;
import com.sun.tools.javac.Main;
import java.text.SimpleDateFormat;
import java.util.*;
import model.*;

public class Services {

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

    // Método utilizado para criar um usuário do tipo Pessoa
    public static void criarPessoa(Scanner scanner) {
        // Inicializando o menu de criar nova Pessoa:
        System.out.println("\n--- Criar Nova Pessoa ---");

        // Obtendo informações importantes da pessoa cadastrada:
        System.out.print("Nome Completo: ");
        String nome = scanner.nextLine();

        System.out.print("Data de Nascimento: ");
        String dataDeNascimento = scanner.nextLine();

        System.out.print("Gênero (digite o número correspondente): ");
        System.out.println("\n1 - Homem");
        System.out.println("2 - Mulher");
        System.out.println("3 - Não-binário");
        int generoEscolha = scanner.nextInt();

        /* Tratamento de opções para a escolha de gênero
        feita pelo usuário, que caso o usuário selecione um 
        número além dos parametrizados, é retornada uma mensagem
        de erro.*/
        String genero = switch (generoEscolha) {
            case 1 -> "Homem";
            case 2 -> "Mulher";
            case 3 -> "Não-binário";
            default -> {
                System.err.println("Você digitou um número inválido.");
                yield "Indefinido";
            }
        };

        // Ainda obtendo mais informações da pessoa cadastrada:
        scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        /* Obtendo um e-mail e uma senha para facilitar 
        o login da pessoa cadastrada.*/
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // Criando a nova pessoa com as informações obtidas.
        Pessoa novaPessoa = new Pessoa(nome, dataDeNascimento, genero, cpf,
                endereco, telefone, email, senha);

        System.out.println("Primeira parte do cadastro feita.");
        System.out.println(novaPessoa);

        // Configurando qual será o tipo ou ocupação da pessoa cadastrada.:
        boolean cadastrando = true;
        int escolhaContinuar;
        // Enqunto cadastrando = true, irá executar essas ações:
        do {
            // Inicializando o menu de cadastro de pessoas
            System.out.println("Esta pessoa será um: ");
            System.out.println("1 - Funcionário");
            System.out.println("2 - Tutor");
            System.out.println("3 - Adotante");
            int escolha = scanner.nextInt();

            // A partir da escolha, verifica: a pessoa registrada já tem um id correspondente com a opção escolhida?
            Map<String, Integer> papeisPessoa = novaPessoa.getPapeis();
            System.out.println(novaPessoa);
            switch(escolha){
                // Inicializando o case de funcionário:
                case 1:
                    /* Caso o funcionário não possua um id correspondente com a opção escolhida,
                    é criado um novo id para ele, implementando apenas o id anterior. Caso o mesmo 
                    já exista, é retornada uma mensagem de funcionário já existente, e o case
                    de funcionário é encerrado. */
                    if(papeisPessoa.containsKey("idFuncionario")){
                        System.out.println("Essa pessoa já está cadastrada como Funcionário!");
                        break;
                    }
                    idFuncionario++;
                    System.out.println("Cadastrando Funcionário. ID: " + idFuncionario);

                    // Obtendo as informações do funcionário:
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

                    /*  Atribuindo ao funcionário os campos/informações necessários para 
                    a finalização de seu cadastro. */
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
                    /* Adicionando um novo funcionário à lista de funcionários, e um
                    novo cargo/papel à nova pessoa criada (funcionário). */       
                    funcionarios.add(novoFuncionario);
                    novaPessoa.addPapel("idFuncionario", idFuncionario);
                    // Encerrando o case de funcionário.
                    cadastrando = false;
                    break;
                // Inicializando o case de tutor:    
                case 2:
                    /* Assim como em funcionários, caso já exista um tutor 
                    verificado pelo seu id, o case de tutores é quebrado,
                    caso contrário, dá-se procedimento à criação do novo tutor. */ 
                    if(papeisPessoa.containsKey("idTutor")){
                        System.out.println("Essa pessoa já está cadastrada como Tutor!");
                        break;
                    }
                    idTutor++;
                    System.out.println("Cadastrando Tutor. ID: " + idTutor);

                    // Obtendo as informações necessárias para o cadastro do tutor:
                    System.out.println("Número de Animais sob Custódia: ");
                    int numDeAnimais = scanner.nextInt();

                    scanner.nextLine();
                    System.out.println("Histórico de Adoções: ");
                    String adocoesTutor = scanner.nextLine();

                    System.out.println("Status: ");
                    String statusTutor = scanner.nextLine();

                    /*  Atribuindo ao tutor os campos/informações necessários para 
                    a finalização de seu cadastro. */
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
                    /* Adicionando um novo tutor à lista de tutores, e um
                    novo cargo/papel à nova pessoa criada (tutor). */  
                    tutores.add(novoTutor);
                    novaPessoa.addPapel("idTutor", idTutor);
                    // Encerrando o case de tutores.
                    cadastrando = false;
                    break;
                // Inicializando case de adotantes:
                case 3:
                    /* Assim como em funcionários e tutores, realiza-se a 
                    verificação se o id do adotante já existe, e caso positivo, 
                    o case de adotantes é quebrado. Caso contrário, é cadastrado 
                    um novo adotante incrementando apenas o id anterior. */
                    if(papeisPessoa.containsKey("idAdotante")){
                        System.out.println("Essa pessoa já está cadastrada como Adotante!");
                        break;
                    }
                    idAdotante++;
                    System.out.println("Cadastrando Adotante. ID: " + idAdotante);

                    scanner.nextLine();
                    // Obtendo as informações necessárias para o cadastro do adotante:
                    System.out.println("Preferências de Adoção: ");
                    String preferenciasDeAdocao = scanner.nextLine();

                    System.out.println("Histórico de Adoções Realizadas: ");
                    String adocoesAdotante = scanner.nextLine();

                    System.out.println("Status: ");
                    String statusAdotante = scanner.nextLine();

                    /*  Atribuindo ao adotante os campos/informações necessários para 
                    a finalização de seu cadastro. */
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
                    /* Adicionando um novo adotante à lista de adotantes, e um
                    novo cargo/papel à nova pessoa criada (adotante). */  
                    adotantes.add(novoAdotante);
                    novaPessoa.addPapel("idAdotante", idAdotante);
                    // Encerrando o case de adotantes.
                    cadastrando = false;
                    break;
                /* Inicializando e tratando a verificação da seleção de uma
                opção inválida ou inexistente. */ 
                default:
                    System.err.println("Por favor, digite um número válido.");
                    break;
            }
            /* Enquanto escolhaContinuar = 1, o valor de cadastrando se torna
            true, e o ciclo de cadastro de nova Pessoa se inicia novamente. 
            Caso escolhaContinuar seja igual a 2, o valor de cadastrando se torna
            false e o ciclo é encerrado. Caso nenhuma opção seja selecionada, é pedido 
            ao usuário que digite uma opção válida para a verificação atual.*/ 
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

    // Método para exibir as informações de uma pessoa selecionada pelo usuário.
    public static void exibirPessoa(Scanner scanner) {
        int id, escolha;
        boolean achado = false;
        // Enquanto achado for false, são executadas essas ações:
        do {
            // Inicializando o menu de obtenção de informações de uma pessoa:
            System.out.println("Você deseja obter as informações de que pessoa?");
            System.out.println("1 - Um Funcionário");
            System.out.println("2 - Um Tutor");
            System.out.println("3 - Um Adotante");
            int opcao = scanner.nextInt();

            /* De acordo com a opção selecionada, o usuário digitará o id do
            papel/cargo da pessoa correspondente à opção (Ex: idAdotante ou idTutor),
            e então as informações da pessoa selecionada serão exibidas, e o valor
            de "achado" será alterado para true.*/
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
                /* Realizando o tratamento de caso o usuário selecione uma opção
                inválida ou inexistente. */
                default:
                    System.out.println("Digite um número válido.");
                    break;
            }
            /* Caso achado = false, ou seja, a pessoa procurada pelo usuário não
            foi encontrada, é retornada uma mensagem de erro apontando que não foi
            possível encontrá-la, e é oferecida ao usuário a possibilidade de tentar
            buscar novamente a pessoa.*/
            if(!achado){
                do {
                    System.err.println("Não conseguimos achar este ID.");
                    /* Trazendo ao usuário a possibilidade de tentar buscar novamente,
                    baseado no valor de "escolha": caso corresponda aos números, serão
                    realizadas as determinadas ações, caso corresponda a um número
                    inexistente ou inválido, é retornada uma mensagem de erro para que
                    o usuário digite uma opção válida.*/
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

    // Método para editar as informações de pessoa
    public static void editarPessoa(Scanner scanner) {
        /* Configurando informações de verificação do cargo/papel da
        pessoa e de validações dos laços de repetição. */
        int opcaoEscolhida = 0;
        int idDaPessoa;
        boolean rodando = true;
        boolean ehFuncionario = false;
        boolean ehTutor = false;
        boolean ehAdotante = false;
        Pessoa pessoaEditando = null;
        // Inicializando o menu de edição de pessoa:
        System.out.println("\n--- Editar Pessoa ---");

        // Enquanto rodando for true, serão exibidas as opções de edição de pessoa ao usuário.
        while(rodando) {
            // Apresentando as opções de edição de pessoa ao usuário:
            System.out.println("Você gostaria de editar que pessoa?");
            System.out.println("1 - Funcionário");
            System.out.println("2 - Tutor");
            System.out.println("3 - Adotante");
            opcaoEscolhida = scanner.nextInt();
            /* Caso a opção escolhida corresponda a um dos itens apresentados,
            "rodando" se torna false e então o menu de edição de pessoa é fechado.
            Caso contrário, é exibida a mensagem de opção inválida.*/
            if(opcaoEscolhida != 1 && opcaoEscolhida != 2 && opcaoEscolhida != 3){
                System.out.println("Opção inválida!");
            } else {
                rodando = false;
            }
        }

        /* Se a opção corresponder a funcionário, será buscado o
        id do funcionário que o usuário deseja editar, e caso o funcionário
        seja encontrado, as informações do mesmo poderão ser editadas por
        meio do método "editarDadosBasicosPessoa()", e então a pessoaEditando
        receberá o cargo de funcionário, e a boolean "ehFuncionario" será true, o que
        encerrará o laço de repetição. */
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
        }
        /* Se a opção corresponder a tutor, será buscado o
        id do tutor que o usuário deseja editar, e caso o tutor
        seja encontrado, as informações do mesmo poderão ser editadas por
        meio do método "editarDadosBasicosPessoa()", e então a pessoaEditando
        receberá o cargo de tutor, e a boolean "ehTutor" será true. */
        else if(opcaoEscolhida == 2){
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
        }
        /* Se a opção corresponder a adotante, será buscado o
        id do adotante que o usuário deseja editar, e caso o adotante
        seja encontrado, as informações do mesmo poderão ser editadas por
        meio do método "editarDadosBasicosPessoa()", e então a pessoaEditando
        receberá o cargo de adotante, e a boolean "ehAdotante" será true. */
        else if (opcaoEscolhida == 3){
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
        /* Caso o usuário selecione uma opção inválida ou inexistente,
        ele terá a possibilidade de decidir se deseja tentar ou não
        editar a pessoa novamente.*/
        else {
            int escolha;
            do {
                System.err.println("Opção inválida ou inexistente.");
                System.out.println("Deseja tentar novamente? \n1 - Sim | 2 - Não");
                escolha = scanner.nextInt();
                if(escolha == 2) {
                    rodando = false;
                    break;
                } else if(escolha == 1){
                    System.out.println("\n");
                    rodando = true;
                } else {
                    System.err.println("Digite uma opção válida.");
                }
            } while(escolha != 1 && escolha != 2);
        }

        /* Caso a pessoa selecionada pelo usuário para edição seja um funcionário,
        será permitida a edição das informações específicas de funcionário, como por
        exemplo a data de contratação ou o departamento.*/
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

        /* Caso a pessoa selecionada pelo usuário para edição seja um tutor,
        será permitida a edição das informações específicas de tutor, como por
        exemplo o número de animais do tutor e as adoções realizadas pelo mesmo.*/
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

        /* Caso a pessoa selecionada pelo usuário para edição seja um adotante,
        será permitida a edição das informações específicas de adotante, como por
        exemplo suas preferências de adoção e seu status.*/
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

    /* Método utilizado para alterar informações básicas de uma pessoa, informações
    essas que toda Pessoa, seja ela funcionário, tutor ou adotante terá, como CPF,
    gênero, email, senha... */
    public static void editarDadosBasicosPessoa(Scanner scanner, Pessoa pessoa){
        scanner.nextLine();
        // Permitindo a alteração do nome da pessoa.
        System.out.print("Nome (" + pessoa.getNome() + "): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) pessoa.setNome(nome);

        // Permitindo a alteração da data de nascimento da pessoa.
        System.out.print("Data de Nascimento (" + pessoa.getDataDeNascimento() + "): ");
        String dataDeNascimento = scanner.nextLine();
        if (!dataDeNascimento.isEmpty()) pessoa.setDataDeNascimento(dataDeNascimento);

        // Permitindo a alteração do gênero da pessoa.
        System.out.print("Gênero (" + pessoa.getGenero() + "): ");
        String genero = scanner.nextLine();
        if (!genero.isEmpty()) pessoa.setGenero(genero);

        // Permitindo a alteração do CPF de cadastro da pessoa.
        System.out.print("CPF (" + pessoa.getCpf() + "): ");
        String cpf = scanner.nextLine();
        if (!cpf.isEmpty()) pessoa.setCpf(cpf);

        // Permitindo a alteração do endereço da pessoa.
        System.out.print("Endereço (" + pessoa.getEndereco() + "): ");
        String endereco = scanner.nextLine();
        if (!endereco.isEmpty()) pessoa.setEndereco(endereco);

        // Permitindo a alteração do telefone da pessoa.
        System.out.print("Telefone (" + pessoa.getTelefone() + "): ");
        String telefone = scanner.nextLine();
        if (!telefone.isEmpty()) pessoa.setTelefone(telefone);

        // Permitindo a alteração do e-mail de cadastro da pessoa.
        System.out.print("Email (" + pessoa.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) pessoa.setEmail(email);

        // Permitindo a alteração da senha de cadastro da pessoa.
        System.out.print("Senha (" + pessoa.getSenha() + "): ");
        String senha = scanner.nextLine();
        if (!senha.isEmpty()) pessoa.setSenha(senha);
    }

    // Método utilizado para a geração de relatórios.
    public static void relatorio(Scanner scanner){
        /* Configurando a variável opcaoEscolhidaValida como false
        para que seja disponibilizado de primeira o menu de relatórios. */
        boolean opcaoEscolhidaValida = false;
        /* Caso a lista de pessoas esteja vazia, é retornada uma mensagem
        apontando que a lista está vazia, e a variável opcaoEscolhidaValida é
        setada como true, para que o menu de relatórios não seja executado. */
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

            /* De acordo com a opção selecionada pelo usuário,
            será realizada a ação correspondente exibida no menu de relatórios,
            exibindo o relatório através de um laço de repetição que percorre
            as listas dos itens correspondentes selecionados pelo usuário. */
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
            }
            /* Caso a opção selecionada pelo usuário seja para
            sair, a variável opcaoEscolhaValida é setada como true,
            e então o método para de rodar, e o menu de relatórios
            é fechado. */
            else if(relatorioDesejado == 5){
                opcaoEscolhidaValida = true;
            } else {
                System.err.println("Opção inválida!");
            }
        }
    }

    public static void criarAnimal(Scanner scanner){

        // Inicializando o menu de criar nova Pessoa:
        System.out.println("\n--- Criar Novo Animal ---");

        // Obtendo informações importantes da pessoa cadastrada:
        System.out.println("Nome do animal: ");
        String nome = scanner.nextLine();

        System.out.println("Espécie: ");
        String especie = scanner.nextLine();

        System.out.println("Raça: ");
        String raca = scanner.nextLine();

        System.out.println("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Sexo (digite o número correspondente): ");
        System.out.println("1 - Macho ");
        System.out.println("2 - Fêmea ");
        int generoEscolha = scanner.nextInt();
        scanner.nextLine();

        String genero = switch (generoEscolha) {
            case 1 -> "Macho";
            case 2 -> "Fêmea";
            default -> {
                System.err.println("Você digitou um número inválido.");
                yield "Indefinido";
            }
        };

        int saudeAnimal = 0;
        String historicoMedico = "";
        while (saudeAnimal != 1 && saudeAnimal != 2){
            System.out.println("O animal possui algum problema de saúde? (digite o número correspondente): ");
            System.out.println("1 - Sim ");
            System.out.println("2 - Não ");
            saudeAnimal = scanner.nextInt();
            scanner.nextLine();

            switch (saudeAnimal) {
                case 1:
                    System.out.println("Qual o problema de saúde do animal? (digite abaixo)");
                    historicoMedico = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Ótimo, vamos prosseguir com o cadastro");
                    historicoMedico = "Saudável";
                    break;
                default:
                    System.err.println("Digite uma opção válida.");
                    break;
            };
        }

        System.out.println("Qual a data de resgate do animal? (Insira no seguinte formato: 'dd/MM/yyyy')");
        String dataResgate = scanner.nextLine();

//        System.out.print("Qual foi o dia do mês em que ocorreu o resgate? ");
//        int diaResgate = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.print("Qual foi o mês em que ocorreu o resgate? ");
//        int mesResgate = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.print("Qual foi o ano em que ocorreu o resgate? ");
//        int anoResgate = scanner.nextInt();
//        scanner.nextLine();
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        String dateString = format.format(new Date());
//        Date date = format.parse ("2009-12-31");

        System.out.println("Qual é o status de adoção do animal? (digite a opção correspondente:)");
        System.out.println("1 - Disponível");
        System.out.println("2 - Reservado");
        System.out.println("3 - Adotado");
        System.out.println("4 - Adoção temporária (lar temporário)");
        int statusEscolhido = scanner.nextInt();
        scanner.nextLine();

        String statusAdocao = "";
        while (statusEscolhido != 1 &&
               statusEscolhido != 2 &&
               statusEscolhido != 3 &&
               statusEscolhido != 4){
            switch (statusEscolhido){
                case 1:
                    statusAdocao = "Disponível";
                    break;
                case 2:
                    statusAdocao = "Reservado";
                    break;
                case 3:
                    statusAdocao = "Adotado";
                    break;
                case 4:
                    statusAdocao = "Adoção temporária (lar temporário)";
                    break;
                default:
                    System.err.println("Você digitou um número inválido. Digite novamente");
                    break;
            }
        }

        Animal novoAnimal = new Animal(
                nome,
                especie,
                raca,
                idade,
                genero,
                historicoMedico,
                dataResgate,
                "",
                statusAdocao
        );
    }
    public static void exibirPessoasTabela() {
        String linha = "+----------------+----------------+-------------+-------------+--------------+----------------+---------------------+-----------------------------+-----------------------+";
        System.out.println(linha);
        System.out.printf("| %-14s | %-14s | %-11s | %-11s | %-12s | %-14s | %-19s | %-27s | %-21s |%n", "Nome", "Data Nasc.", "Gênero", "CPF", "Endereço", "Telefone", "Email", "Cargos", "Data Contratação");
        System.out.println(linha);

        for (Pessoa pessoa : pessoas) {
            String cargos = String.join(", ", pessoa.getPapeis().keySet());
            String dataContratacao = "";

            if (pessoa instanceof Funcionario) {
                dataContratacao = ((Funcionario) pessoa).getDataContratacao();
            }

            System.out.printf("| %-14s | %-14s | %-11s | %-11s | %-12s | %-14s | %-19s | %-27s | %-21s |%n", pessoa.getNome(), pessoa.getDataDeNascimento(), pessoa.getGenero(), pessoa.getCpf(), pessoa.getEndereco(), pessoa.getTelefone(), pessoa.getEmail(), cargos, dataContratacao);
        }
        System.out.println(linha);
    }

    public static void exibirAnimaisTabela() {
        String linha = "+----------------+----------------+-------------+-------------+--------------+----------------+---------------------+-----------------------------+-----------------------+";
        System.out.printf("| %-20s | %-20s | %-14s | %-10s | %-12s | %-20s | %-20s | %-25s |\n", 
                "Nome", "Espécie", "Raça", "Idade", "Sexo", "Histórico Médico", "Data do Resgate", "Status da Adoção");
        System.out.println(linha);

        for (Animal animal : Main.animais) {
            System.out.printf("| %-20s | %-20s | %-14s | %-10d | %-12s | %-20s | %-20s | %-25s |\n", 
                    animal.getNome(), 
                    animal.getEspecie(), 
                    animal.getRaca(), 
                    animal.getIdade(), 
                    animal.getSexo(), 
                    animal.getHistoricoMedico(), 
                    animal.getDataDeResgate(), 
                    animal.getStatusDeAdocao());
        }
        System.out.println(linha);
    }


}
