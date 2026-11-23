import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner.out.print("Digite a empresa: ");
        String empresa = scanner.nextLine();

        System.out.print("Digite o cargo: ");
        String cargo = scanner.nextLine();

        boolean resultadoValidacao = dadosValidos(empresa, cargo);

        if (resultadoValidacao) {
            System.out.println("Empresa: " + empresa);
            System.out.println("Cargo: " + cargo);
        } else {
            System.out.println("Empresa e cargo são obrigatórios.");
        }

        scanner.close();
    }

    public static boolean dadosValidos(String empresa, String cargo) {
        return !empresa.isBlank() && !cargo.isBlank();
    }
}