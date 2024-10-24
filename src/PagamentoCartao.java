public class PagamentoCartao implements Pagamento{
    private String numeroCartao;

    // Construtor que inicializa o numero do cartao do usuário
    public PagamentoCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    // Método que retorna os detalhes do pagamento
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " no cartão: " + numeroCartao);
    }
}
