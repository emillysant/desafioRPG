package Jogador;

import Habilidade.Habilidade;
import Habilidade.TipoHabilidade;

import java.util.ArrayList;

public class Mago extends Personagem{
    private int pontosMagia;

    public Mago(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidade> habilidades , int pontosMagia) {
        super(nome, pontosVida, forca, defesa, habilidades, 0.30);
        this.pontosMagia = pontosMagia;
        adicionarHabilidadeNativa();
    }

    private void adicionarHabilidadeNativa() {
        Habilidade habilidadeNativa = new Habilidade("Punho de gelo", TipoHabilidade.MAGICA,  8);
        Habilidade habilidadeNativa1 = new Habilidade("Bola de Fogo", TipoHabilidade.MAGICA, 9);
        if (!getHabilidades().contains(habilidadeNativa)) {
            getHabilidades().add(habilidadeNativa);
        }
        if (!getHabilidades().contains(habilidadeNativa1)) {
            getHabilidades().add(habilidadeNativa1);
        }
    }

    public int getPontosMagia() {
        return pontosMagia;
    }

    @Override
    public String toString() {
        return "Mago | Mana " + getPontosMagia();
    }

}
