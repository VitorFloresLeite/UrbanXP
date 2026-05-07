import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean ProgramaLigado = true;
        int opcao;
        
        while(ProgramaLigado){//lopp que define o ciclo de execução do programa
            System.out.print("Digite o número do que deseja fazer \n");
            System.out.print("1 - Cadastrar evento \n2 - Cadastrar Cliente \n3- Emitir ingressos\n4 - Sair \n");
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();
            if (opcao == 4) {
                ProgramaLigado = false;
            }else{
                System.out.println("Opção escolhida: " + opcao);
            }
        }
        
    }
}
