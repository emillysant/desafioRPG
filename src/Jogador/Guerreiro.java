package Jogador;

import Habilidade.Habilidade;
import Habilidade.TipoHabilidade;

import java.util.ArrayList;

public class Guerreiro extends Personagem{
    private int armadura;

    public Guerreiro(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidade>  habilidades,int armadura) {
        super(nome, pontosVida, forca, defesa, habilidades, 0.25);
        this.armadura = armadura;
        adicionarHabilidadeNativa();
    }

    public int getArmadura() {
        return armadura;
    }

    private void adicionarHabilidadeNativa() {
        Habilidade habilidadeNativa = new Habilidade("Espada Flamejante", TipoHabilidade.FISICA, 10);
        Habilidade habilidadeNativa1 = new Habilidade("Golpe de espada dupla", TipoHabilidade.FISICA, 14);
        if (!getHabilidades().contains(habilidadeNativa)) {
            getHabilidades().add(habilidadeNativa);
        }
        if (!getHabilidades().contains(habilidadeNativa1)) {
            getHabilidades().add(habilidadeNativa1);
        }
    }

    @Override
    public String toString() {
        return "Guerreiro | Armadura " + getArmadura();
    }
}
