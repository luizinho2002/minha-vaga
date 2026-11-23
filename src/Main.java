import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

     
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a empresa: ");
        String empresa = scanner.nextLine();

        System.out.print("Digite o cargo: ");
        String cargo = scanner.nextLine();

     
        if (empresa.isBlank()) {
            System.out.println("O nome da empresa é obrigatório.");
            scanner.close();
            return;
        }


        if (cargo.isBlank()) {
            System.out.println("O nome do cargo é obrigatório.");
            scanner.close();
            return;
        }

        exibirMensagem("Dados recebidos com sucesso!");

        exibirOportunidade(empresa, cargo);

        String resumo = criarResumo(empresa, cargo);

        System.out.println("Resumo: " + resumo);

        boolean resultadoValidacao = dadosValidados(empresa, cargo);

        boolean testeInvalido = dadosValidos(empresa, "");

        System.out.println("Dados válidos: " + resultadoValidacao);
        System.out.println("Teste com cargo vazio: " + testeInvalido);

        scanner.close();
    }

    public static void exibirOportunidade(String empresa, String cargo) {
        System.out.println("\n=== Oportunidade ===");
        System.out.println("Empresa: " + empresa);
        System.out.println("Cargo: " + cargo);
    }

    public static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public static String criarResumo(String empresa, String cargo) {
        String resumo = empresa + " | " + cargo;

        return resumo;
    }

    public static boolean dadosValidados(String empresa, String cargo) {
        return !empresa.isBlank() && !cargo.isBlank();
    }
}