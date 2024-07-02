package Jogador;

import Habilidade.Habilidade;
import Item.Item;

import java.util.ArrayList;
import java.util.Random;

public class Personagem {
    protected String nome;
    protected int pontosVida;
    protected int forca;
    protected int defesa;
    public ArrayList<Habilidade> habilidades;
    protected int pontosExperiencia;
    protected int nivel;
    protected double chanceCritico;
    protected ArrayList<Item> inventario;
    protected int inimigosDerrotados;

    private boolean envenenado;
    private int turnosEnvenenado;
    private boolean atordoado;
    private boolean queimado;
    private int turnosQueimado;
    private boolean dormindo;
    private int turnosDormindo;

    public Personagem() {
    }

    public Personagem(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidade> habilidades, double chanceCritico) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
        this.habilidades = habilidades;
        this.pontosExperiencia = 0;
        this.nivel = 1;
        this.chanceCritico = chanceCritico;
        this.inventario = new ArrayList<>();
        this.inimigosDerrotados = 0;

        this.envenenado = false;
        this.turnosEnvenenado = 0;
        this.atordoado = false;
        this.queimado = false;
        this.turnosQueimado = 0;
        this.dormindo = false;
        this.turnosDormindo = 0;
    }

    public void setDormindo(boolean dormindo) {
        this.dormindo = dormindo;
    }

    public boolean isAtordoado() {
        return atordoado;
    }

    public void setAtordoado(boolean atordoado) {
        this.atordoado = atordoado;
    }

    public boolean isDormindo() {
        return dormindo;
    }


    public int calcularDano(Personagem alvo, Habilidade habilidade) {
        Random random = new Random();
        boolean isCritico = random.nextDouble() < this.chanceCritico;

        int danoBase = this.forca;
        if (habilidade != null) {
            danoBase += habilidade.getDanoBase();
        }

        int danoReduzido;
        if (habilidade == null) {
            danoReduzido = danoBase - alvo.defesa;
        } else {
            switch (habilidade.getTipoHabilidade()) {
                case FISICA:
                    danoReduzido = danoBase - alvo.defesa;
                    break;
                case MAGICA:
                    danoReduzido = (int) (danoBase - alvo.defesa*0.25);
                    break;
                case PLANTA:
                    danoReduzido = (int) (danoBase * 0.75);
                    break;
                case AR:
                    danoReduzido = (int) (danoBase * 0.75);
                    break;
                default:
                    danoReduzido = danoBase;
                    break;
            }
        }

        int danoFinal = Math.max(danoReduzido, 0);
        if (isCritico) {
            danoFinal += 15;
            System.out.println("\033[31mGolpe crítico !\033[0m");
        }

        return danoFinal;
    }

    public void setInimigosDerrotados(int inimigosDerrotados) {
        this.inimigosDerrotados = inimigosDerrotados;
    }

    public int atacar(int danoBase, int vida){
       vida -=danoBase;
       return vida;
     }

    public int defender(int dano) {
        int danoReduzido = dano;
        if (dano>5) {
            danoReduzido = (int) (danoReduzido*0.75);
        }
        return danoReduzido;
    }

    public void fugir() {
        System.out.println("Você fugiu! Fim da batalha.");
    }

   public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public int getForca() {
        return forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public int getPontosExperiencia() {
        return pontosExperiencia;
    }

    public void setPontosExperiencia(int pontosExperiencia) {
        this.pontosExperiencia = pontosExperiencia;
    }

    public int getInimigosDerrotados() {
        return inimigosDerrotados;
    }

    public void adicionarItem(Item item) {
        this.inventario.add(item);
    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", pontosVida=" + pontosVida +
                ", forca=" + forca +
                ", defesa=" + defesa +
                ", habilidades=" + habilidades +
                '}';
    }
}
