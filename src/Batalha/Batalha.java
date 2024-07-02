package Batalha;

import Jogador.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Batalha {


    public Boolean iniciarPartida(ArrayList<Personagem> personagens){
        if (personagens == null || personagens.isEmpty()) {
            throw new IllegalArgumentException("A lista de personagens não pode ser nula ou vazia.");
        }
        boolean temInimigo = false;
        boolean temJogador = false;
        for (Personagem personagem : personagens) {
            if (personagem instanceof Inimigo) {
                temInimigo = true;
            } else if (personagem instanceof Arqueiro || personagem instanceof Guerreiro || personagem instanceof Mago) {
                temJogador = true;
            }
            if (temInimigo && temJogador) {
                System.out.println("Iniciando nova batalha na ordem: ");
                return true;
            }
        }
        System.out.println("Batalha não iniciada");
        if(!temInimigo) System.out.println("A Batalha deve ter ao menos um inimigo");
        if(!temJogador) System.out.println("A batalha deve ter ao menos um jogador");
        return false;
    }

    public void ordemPorPontosVida(ArrayList<Personagem> personagens) {
        Collections.sort(personagens, new Comparator<Personagem>() {
            @Override
            public int compare(Personagem o1, Personagem o2) {
                return Integer.compare(o2.getPontosVida(), o1.getPontosVida());
            }
        });

    }
    public void imprimirOrdemDosJogadores(ArrayList<Personagem> personagens){
        System.out.println("+------+--------------+----------------+-------------+-------------+");
        for (int i = 0; i < personagens.size(); i++) {
            Personagem personagem = personagens.get(i);
            System.out.println((i + 1) + "-" + personagem.getClass().getSimpleName() + ": " + personagem.getNome());
        }
        System.out.println("+------+--------------+----------------+-------------+-------------+");
    }

}
