import java.util.InputMismatchException; // Importa exceção para tratamento de erros de entrada
import java.util.Scanner; // Importa a classe Scanner para leitura de entrada do usuário
import java.util.regex.Matcher; // Importa a classe Matcher para manipulação de expressões regulares
import java.util.regex.Pattern; // Importa a classe Pattern para expressões regulares

// Classe Validador: responsável por validar entradas do usuário como e-mails, CPF e inteiros
public class Validador {

    // Método que solicita um e-mail ao usuário e valida seu formato
    public static String pedirEmail() {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para leitura de entrada
        String email; // Variável para armazenar o e-mail

        while (true) { // Loop contínuo até que um e-mail válido seja fornecido
            System.out.print("Digite seu e-mail: "); // Solicita que o usuário digite um e-mail
            email = scanner.nextLine(); // Lê a linha de entrada

            // Verifica se o e-mail é válido
            if (verificarEmail(email)) {
                return email;  // Retorna o e-mail se for válido
            } else {
                System.out.println("E-mail inválido! Por favor, tente novamente."); // Mensagem de erro
            }
        }
    }

    // Método que valida o formato do e-mail usando expressões regulares
    public static boolean verificarEmail(String email) {
        // Expressão regular para validar o formato de um e-mail
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

        // Compilando a expressão regular
        Pattern pattern = Pattern.compile(regex);

        // Verificando se o e-mail corresponde ao padrão
        Matcher matcher = pattern.matcher(email);

        return matcher.matches(); // Retorna verdadeiro se o e-mail for válido, falso caso contrário
    }

    // Método que pede um inteiro ao usuário e trata possíveis erros de entrada
    public static int pedirInt(String mensagem) {
        Scanner scanner = new Scanner(System.in); // Cria um novo objeto Scanner para leitura
        int numero = -1; // Inicializa a variável número com um valor padrão
        boolean entradaValida = false; // Flag para controlar a validade da entrada

        // Continua solicitando até obter uma entrada válida
        while (!entradaValida) {
            try {
                System.out.print(mensagem);  // Exibe a mensagem personalizada para o usuário
                numero = scanner.nextInt(); // Lê o número fornecido pelo usuário
                scanner.nextLine();  // Limpa o buffer de entrada
                entradaValida = true;  // Entrada válida, sai do loop
            } catch (InputMismatchException e) { // Captura exceção se a entrada não for um número
                System.out.println("Erro: Entrada inválida! Por favor, insira um número."); // Mensagem de erro
                scanner.nextLine();  // Limpa o buffer após erro
            }
        }

        return numero;  // Retorna o número válido fornecido pelo usuário
    }

    // Método que solicita um CPF ao usuário e valida seu formato
    public static String pedirCpf() {
        Scanner scanner = new Scanner(System.in); // Cria um novo objeto Scanner para leitura
        String cpf; // Variável para armazenar o CPF

        while (true) { // Loop contínuo até que um CPF válido seja fornecido
            System.out.print("Digite seu CPF (somente números, 11 dígitos): "); // Solicita que o usuário digite o CPF
            cpf = scanner.nextLine().trim();  // Lê a linha de entrada e remove espaços em branco

            // Verifica se o CPF tem exatamente 11 caracteres e se é numérico
            if (cpf.length() == 11 && cpf.matches("\\d+")) {
                return cpf;  // Retorna o CPF se for válido
            } else {
                System.out.println("CPF inválido! O CPF deve conter exatamente 11 dígitos numéricos. Tente novamente."); // Mensagem de erro
            }
        }
    }

    public static String formatarClasse(String classe) {
        if (classe == null) {
            return null; // Retorna nulo se a entrada for nula
        }

        classe = classe.toLowerCase(); // Converte para letras minúsculas e define classes na formatação correta
        if (classe.contains("xecutiv")) {
            return "executiva";
        } else if (classe.contains("rimeir")) {
            return "primeira classe";
        } else if (classe.contains("conomic")) {
            return "economica";
        } else {
            return classe; // Retorna a string original se nenhuma correção for feita
        }
    }

}
