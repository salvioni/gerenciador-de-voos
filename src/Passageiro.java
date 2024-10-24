public class Passageiro {
    private String nome;
    private String cpf;
    private String email;

    public Passageiro(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getContato() {
        return email;
    }

    @Override
    public String toString() {
        return "Passageiro: " + nome + " (CPF: " + cpf + ")";
    }
}
