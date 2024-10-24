import java.util.ArrayList; // Importa ArrayList para a lista de assentos
import java.util.List; // Importa List para o uso de listas de objetos

// Classe que representa um voo, incluindo detalhes como número, origem, destino, horário e assentos
public class Voo {
    private String numeroVoo; // Número do voo
    private String origem; // Cidade de origem
    private String destino; // Cidade de destino
    private String horario; // Horário de partida
    public List<Assento> assentos; // Lista de assentos disponíveis

    // Construtor que inicializa os atributos do voo e a lista de assentos
    public Voo(String numeroVoo, String origem, String destino, String horario) {
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
        this.assentos = new ArrayList<>(); // Inicializa a lista de assentos
        inicializarAssentos(); // Popula a lista de assentos
    }

    // Métodos getter para acessar as informações do voo
    public String getNumeroVoo() { return numeroVoo; }
    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
    public String getHorario() { return horario; }
    public List<Assento> getAssentos() { return assentos; }

    // Representação do objeto Voo como string
    @Override
    public String toString() {
        return "Voo " + numeroVoo + ": " + origem + " -> " + destino + " às " + horario;
    }

    // Método que inicializa a lista de assentos com diferentes categorias
    public void inicializarAssentos() {
        // Adiciona assentos nas classes econômica, executiva e primeira classe
        assentos.add(new Assento("1A", "economica"));
        assentos.add(new Assento("1B", "economica"));
        assentos.add(new Assento("1C", "economica"));
        assentos.add(new Assento("2A", "executiva"));
        assentos.add(new Assento("2B", "executiva"));
        assentos.add(new Assento("2C", "executiva"));
        assentos.add(new Assento("3A", "primeira classe"));
        assentos.add(new Assento("3B", "primeira classe"));
        assentos.add(new Assento("3C", "primeira classe"));
    }
}
