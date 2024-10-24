public class Assento {
    private String numero;
    private String classe;
    private boolean disponivel;

    public Assento(String numero, String classe) {
        this.numero = numero;
        this.classe = Validador.formatarClasse(classe);
        this.disponivel = true;  // Todos os assentos começam disponíveis
    }

    //Getters
    public String getNumero() {
        return numero;
    }
    public String getClasse() {
        return classe;
    }
    public boolean isDisponivel() {
        return disponivel;
    }

    //Método que faz o assento ficar em status disponivel
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Método para reservar assento
    public void reservar() {
        this.disponivel = false;
    }

    //Método que retorna uma string formatada com as informações do assento
    @Override
    public String toString() {
        return "Assento " + numero + " (" + classe + ")";
    }

    // Polimorfismo aplicado ao preço do assento de acordo com a classe
    public double calcularPreco() {
        switch (classe.toLowerCase()) {
            case "economica":
                return 200.0;
            case "executiva":
                return 500.0;
            case "primeira classe":
                return 1000.0;
            default:
                return 0.0;
        }
    }


}
