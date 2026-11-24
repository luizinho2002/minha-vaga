import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        cadastrarOportunidade(scanner);

        scanner.close();
    }

    public static void cadastrarOportunidade(Scanner scanner) {

        System.out.print("Digite a empresa: ");
        String empresa = scanner.nextLine();

        System.out.print("Digite o cargo: ");
        String cargo = scanner.nextLine();

        boolean resultadoValidacao = dadosValidos(empresa, cargo);

        if (resultadoValidacao) {
            String resumo = criarResumo(empresa, cargo);

            exibirOportunidade(resumo);
        } else {
            System.out.println("Empresa e cargo são obrigatórios.");
        }
    }

    public static boolean dadosValidos(String empresa, String cargo) {
        return !empresa.isBlank() && !cargo.isBlank();
    }

    public static String criarResumo(String empresa, String cargo) {
        String resumo = empresa + " | " + cargo;

        return resumo;
    }

    public static void exibirOportunidade(String resumo) {
        System.out.println("\n=== Oportunidade ===");
        System.out.println("Resumo: " + resumo);
    }
}