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

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1://menu de eventos
                    System.out.println("\n------- Menu de Eventos ------");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Cadastrar Evento");
                    System.out.println("2 - Listar Eventos");
                    
                    System.out.println("\n0 - Voltar");
                    System.out.println("------------------------------");

                    int subOpcao = scanner.nextInt();
                    scanner.nextLine();
                    
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
                    
                    subOpcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (subOpcao) {
                        case 0://voltar para o menu principal
                            break;
                        case 1:
                            cadastrarCliente(scanner, clienteGerenciador);
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
                    
                    subOpcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (subOpcao) {
                        case 0://voltar para o menu principal
                            break;
                        case 1:
                            emitirIngresso(scanner, clienteGerenciador, eventoGerenciador, ingressoGerenciador);
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
                    throw new AssertionError();
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
        System.out.print("Data e Hora do Evento (DD/MM/AAAA HH:MM): ");

        String dataHoraInput = scanner.nextLine();
        java.time.LocalDateTime dataHoraEvento = java.time.LocalDateTime.parse(dataHoraInput, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
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
                System.out.print("Guia: ");
                String guia = scanner.nextLine();
                novaExp = new PasseioTuristico(titulo, "Passeio Turístico", dataHoraEvento, 20, preco, ponto, guia);
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
}
