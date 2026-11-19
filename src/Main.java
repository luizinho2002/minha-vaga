import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        // Permite receber informações digitadas no terminal
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a empresa: ");
        String empresa = scanner.nextLine();

        System.out.print("Digite o cargo: ");
        String cargo = scanner.nextLine();

        // Impede que a empresa fique vazia
        if (empresa.isBlank()) {
            System.out.println("O nome da empresa é obrigatório.");
            scanner.close();
            return;
        }


                 // Impede que o cargo fique vazio
        if (cargo.isBlank()) {
            System.out.println("O nome do cargo é obrigatório.");
            scanner.close();
            return;
        }

        exibirMensagem("Dados recebidos com sucesso!");

        exibirOportunidade(empresa, cargo);

        scanner.close();
    }

    // Exibe os dados de uma oportunidade
    public static void exibirOportunidade(String empresa, String cargo) {
        System.out.println("\n=== Oportunidade ===");
        System.out.println("Empresa: " + empresa);
        System.out.println("Cargo: " + cargo);
    }

    // Exibe uma mensagem recebida pelo método
    public static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}