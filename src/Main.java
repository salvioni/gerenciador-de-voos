import java.util.ArrayList; // Importa a classe ArrayList para manipulação de listas dinâmicas
import java.util.List; // Importa a interface List para permitir o uso de listas
import java.util.Scanner; // Importa a classe Scanner para leitura de entradas do usuário

public class Main {

    // Lista para armazenar os voos disponíveis
    private static List<Voo> voos = new ArrayList<>();
    // Inicialização do scanner para entrada de dados do usuário
    private static Scanner scanner = new Scanner(System.in); // Usado para ler entradas do usuário

    public static void main(String[] args) {
        // Inicializa os voos disponíveis chamando o método correspondente
        inicializarVoos();

        // Loop principal do menu
        boolean rodando = true; // Variável de controle para o loop do menu
        while (rodando) {
            exibirMenu(); // Exibe as opções do menu
            int opcao = Validador.pedirInt("Escolha uma opção: "); // Pede ao usuário para escolher uma opção do menu

            // Processa a opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    pesquisarVoos(); // Chama a função para pesquisar voos
                    break;
                case 2:
                    fazerReserva(); // Chama a função para fazer uma reserva de voo
                    break;
                case 3:
                    System.out.println("Saindo..."); // Mensagem para saída do sistema
                    rodando = false; // Encerra o loop
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente."); // Mensagem para opção inválida
            }
        }
    }

    // Função para exibir o menu principal
    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Reservas ==="); // Cabeçalho do menu
        System.out.println("1. Pesquisar voos"); // Opção para pesquisar voos
        System.out.println("2. Fazer reserva"); // Opção para fazer uma reserva
        System.out.println("3. Sair"); // Opção para sair do sistema
    }

    // Função para pesquisar voos com base no destino informado pelo usuário
    private static void pesquisarVoos() {
        int contador = 0; // Contador para rastrear quantos voos foram encontrados
        System.out.print("\nDigite o destino desejado (digite TODOS para ver todos os voos disponíveis): "); // Solicita o destino
        String destino = scanner.nextLine(); // Lê o destino informado pelo usuário

        // Se o usuário digitar "todos", exibe todos os voos disponíveis
        if (destino.equalsIgnoreCase("todos")) {
            for (Voo voo : voos) {
                System.out.println(voo); // Exibe as informações do voo
                contador++; // Incrementa o contador
            }
        } else {
            System.out.println("\n=== Voos Disponíveis para " + destino + " ==="); // Cabeçalho para os voos disponíveis
            for (Voo voo : voos) {
                // Verifica se o destino do voo corresponde ao informado pelo usuário
                if (voo.getDestino().equalsIgnoreCase(destino)) {
                    System.out.println(voo); // Exibe as informações do voo encontrado
                    contador++; // Incrementa o contador
                }
            }
            // Caso nenhum voo tenha sido encontrado
            if (contador == 0) {
                System.out.println("Nenhum voo encontrado para o destino: " + destino); // Mensagem informando que não há voos disponíveis
            }
        }
    }

    // Função para fazer uma reserva
    private static void fazerReserva() {
        System.out.print("\nDigite o número do voo que deseja reservar: "); // Solicita o número do voo
        String numeroVoo = scanner.nextLine(); // Lê o número do voo informado pelo usuário
        Voo vooSelecionado = null; // Inicializa a variável para armazenar o voo selecionado

        // Procura o voo pelo número informado
        for (Voo voo : voos) {
            if (voo.getNumeroVoo().equalsIgnoreCase(numeroVoo)) { // Verifica se o número do voo corresponde
                vooSelecionado = voo; // Se encontrado, armazena o voo selecionado
                break; // Sai do loop
            }
        }

        // Verifica se o voo foi encontrado
        if (vooSelecionado == null) {
            System.out.println("Voo não encontrado!"); // Mensagem de erro
            return; // Sai da função se o voo não for encontrado
        }

        // Criação do passageiro
        System.out.print("Digite seu nome: "); // Solicita o nome do passageiro
        String nome = scanner.nextLine(); // Lê o nome informado
        String cpf = Validador.pedirCpf(); // Pede um CPF válido
        String email = Validador.pedirEmail(); // Pede um email válido
        Passageiro passageiro = new Passageiro(nome, cpf, email); // Cria um objeto Passageiro com os dados informados

        // Escolher um assento
        Assento assentoSelecionado = escolherAssento(vooSelecionado); // Chama a função para escolher um assento
        if (assentoSelecionado != null) { // Verifica se um assento foi selecionado com sucesso
            // Realiza a reserva
            try {
                Reserva reserva = new Reserva(vooSelecionado, passageiro, assentoSelecionado); // Cria uma nova reserva
                System.out.println("\nReserva confirmada:"); // Mensagem de confirmação
                System.out.println(reserva); // Exibe os detalhes da reserva

                // Processa o pagamento
                processarPagamento(reserva); // Chama a função para processar o pagamento da reserva
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage()); // Trata erros de reserva
            }
        }
    }

    // Função para escolher um assento
    private static Assento escolherAssento(Voo voo) {
        List<Assento> assentos = voo.getAssentos(); // Obtém a lista de assentos do voo
        System.out.println("\nAssentos disponíveis:"); // Mensagem de cabeçalho para assentos disponíveis

        // Exibe apenas os assentos disponíveis
        for (Assento assento : assentos) {
            if (assento.isDisponivel()) { // Verifica se o assento está disponível
                System.out.println(assento); // Exibe informações do assento
            }
        }

        while (true) { // Loop para escolher um assento
            System.out.print("\nDigite o número do assento que deseja reservar: "); // Solicita ao usuário o número do assento
            String numeroAssento = scanner.nextLine(); // Lê o número do assento informado

            // Verifica se o assento está disponível e reservá-lo
            for (Assento assento : assentos) {
                if (assento.getNumero().equalsIgnoreCase(numeroAssento)) { // Verifica se o número do assento corresponde
                    if (assento.isDisponivel()) { // Verifica se o assento está disponível
                        assento.reservar(); // Reserva o assento
                        System.out.println("Assento " + assento.getNumero() + " reservado com sucesso."); // Mensagem de sucesso
                        return assento; // Retorna o assento reservado
                    } else {
                        System.out.println("Assento já está reservado! Por favor, escolha outro assento."); // Mensagem de erro
                        return null; // Retorna null se o assento já estiver reservado
                    }
                }
            }

            System.out.println("Assento inválido! Por favor, tente novamente."); // Mensagem para assento inválido
        }
    }

    // Função para processar pagamento
    private static void processarPagamento(Reserva reserva) {
        System.out.println("\n=== Pagamento ==="); // Cabeçalho para a seção de pagamento
        System.out.println("1. Cartão de Crédito"); // Opção de pagamento com cartão de crédito
        System.out.println("2. PayPal"); // Opção de pagamento com PayPal
        int metodo = Validador.pedirInt("Escolha o método de pagamento: "); // Pede ao usuário para escolher um método de pagamento

        // Exibe o valor a pagar
        System.out.print("Valor a pagar: R$" + reserva.calcularPrecoTotal() + "\n");

        // Processa o pagamento com base na escolha do usuário
        switch (metodo) {
            case 1:
                System.out.print("Digite o número do cartão: "); // Solicita o número do cartão
                String numeroCartao = scanner.nextLine(); // Lê o número do cartão
                Pagamento pagamentoCartao = new PagamentoCartao(numeroCartao); // Cria um objeto de pagamento com cartão
                pagamentoCartao.processarPagamento(reserva.calcularPrecoTotal()); // Processa o pagamento
                break;
            case 2:
                String emailPayPal = Validador.pedirEmail(); // Pede o email para PayPal
                Pagamento pagamentoPayPal = new PagamentoPayPal(emailPayPal); // Cria um objeto de pagamento com PayPal
                pagamentoPayPal.processarPagamento(reserva.calcularPrecoTotal()); // Processa o pagamento
                break;
            default:
                System.out.println("Método de pagamento inválido!"); // Mensagem para método de pagamento inválido
        }
    }

    // Função para inicializar alguns voos de teste
    private static void inicializarVoos() {
        // Adiciona voos de exemplo à lista de voos disponíveis
        voos.add(new Voo("1234", "São Paulo", "Rio de Janeiro", "10:30")); // Voo de São Paulo para Rio de Janeiro
        voos.add(new Voo("5678", "São Paulo", "Brasília", "14:45")); // Voo de São Paulo para Brasília
        voos.add(new Voo("9876", "Rio de Janeiro", "Salvador", "18:00")); // Voo do Rio de Janeiro para Salvador
    }

}
