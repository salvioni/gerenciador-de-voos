public class Reserva {
    private Voo voo;
    private Passageiro passageiro;
    private Assento assento;

    public Reserva(Voo voo, Passageiro passageiro, Assento assento) {
        this.voo = voo;
        this.passageiro = passageiro;
        this.assento = assento;
        assento.reservar();
    }

    // Getters
    public Voo getVoo() {
        return voo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Assento getAssento() {
        return assento;
    }

    public double calcularPrecoTotal() {
        return assento.calcularPreco();
    }

    @Override
    public String toString() {
        return "Reserva para " + passageiro.getNome() + "\n" +
                voo.toString() + "\n" +
                assento.toString() + " - Preço: R$" + calcularPrecoTotal();
    }
}
