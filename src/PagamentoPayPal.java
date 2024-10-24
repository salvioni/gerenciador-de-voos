// Classe que representa um método de pagamento via PayPal
class PagamentoPayPal implements Pagamento {
    private String email; // E-mail associado à conta PayPal

    // Construtor que inicializa o e-mail do usuário
    public PagamentoPayPal(String email) {
        this.email = email;
    }

    // Método que retorna os detalhes do pagamento
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PayPal com o e-mail " + email);
    }
}
