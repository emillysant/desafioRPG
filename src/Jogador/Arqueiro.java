package Jogador;

import Habilidade.Habilidade;
import Habilidade.TipoHabilidade;

import java.util.ArrayList;

public class Arqueiro extends Personagem{
    private int destreza;


    public Arqueiro(String nome, int pontosVida, int forca, int defesa,ArrayList<Habilidade> habilidades, int destreza) {
        super(nome, pontosVida, forca, defesa, habilidades, 0.45);
        this.destreza = destreza;
        adicionarHabilidadeNativa();
    }

    private void adicionarHabilidadeNativa() {
        Habilidade habilidadeNativa = new Habilidade("Atirar Flecha", TipoHabilidade.AR, 3);
        if (!getHabilidades().contains(habilidadeNativa)) {
            getHabilidades().add(habilidadeNativa);
        }
    }

    public int getDestreza() {
        return destreza;
    }

    @Override
    public String toString() {
        return "Arqueiro | " + "Destreza " + getDestreza();
    }
}
