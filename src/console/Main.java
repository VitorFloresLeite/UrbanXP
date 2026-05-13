package console;

import java.util.Scanner;
import modelo.*;
import servicos.*;

public class Main {

    public static void main(String[] args) {
        boolean programaLigado = true;
        int opcao;
        ClienteGerenciar gerenciador = new ClienteGerenciar();
        EventoGerenciar eventoGerenciador = new EventoGerenciar();
        Scanner scanner = new Scanner(System.in);

        while (programaLigado) {
            System.out.print("Digite o número do que deseja fazer \n");
            System.out.print("1 - Cadastrar evento \n2 - Cadastrar Cliente \n3- Emitir ingressos\n4 - Sair \n");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarEvento(scanner, eventoGerenciador);
                    break;
                case 2:
                    cadastrarCliente(scanner, gerenciador);
                    break;
                case 3:
                    break;
                case 4:
                    programaLigado = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }


    private static void cadastrarCliente(Scanner scanner, ClienteGerenciar gerenciador) {
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Digite o saldo do cliente:");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Escolha o perfil (1 - REGULAR, 2 - ESTUDANTE, 3 - PREMIUM):");
        int opcaoPerfil = scanner.nextInt();

        ClientePerfil perfilEscolhido = ClientePerfil.REGULAR;
        if(opcaoPerfil == 2) perfilEscolhido = ClientePerfil.ESTUDANTE;
        if(opcaoPerfil == 3) perfilEscolhido = ClientePerfil.PREMIUM;

        Cliente novoCliente = new Cliente(nome, saldo, perfilEscolhido);
        gerenciador.cadastrar(novoCliente);

        System.out.println("Cliente " + nome + " cadastrado com sucesso!\n");
    }


    private static void cadastrarEvento(Scanner scanner, EventoGerenciar gerenciador) {
        System.out.println("\n--- Cadastro de Experiência ---");
        System.out.println("1-Show | 2-Workshop | 3-Passeio");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Preço Base: ");
        String input = scanner.nextLine().replace(",", ".");
        double preco = Double.parseDouble(input);

        java.time.LocalDateTime agora = java.time.LocalDateTime.now();
        Experiencia novaExp = null;

        if (tipo == 1) {
            System.out.print("Artista Principal: ");
            String artista = scanner.nextLine();
            novaExp = new Show(titulo, "Show Musical", agora, 100, preco, artista);
        } else if (tipo == 2) {
            System.out.print("Materiais: ");
            String mat = scanner.nextLine();
            novaExp = new Workshop(titulo, "Workshop Prático", agora, 30, preco, mat);
        } else if (tipo == 3) {
            System.out.print("Ponto de Encontro: ");
            String ponto = scanner.nextLine();
            System.out.print("Guia: ");
            String guia = scanner.nextLine();
            novaExp = new PasseioTuristico(titulo, "Passeio Turístico", agora, 20, preco, ponto, guia);
        }

        if (novaExp != null) {
            gerenciador.cadastrar(novaExp);
            System.out.println("Evento cadastrado com sucesso!");
            System.out.println(novaExp.GerarResumo());
        }
    }
}
