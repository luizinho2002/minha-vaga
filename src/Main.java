import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> oportunidades = new ArrayList<>();

        String opcao;

        do {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarOportunidade(scanner, oportunidades);
                    break;

                case "2":
                    listarOportunidades(oportunidades);
                    break;
                
                case "0":
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));

        scanner.close();
    }

    public static void cadastrarOportunidade(
        Scanner scanner,
        ArrayList<String> oportunidades 
    ) {
        System.out.print("Digite a empresa: ");
        String empresa = scanner.nextLine();

        System.out.print("Digite o cargo: ");
        String cargo = scanner.nextLine();

        boolean resultadoValidacao = dadosValidos(empresa, cargo);

        if (resultadoValidacao) {
            String resumo = criaResumo(empresa, cargo);

            oportunidades.add(resumo);

            exibirOportunidade(resumo);
        } else {
            System.out.println("Empresa e cargo são obrigatórios.");
        }
    }

    public static void listarOportunidades(
        ArrayList<String> oportunidades 
    ) {
        if (oportunidades.isEmpty()) {
            System.out.println("Nenhuma oportunidade cadastrada.");
            return;
        }

        System.out.println("\n=== OPORTUNIDADES CADASTRADAS ===");

        for (String oportunidade : oportunidades) {
            System.out.println("- " + oportunidade);
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
        System.out.println("\n=== OPORTUNIDADE CADASTRADA ===");
        System.out.println("Resumo: " + resumo);
    }

    public static void exibirMenu() {
        System.out.println("\n=== MINHAVAGA");
        System.out.println("1. Cadastrar oportunidade");
        System.out.println("2. Listar oportunidades");
        System.out.println("0. Sair");
    }
}