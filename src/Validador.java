import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    public static String pedirEmail() {
        Scanner scanner = new Scanner(System.in);
        String email;

        while (true) {
            System.out.print("Digite seu e-mail: ");
            email = scanner.nextLine();

            if (verificarEmail(email)) {
                return email;  // Retorna o e-mail se for válido
            } else {
                System.out.println("E-mail inválido! Por favor, tente novamente.");
            }
        }
    }

    public static boolean verificarEmail(String email) {
        // Expressão regular para validar o formato de um e-mail
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

        // Compilando a expressão regular
        Pattern pattern = Pattern.compile(regex);

        // Verificando se o e-mail corresponde ao padrão
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


    // Função que pede um inteiro e faz o tratamento de erros
    public static int pedirInt(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        int numero = -1;
        boolean entradaValida = false;

        // Continua solicitando até obter uma entrada válida
        while (!entradaValida) {
            try {
                System.out.print(mensagem);  // Exibe a mensagem personalizada
                numero = scanner.nextInt();
                scanner.nextLine();  // Limpa o buffer
                entradaValida = true;  // Entrada válida, sai do loop
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida! Por favor, insira um número.");
                scanner.nextLine();  // Limpa o buffer após erro
            }
        }

        return numero;  // Retorna o número válido
    }

    public static String pedirCpf() {
        Scanner scanner = new Scanner(System.in);
        String cpf;

        while (true) {
            System.out.print("Digite seu CPF (somente números, 11 dígitos): ");
            cpf = scanner.nextLine().trim();  // Remove espaços em branco

            // Verifica se o CPF tem exatamente 11 caracteres e se é numérico
            if (cpf.length() == 11 && cpf.matches("\\d+")) {
                return cpf;  // Retorna o CPF se for válido
            } else {
                System.out.println("CPF inválido! O CPF deve conter exatamente 11 dígitos numéricos. Tente novamente.");
            }
        }
    }
}
