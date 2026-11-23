import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a empresa: ");
        String empresa = scanner.nextLine();

        System.out.print("Digita o cargo: ");
        String cargo = scanner.nextLine();

        boolean resultadoValidacao = dadosValidos(empresa, cargo);

        if (resultadoValidacao) {
            String resumo = criarResumo(empresa, cargo);

            System.out.println("Resumo: " + resumo);
        } else {
            System.out.println("Empresa e cargo são obrigatórios.");
        }

        scanner.close();
    }

    public static boolean dadosValidos(String empresa, String cargo) {
        return !empresa.isBlank() && !cargo.isBlank();
    }

    public static String criarResumo(String empresa, String cargo) {
        String resumo = empresa + " | " + cargo;

        return resumo;
    }
}