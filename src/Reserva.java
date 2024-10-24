// Classe que representa uma reserva de voo, incluindo informações sobre o voo, passageiro e assento
public class Reserva {
    private Voo voo; // Objeto Voo associado à reserva
    private Passageiro passageiro; // Objeto Passageiro associado à reserva
    private Assento assento; // Objeto Assento reservado

    // Construtor que inicializa a reserva, reservando o assento no ato da criação
    public Reserva(Voo voo, Passageiro passageiro, Assento assento) {
        this.voo = voo; // Atribui o voo à reserva
        this.passageiro = passageiro; // Atribui o passageiro à reserva
        this.assento = assento; // Atribui o assento à reserva
        assento.reservar(); // Marca o assento como reservado
    }

    // Métodos getter
    public Voo getVoo() { return voo;}
    public Passageiro getPassageiro() {return passageiro;}
    public Assento getAssento() { return assento; }

    // Calcula e retorna o preço total da reserva baseado no preço do assento
    public double calcularPrecoTotal() {
        return assento.calcularPreco();
    }

    // Representação da reserva como string formatada, incluindo detalhes do passageiro, voo e preço
    @Override
    public String toString() {
        return "Reserva para " + passageiro.getNome() + "\n" +
                voo.toString() + "\n" +
                assento.toString() + " - Preço: R$" + calcularPrecoTotal();
    }
}
