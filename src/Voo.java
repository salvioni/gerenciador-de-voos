import java.util.ArrayList;
import java.util.List;

public class Voo {
    private String numeroVoo;
    private String origem;
    private String destino;
    private String horario;
    public List<Assento> assentos;

    public Voo(String numeroVoo, String origem, String destino, String horario) {
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
        this.assentos = new ArrayList<>();
        inicializarAssentos();
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getHorario() {
        return horario;
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    @Override
    public String toString() {
        return "Voo " + numeroVoo + ": " + origem + " -> " + destino + " às " + horario;
    }

    public void inicializarAssentos() {
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

