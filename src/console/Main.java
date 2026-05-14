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

            // Substituído o try-catch repetitivo pelo método lerInteiro
            opcao = lerInteiro(scanner, "Opção: ");
            
            switch (opcao) {
                case 1:
                    System.out.println("\n------- Menu de Eventos ------");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Cadastrar Evento");
                    System.out.println("2 - Listar Eventos");
                    System.out.println("\n0 - Voltar");
                    System.out.println("------------------------------");

                    int subOpcao = lerInteiro(scanner, "Opção: ");

                    switch (subOpcao) {
                        case 0:
                            break;
                        case 1:
                            cadastrarEvento(scanner, eventoGerenciador);
                            break;
                        case 2:
                            listarEventos(scanner, eventoGerenciador);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;
                case 2:
                    System.out.println("\n------ Menu de Clientes ------");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Cadastrar Cliente");
                    System.out.println("2 - Listar Clientes");
                    System.out.println("\n0 - Voltar");
                    System.out.println("------------------------------");

                    subOpcao = lerInteiro(scanner, "Opção: ");

                    switch (subOpcao) {
                        case 0:
                            break;
                        case 1:
                            cadastrarCliente(scanner, clienteGerenciador);
                            break;
                        case 2:
                            listarClientes(clienteGerenciador);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Menu de Ingressos ---");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Emitir Ingresso");
                    System.out.println("2 - Listar Ingressos");
                    System.out.println("3 - Editar Status");
                    System.out.println("0 - Voltar");
                    System.out.println("-------------------------");
                    
                    subOpcao = lerInteiro(scanner, "Opção: ");
                    switch (subOpcao) {
                        case 0:
                            break;
                        case 1:
                            emitirIngresso(scanner, clienteGerenciador, eventoGerenciador, ingressoGerenciador);
                            break;
                        case 2:
                            listarIngressos(ingressoGerenciador);
                            break;
                        case 3:
                            editarStatusIngresso(ingressoGerenciador, scanner);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;
                case 4:
                    System.out.println("\nSaindo do programa...");
                    scanner.close();
                    programaLigado = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarCliente(Scanner scanner, ClienteGerenciar clienteGerenciador) {
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Escolha o perfil:");
        System.out.println("1 - Regular");
        System.out.println("2 - Estudante");
        System.out.println("3 - Premium");
        
        int opcaoPerfil = lerInteiro(scanner, "Opção: ");

        ClientePerfil perfilEscolhido = ClientePerfil.REGULAR;
        if(opcaoPerfil == 2) perfilEscolhido = ClientePerfil.ESTUDANTE;
        if(opcaoPerfil == 3) perfilEscolhido = ClientePerfil.PREMIUM;

        Cliente novoCliente = new Cliente(nome, perfilEscolhido);
        clienteGerenciador.cadastrar(novoCliente);

        System.out.println("Cliente " + nome + " cadastrado com sucesso!\n");
    }

    private static void listarEventos(Scanner scanner, EventoGerenciar gerenciador){
        System.out.println("\n--- Listar Eventos ---");
        System.out.println("Como deseja ordenar sua pesquisa?");
        System.out.println("1-Por nome");
        System.out.println("2-Por preço");
        System.out.println("3-Por data");

        int modo = lerInteiro(scanner, "Opção: ");
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
                System.out.println("Opção inválida para ordenação.");
                return;
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

    private static void cadastrarEvento(Scanner scanner, EventoGerenciar eventoGerenciador) {
        System.out.println("\n--- Cadastro de Evento ---");
        System.out.println("1-Show | 2-Workshop | 3-Passeio");
        int tipo = lerInteiro(scanner, "Opção: ");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Preço Base: ");
        String input = scanner.nextLine().replace(",", ".");
        double preco = Double.parseDouble(input);

        System.out.print("Data do Evento (DD/MM/AAAA): ");
        String dataInput = scanner.nextLine().trim();

        System.out.print("Hora do Evento (HH:MM): ");
        String horaInput = scanner.nextLine().trim();

        java.time.LocalDateTime dataHoraEvento;
        try {
            dataHoraEvento = java.time.LocalDateTime.parse(dataInput + " " + horaInput, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Formato de data/hora inválido. Cancelando cadastro.");
            return;
        }
        
        Experiencia novaExp = null;

        switch (tipo) {
            case 1:
                System.out.print("Artista Principal: ");
                String artista = scanner.nextLine();
                Show.Builder showBuilder = new Show.Builder(titulo, "Show Musical", dataHoraEvento, 100, preco, artista);
                preencherOpcionais(scanner, showBuilder);
                novaExp = showBuilder.build();
                break;
            case 2:
                System.out.print("Materiais: ");
                String mat = scanner.nextLine();
                Workshop.Builder workshopBuilder = new Workshop.Builder(titulo, "Workshop Prático", dataHoraEvento, 30, preco, mat);
                preencherOpcionais(scanner, workshopBuilder);
                novaExp = workshopBuilder.build();
                break;
            case 3:
                System.out.print("Ponto de Encontro: ");
                String ponto = scanner.nextLine();
                System.out.print("Nome do guia turístico: ");
                String guia = scanner.nextLine();
                PasseioTuristico.Builder passeioBuilder = new PasseioTuristico.Builder(titulo, "Passeio Turístico", dataHoraEvento, 20, preco, ponto, guia);
                preencherOpcionais(scanner, passeioBuilder);
                novaExp = passeioBuilder.build();
                break;
            default:
                System.out.println("Tipo de evento inválido.");
        }

        if (novaExp != null) {
            eventoGerenciador.cadastrar(novaExp);
            System.out.println("Evento cadastrado com sucesso!");
            System.out.println(novaExp.GerarResumo()); 
        }
    }

    private static void preencherOpcionais(Scanner scanner, Experiencia.Builder<?> builder) {
        System.out.print("Brindes (separados por vírgula, ou Enter para nenhum): ");
        String brindes = scanner.nextLine().trim();
        if (!brindes.isEmpty()) {
            for (String brinde : brindes.split(",")) {
                builder.adicionarBrinde(brinde.trim());
            }
        }

        System.out.print("Patrocinadores (separados por vírgula, ou Enter para nenhum): ");
        String patrocinadores = scanner.nextLine().trim();
        if (!patrocinadores.isEmpty()) {
            for (String patrocinador : patrocinadores.split(",")) {
                builder.adicionarPatrocinador(patrocinador.trim());
            }
        }

        System.out.print("Restrição de idade (ou Enter para nenhuma): ");
        String restricao = scanner.nextLine().trim();
        if (!restricao.isEmpty()) {
            builder.restricaoIdade(Integer.parseInt(restricao));
        }
    }

    private static void emitirIngresso(Scanner scanner, ClienteGerenciar clienteGerenciador, EventoGerenciar eventoGerenciador, IngressoGerenciar ingressoGerenciador) {
        System.out.println("\n--- Emissão de Ingresso ---");

        Cliente cliente = null;
        while (true) {
            System.out.print("Digite o nome do cliente (ou 0 para cancelar): ");
            String nomeCliente = scanner.nextLine().trim();
            if ("0".equals(nomeCliente)) return;
            cliente = clienteGerenciador.buscarPorNome(nomeCliente);
            if (cliente == null) {
                System.out.println("Cliente não encontrado.");
            } else break;
        }

        Experiencia evento = null;
        while (true) {
            System.out.println("Digite o título do evento (ou 0 para cancelar): ");
            String tituloEvento = scanner.nextLine().trim();
            if ("0".equals(tituloEvento)) return;
            evento = eventoGerenciador.buscarPorTitulo(tituloEvento);
            if (evento == null) {
                System.out.println("Evento não encontrado.");
            } else break;
        }

        PoliticaDesconto politica;
        boolean prioridade = false;
        ClientePerfil perfil = cliente.getPerfil();

        if (perfil == ClientePerfil.ESTUDANTE) {
            politica = new DescontoEstudante();
        } else if (perfil == ClientePerfil.PREMIUM) {
            politica = new DescontoPremium();
            prioridade = true;
        } else {
            politica = new DescontoRegular();
        }

        double valorFinal = politica.calcularValor(evento.getPrecoBase());
        Ingresso novoIngresso = new Ingresso(evento, cliente, valorFinal, IngressoStatus.RESERVADO, prioridade);
        ingressoGerenciador.cadastrar(novoIngresso);
        System.out.println("\nSucesso: ingresso emitido!");
        novoIngresso.exibirDetalhes();
    }
    
    private static void listarClientes(ClienteGerenciar gerenciador){
        System.out.println("\n--- Listar Clientes ---");
        List<Cliente> listaClientes = gerenciador.getListaClientes();
        if(listaClientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente cliente : listaClientes) {
            System.out.println("\n ---> " + cliente.getNome() + " | Perfil: " + cliente.getPerfil());
        }
    }
    
    private static void listarIngressos(IngressoGerenciar gerenciador){
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

        for (int i = 0; i < listaIngressos.size(); i++) {
            System.out.println("Número: " + (i + 1));
            listaIngressos.get(i).exibirDetalhes();
        }

        int escolhaIndex = lerInteiro(scanner, "Escolha o número (0 para cancelar): ");
        if (escolhaIndex == 0) return;

        Ingresso ingressoSelecionado = listaIngressos.get(escolhaIndex - 1);

        System.out.println("\nIngresso selecionado:");
        ingressoSelecionado.exibirDetalhes();

        System.out.println("\n1 - PAGO | 2 - RESERVADO | 3 - CANCELADO");

        int opcaoStatus;
        opcaoStatus = lerInteiro(scanner, "Novo status: ");
        scanner.nextLine();
        if (ingressoSelecionado.getStatus() != IngressoStatus.CANCELADO) {
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
        }else{
            System.out.println("\nO ingresso foi cancelado, status não pode mais ser atualizado");
        }
        
    }

   
    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = scanner.nextInt();
                scanner.nextLine(); 
                return valor;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: Digite um número válido.");
                scanner.nextLine(); 
            }
        }
    }
}
