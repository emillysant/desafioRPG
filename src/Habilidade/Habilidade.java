package Habilidade;

public class Habilidade {
    private String nome;
    private TipoHabilidade tipoHabilidade;
    private int danoBase;

    public Habilidade(String nome, TipoHabilidade tipoHabilidade, int danoBase) {
        this.nome = nome;
        this.tipoHabilidade = tipoHabilidade;
        this.danoBase = danoBase;
    }

    public String getNome() {
        return nome;
    }

    public TipoHabilidade getTipoHabilidade() {
        return tipoHabilidade;
    }

    public int getDanoBase() {
        return danoBase;
    }

    @Override
    public String toString() {
        return "Habilidade{" +
                "nome='" + nome + '\'' +
                ", tipoHabilidade=" + tipoHabilidade +
                ", danoBase=" + danoBase +
                '}';
    }
}
