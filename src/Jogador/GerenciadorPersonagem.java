package Jogador;

import Habilidade.Habilidade;
import Habilidade.TipoHabilidade;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GerenciadorPersonagem {
    static Scanner scan = new Scanner(System.in);

    public static Mago criarMago(Personagem personagem) {
        System.out.println("Digite os pontos de magia do mago: (int)");
        int pontosMagia = scan.nextInt();
        return new Mago(personagem.getNome(), personagem.getPontosVida(), personagem.getForca(), personagem.getDefesa(), personagem.getHabilidades(), pontosMagia);
    }

    public static  Arqueiro criarArqueiro(Personagem personagem) {
        System.out.println("Digite a destreza do arqueiro: (int)");
        int destreza = scan.nextInt();
        return new Arqueiro(personagem.getNome(), personagem.getPontosVida(), personagem.getForca(), personagem.getDefesa(), personagem.getHabilidades(), destreza);
    }

    public static  Guerreiro criarGuerreiro(Personagem personagem) {
        System.out.println("Digite a armadura do guerreiro: (int)");
        int armadura = scan.nextInt();
        return new Guerreiro(personagem.getNome(), personagem.getPontosVida(), personagem.getForca(), personagem.getDefesa(), personagem.getHabilidades(), armadura);
    }

    public static  Inimigo criarInimigo(Personagem personagem) {
        System.out.println("Digite o tipo do inimigo: ");
        System.out.println("1-MONSTRO\n2-CHEFE\n3-MOTORISTA\n4-ASSASSINO\n5-ELFO");
        int tipoOpt = scan.nextInt();
        TipoJogador tipo = TipoJogador.values()[tipoOpt - 1];
        System.out.println("Digite a recompensa XP do inimigo: (int)");
        int recompensaXP = scan.nextInt();
        return new Inimigo(personagem.getNome(), personagem.getPontosVida(), personagem.getForca(), personagem.getDefesa(), personagem.getHabilidades(), tipo, recompensaXP);
    }

    public static ArrayList<Personagem> carregarTodosPersonagens(ArrayList<Personagem> personagens){
        ArrayList<Habilidade> habilidadesArqueiro = new ArrayList<>();
        personagens.add(new Arqueiro("Archer", 100, 25, 5, habilidadesArqueiro, 6));
        ArrayList<Habilidade> habilidadesGuerreiro = new ArrayList<>();
        personagens.add(new Guerreiro("Jordyn", 100, 30, 30, habilidadesGuerreiro, 8));
        ArrayList<Habilidade> habilidadesMago = new ArrayList<>();
        personagens.add(new Mago("Gandalf", 100, 36, 12, habilidadesMago, 10));
        return personagens;
    }


    public static void verificarNivel(Personagem jogador) {
        int experienciaPorNivel = 100;

        if (jogador.getPontosExperiencia() >= experienciaPorNivel * jogador.getNivel()) {
            jogador.setNivel(jogador.getNivel()+1);
            System.out.println("Parabéns! " + jogador.getNome() + " subiu para o nível " + jogador.getNivel() + "!");

            jogador.setPontosVida(jogador.getPontosVida()+5);
            jogador.setInimigosDerrotados(jogador.getInimigosDerrotados()+1);
        }
    }

    public static Inimigo selecionarInimigoAleatorio(ArrayList<Inimigo> inimigos) {
        Random random = new Random();
        int index = random.nextInt(inimigos.size());
        return inimigos.get(index);
    }

    public static ArrayList<Inimigo> criarListaInimigos() {
        ArrayList<Inimigo> inimigos = new ArrayList<>();

        ArrayList<Habilidade> habilidadesInimigo1 = new ArrayList<>();
        habilidadesInimigo1.add(new Habilidade("Chicote", TipoHabilidade.PLANTA, 5));
        inimigos.add(new Inimigo("Elfo das sombras", 50, 8, 10, habilidadesInimigo1, TipoJogador.ELFO, 50));

        ArrayList<Habilidade> habilidadesInimigo2 = new ArrayList<>();
        habilidadesInimigo2.add(new Habilidade("Garras Afiadas", TipoHabilidade.FISICA, 5));
        inimigos.add(new Inimigo("Orc gigante", 50, 10, 8, habilidadesInimigo2, TipoJogador.ORC, 50));

        ArrayList<Habilidade> habilidadesInimigo3 = new ArrayList<>();
        habilidadesInimigo3.add(new Habilidade("Bola de Fogo", TipoHabilidade.MAGICA, 7));
        inimigos.add(new Inimigo("Monstro devorador", 50, 12, 12, habilidadesInimigo3, TipoJogador.MONSTRO, 55));

        return inimigos;
    }

}
