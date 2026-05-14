package console;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import modelo.*;
import servicos.*;

public class Main {

    public static void main(String[] args) {
        boolean programaLigado = true;
        int opcao;

        ClienteGerenciar clienteGerenciador = new ClienteGerenciar();
        EventoGerenciar eventoGerenciador = new EventoGerenciar();
        IngressoGerenciar ingressoGerenciador = new IngressoGerenciar();

        Scanner scanner = new Scanner(System.in);

        while (programaLigado) {
            System.out.println("\n------- Menu Principal -------");
            System.out.print("Qual menu deseja acessar? \n");
            System.out.print("1 - Menu de Eventos \n2 - Menu de Clientes \n3 - Menu de Ingressos\n4 - Sair \n");
            System.out.println("------------------------------");

            opcao = -1;
            while (true) {
                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // consome o newline restante
                    break; // entrada válida, sai do loop
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número correspondente às opções.");
                    scanner.nextLine(); // descarta a entrada inválida
                }
            }
            
            switch (opcao) {
                case 1://menu de eventos
                    System.out.println("\n------- Menu de Eventos ------");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Cadastrar Evento");
                    System.out.println("2 - Listar Eventos");
                    
                    System.out.println("\n0 - Voltar");
                    System.out.println("------------------------------");

                    int subOpcao = -1;
                    while (true) {
                        try {
                            subOpcao = scanner.nextInt();
                            scanner.nextLine(); // consome o newline restante
                            break; // entrada válida, sai do loop
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número correspondente às opções.");
                            scanner.nextLine(); // descarta a entrada inválida
                        }
                    }

                    switch (subOpcao) {
                        case 0://voltar para o menu principal
                            break;
                        case 1:
                            cadastrarEvento(scanner, eventoGerenciador);
                            break;
                        case 2:
                            ListarEventos(scanner, eventoGerenciador);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                case 2://menu de clientes
                    System.out.println("\n------ Menu de Clientes ------");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Cadastrar Cliente");
                    System.out.println("2 - Listar Clientes");
                    
                    System.out.println("\n0 - Voltar");
                    System.out.println("------------------------------");

                    subOpcao = -1;
                    while (true) {
                        try {
                            subOpcao = scanner.nextInt();
                            scanner.nextLine(); // consome o newline restante
                            break; // entrada válida, sai do loop
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número correspondente às opções.");
                            scanner.nextLine(); // descarta a entrada inválida
                        }
                    }

                    switch (subOpcao) {
                        case 0://voltar para o menu principal
                            break;
                        case 1:
                            cadastrarCliente(scanner, clienteGerenciador);
                            break;
                        case 2:
                            ListarClientes(clienteGerenciador);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                case 3://menu de ingressos
                    System.out.println("\n--- Menu de Ingressos ---");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Emitir Ingresso");
                    System.out.println("2 - Listar Ingressos");
                    
                    System.out.println("0 - Voltar");
                    System.out.println("-------------------------");
                    
                    subOpcao = -1;
                    while (true) {
                        try {
                            subOpcao = scanner.nextInt();
                            scanner.nextLine(); // consome o newline restante
                            break; // entrada válida, sai do loop
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número correspondente às opções.");
                            scanner.nextLine(); // descarta a entrada inválida
                        }
                    }
                    switch (subOpcao) {
                        case 0://voltar para o menu principal
                            break;
                        case 1:
                            emitirIngresso(scanner, clienteGerenciador, eventoGerenciador, ingressoGerenciador);
                            break;
                        case 2:
                            ListarIngressos(ingressoGerenciador);
                            break;
                        case 3:
                            editarStatusIngresso(ingressoGerenciador, scanner);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                case 4:
                    System.out.println("\nSaindo do programa...");
                    scanner.close();
                    programaLigado = false;
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }


    private static void cadastrarCliente(Scanner scanner, ClienteGerenciar clienteGerenciador) {
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Digite o saldo do cliente:");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Escolha o perfil:");
        System.out.println("1 - Regular");
        System.out.println("2 - Estudante");
        System.out.println("3 - Premium");
        
        int opcaoPerfil = scanner.nextInt();

        ClientePerfil perfilEscolhido = ClientePerfil.REGULAR;
        if(opcaoPerfil == 2) perfilEscolhido = ClientePerfil.ESTUDANTE;
        if(opcaoPerfil == 3) perfilEscolhido = ClientePerfil.PREMIUM;

        Cliente novoCliente = new Cliente(nome, saldo, perfilEscolhido);
        clienteGerenciador.cadastrar(novoCliente);

        System.out.println("Cliente " + nome + " cadastrado com sucesso!\n");
    }

    private static void ListarEventos(Scanner scanner, EventoGerenciar gerenciador){//SEM SUPORTE A INFORMAÇÕES EXTRAS
        System.out.println("\n--- Listar Eventos ---");
        System.out.println("Como deseja ordenar sua pesquisa?");
        System.out.println("1-Por nome");
        System.out.println("2-Por preço");
        System.out.println("3-Por data");

        int modo = scanner.nextInt();
        List<Experiencia> listaEventos = gerenciador.listarTodos();
        
        if(listaEventos.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }

        switch(modo){
            case 1:
                listaEventos.sort(Comparator.comparing(Experiencia::getTitulo));
                break;
            case 2:
                listaEventos.sort(Comparator.comparing(Experiencia::getPrecoBase));
                break;
            case 3:
                listaEventos.sort(Comparator.comparing(Experiencia::getDataHora));
                break;
            default:
                throw new AssertionError();
        }

        for (Experiencia experiencia : listaEventos) {
            String tipo = "";
            if(experiencia instanceof Show){
                tipo = "( Show )";
            }else if(experiencia instanceof Workshop){
                tipo = "( Workshop )";
            }else if(experiencia instanceof PasseioTuristico){
                tipo = " ( Passeio turístico ) ";
            }

            System.out.println("\n ---> " + tipo + experiencia.getTitulo() + ": R$" + experiencia.getPrecoBase());
        }
    }

    private static void cadastrarEvento(Scanner scanner, EventoGerenciar eventoGerenciador) {//ERRO: CADASTRO DE EVENTOS != SHOW SEM COERÊNCIA DE DADOS
        System.out.println("\n--- Cadastro de Evento ---");
        System.out.println("1-Show | 2-Workshop | 3-Passeio");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Preço Base: ");
        String input = scanner.nextLine().replace(",", ".");
        double preco = Double.parseDouble(input);

        System.out.print("Data do Evento (DD/MM/AAAA): ");
        String dataInput = null;
    
        try {//por segurança, para evitar que o programa quebre caso o usuário insira um formato de data inválido
            dataInput = scanner.nextLine().trim();
        } catch (Exception e) {
            System.out.println("Data inválida.");
        }

        if (dataInput == null || dataInput.isEmpty()) {//verificação adicional para garantir que a data foi lida corretamente
            System.out.println("Falha ao ler a data. Cancelando cadastro.");
            return;
        }

        System.out.print("Hora do Evento (HH:MM): ");
        String horaInput = null;

        try {//mesma lógica de segurança para a hora
            horaInput = scanner.nextLine().trim();
        } catch (Exception e) {
            System.out.println("Hora inválida.");
        }

        if (horaInput == null || horaInput.isEmpty()) {
            System.out.println("Falha ao ler a hora. Cancelando cadastro.");
            return;
        }

        java.time.LocalDateTime dataHoraEvento;
        try {
            dataHoraEvento = java.time.LocalDateTime.parse(dataInput + " " + horaInput, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Formato de data/hora inválido. Cancelando cadastro.");
            return;
        }
        Experiencia novaExp = null;

        switch (tipo) {//Campos não especificados pelo atendente, mas necessários para o cadastro de cada tipo de evento
            case 1:
                System.out.print("Artista Principal: ");
                String artista = scanner.nextLine();
                novaExp = new Show(titulo, "Show Musical", dataHoraEvento, 100, preco, artista);
                break;
            case 2:
                System.out.print("Materiais: ");
                String mat = scanner.nextLine();
                novaExp = new Workshop(titulo, "Workshop Prático", dataHoraEvento, 30, preco, mat);
                break;
            case 3:
                System.out.print("Ponto de Encontro: ");
                String ponto = scanner.nextLine();
                System.out.print("Nome do guia turístico: ");
                String guia = scanner.nextLine();
                novaExp = new PasseioTuristico(titulo, "Passeio Turístico", dataHoraEvento, 20, preco, ponto, guia);
                break;
            default:
                System.out.println("Tipo de evento inválido.");
        }

        if (novaExp != null) {
            eventoGerenciador.cadastrar(novaExp);
            System.out.println("Evento cadastrado com sucesso!");
            novaExp.GerarResumo();
        }
    }
    
    private static void emitirIngresso(Scanner scanner, ClienteGerenciar clienteGerenciador, EventoGerenciar eventoGerenciador, IngressoGerenciar ingressoGerenciador) {
        System.out.println("\n--- Emissão de Ingresso ---");
        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = clienteGerenciador.buscarPorNome(nomeCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Digite o título do evento:");
        String tituloEvento = scanner.nextLine();
        Experiencia evento = eventoGerenciador.buscarPorTitulo(tituloEvento);

        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        ClientePerfil perfil = cliente.getPerfil();
        PoliticaDesconto politica;
        boolean prioridade = false;

        if (perfil == ClientePerfil.ESTUDANTE){
            politica = new DescontoEstudante();
        }else if (perfil == ClientePerfil.PREMIUM){
            politica = new DescontoPremium();
            prioridade = true;
        }else {
            politica = new DescontoRegular();
        }

        double valorFinal = politica.calcularValor(evento.getPrecoBase());
        Ingresso novoIngresso = new Ingresso(evento, cliente, valorFinal, IngressoStatus.RESERVADO, prioridade);
        ingressoGerenciador.cadastrar(novoIngresso);

        System.out.println("\nSucesso: ingresso emitido para " + cliente.getNome());
        System.out.printf("Evento: %s | Valor final: R$ %.2f | Prioridade: %s\n\n", evento.getTitulo(), valorFinal, (prioridade ? "Sim" : "Não"));
    }
    
    private static void ListarClientes(ClienteGerenciar gerenciador){
        System.out.println("\n--- Listar Clientes ---");
        List<Cliente> listaClientes = gerenciador.getListaClientes();

        if(listaClientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente cliente : listaClientes) {
            System.out.println("\n ---> " + cliente.getNome() + " | Saldo: R$" + cliente.getSaldo() + " | Perfil: " + cliente.getPerfil());
        }
    }
    
    private static void ListarIngressos(IngressoGerenciar gerenciador){
        System.out.println("\n--- Listar Ingressos ---");
        List<Ingresso> listaIngressos = gerenciador.listarTodos();

        if(listaIngressos.isEmpty()){
            System.out.println("Nenhum ingresso emitido.");
            return;
        }

        for (Ingresso ingresso : listaIngressos) {
            ingresso.exibirDetalhes();
        }
    }
    private static void editarStatusIngresso(IngressoGerenciar gerenciador, Scanner scanner) {
        System.out.println("\n--- Editar Status do Ingresso ---");
        List<Ingresso> listaIngressos = gerenciador.listarTodos();

        if (listaIngressos.isEmpty()) {
            System.out.println("Nenhum ingresso emitido.");
            return;
        }

        // Listar verticalmente com números
        for (int i = 0; i < listaIngressos.size(); i++) {
            Ingresso ing = listaIngressos.get(i);
            System.out.println("\n**********************************");
            System.out.println("Número: " + (i + 1));
            ing.exibirDetalhes();
        }

        System.out.print("\nEscolha o número do ingresso que deseja alterar (0 para cancelar): ");
        int escolhaIndex;
        try {
            escolhaIndex = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Cancelando operação.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine(); // limpar buffer

        if (escolhaIndex == 0) {
            System.out.println("Operação cancelada.");
            return;
        }
        if (escolhaIndex < 1 || escolhaIndex > listaIngressos.size()) {
            System.out.println("Número inválido.");
            return;
        }

        Ingresso ingressoSelecionado = listaIngressos.get(escolhaIndex - 1);

        System.out.println("\nIngresso selecionado:");
        ingressoSelecionado.exibirDetalhes();

        System.out.println("\nSelecione o novo status:");
        System.out.println("1 - PAGO");
        System.out.println("2 - RESERVADO");
        System.out.println("3 - CANCELADO");
        System.out.print("Opção: ");

        int opcaoStatus;
        try {
            opcaoStatus = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Cancelando operação.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        switch (opcaoStatus) {
            case 1:
                ingressoSelecionado.setStatus(IngressoStatus.PAGO);
                break;
            case 2:
                ingressoSelecionado.setStatus(IngressoStatus.RESERVADO);
                break;
            case 3:
                ingressoSelecionado.setStatus(IngressoStatus.CANCELADO);
                break;
            default:
                System.out.println("Opção de status inválida. Nenhuma alteração realizada.");
                return;
        }

        System.out.println("Status do ingresso atualizado com sucesso para: " + ingressoSelecionado.getStatus());
    }
}

