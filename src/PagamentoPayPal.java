class PagamentoPayPal implements Pagamento {
    private String email;

    public PagamentoPayPal(String email) {
        this.email = email;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PayPal com o e-mail " + email);
    }
}
