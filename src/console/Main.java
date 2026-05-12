package console;
import java.util.Scanner;
import modelo.*;
import servicos.*;

public class Main {
    public static void main(String[] args) {
        boolean programaLigado = true;
        int opcao;
        ClienteGerenciar gerenciador = new ClienteGerenciar();
        Scanner scanner = new Scanner(System.in);
        
        while(programaLigado){//lopp que define o ciclo de execução do programa
            System.out.print("Digite o número do que deseja fazer \n");
            System.out.print("1 - Cadastrar evento \n2 - Cadastrar Cliente \n3- Emitir ingressos\n4 - Sair \n");
            opcao = scanner.nextInt();
            scanner.nextLine();//limpa o \n preso em nextInt
            
            switch (opcao) {
                case 1://Cadastrar Evento
                    
                    break;
                case 2://Cadastrar Cliente
                    cadastrarCliente(scanner, gerenciador);
                    break;
                case 3://Emitir ingresso

                    break;
                case 4://Sair
                    programaLigado=false;
                    //scanner.close();
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
        scanner.nextLine(); // Limpa o buffer

        System.out.println("Escolha o perfil (1 - REGULAR, 2 - ESTUDANTE, 3 - PREMIUM):");
        int opcaoPerfil = scanner.nextInt();
        
        ClientePerfil perfilEscolhido = ClientePerfil.REGULAR; // Padrão
        if(opcaoPerfil == 2) perfilEscolhido = ClientePerfil.ESTUDANTE;
        if(opcaoPerfil == 3) perfilEscolhido = ClientePerfil.PREMIUM;

        // Cria o objeto cliente (usando a classe Cliente ajustada com o Enum)
        Cliente novoCliente = new Cliente(nome, saldo, perfilEscolhido);
        
        // Envia para o serviço salvar
        gerenciador.cadastrar(novoCliente);
        
        System.out.println("Cliente " + nome + " cadastrado com sucesso!\n");
    }
}