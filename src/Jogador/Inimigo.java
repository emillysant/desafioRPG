package Jogador;

import Habilidade.Habilidade;
import Habilidade.TipoHabilidade;

import java.util.ArrayList;

public class Inimigo extends Personagem {
    TipoJogador tipo;
    int recompensaXP;

    public Inimigo(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidade> habilidades, TipoJogador tipo, int recompensaXP) {
        super(nome, pontosVida, forca, defesa, habilidades, 0.15);
        this.tipo = tipo;
        this.recompensaXP = recompensaXP;
        adicionarHabilidadeNativa();
    }

    private void adicionarHabilidadeNativa() {
        Habilidade habilidadeNativa = new Habilidade("Chicote", TipoHabilidade.PLANTA, 2);
        if (!getHabilidades().contains(habilidadeNativa)) {
            getHabilidades().add(habilidadeNativa);
        }
    }

    public TipoJogador getTipo() {
        return tipo;
    }

    public int getRecompensaXP() {
        return recompensaXP;
    }

    @Override
    public String toString() {
        return "Inimigo | " + "tipo " + tipo;
    }
}
