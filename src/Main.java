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

        System.out.println("\n=== Oportunidade ===");
        System.out.println("Empresa: " + empresa);
        System.out.println("Cargo: " + cargo);

        scanner.close();
    }
}