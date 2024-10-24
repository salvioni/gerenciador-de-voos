// Classe que representa um passageiro com informações pessoais
public class Passageiro {
    private String nome; // Nome do passageiro
    private String cpf; // CPF do passageiro
    private String email; // E-mail de contato do passageiro

    // Construtor que inicializa os atributos do passageiro
    public Passageiro(String nome, String cpf, String email) {
        this.nome = nome; // Atribui o nome ao passageiro
        this.cpf = cpf; // Atribui o CPF ao passageiro
        this.email = email; // Atribui o e-mail ao passageiro
    }

    // Método getter para obter o nome do passageiro
    public String getNome() {
        return nome; // Retorna o nome do passageiro
    }

    // Método getter para obter o CPF do passageiro
    public String getCpf() {
        return cpf; // Retorna o CPF do passageiro
    }

    // Método getter para obter o e-mail de contato do passageiro
    public String getContato() {
        return email; // Retorna o e-mail do passageiro
    }

    // Representação do passageiro como string, incluindo nome e CPF
    @Override
    public String toString() {
        return "Passageiro: " + nome + " (CPF: " + cpf + ")"; // Formata a saída com nome e CPF
    }
}
