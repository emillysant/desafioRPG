package Jogo;

import Habilidade.Habilidade;

import Item.Item;
import Item.GerenciadorItens;
import Item.TipoRaridade;
import Jogador.*;
import Jogador.GerenciadorPersonagem;

import Batalha.Batalha;

import java.util.*;

public class Jogo {
    Scanner scan = new Scanner(System.in);
    ArrayList<Habilidade> habilidades;
    ArrayList<Personagem> personagens;
    ArrayList<Personagem> personagensEmBatalha;
    ArrayList<Inimigo> inimigos;
    Personagem personagemSelecionado ;

    public Jogo() {
        this.habilidades = new ArrayList<>();
        this.inimigos = GerenciadorPersonagem.criarListaInimigos();
        this.personagens = new ArrayList<>();
        GerenciadorPersonagem.carregarTodosPersonagens(this.personagens);
    }

     public Personagem cadastrarNovoPersonagem() {
        System.out.println("Digite o nome do Personagem: ");
        String nome = scan.next();
        System.out.println("Digite os pontos de vida (int): ");
        int pontosVida = scan.nextInt();
        System.out.println("Digite a força (int): ");
        int forca = scan.nextInt();
        System.out.println("Digite a defesa (int): ");
        int defesa = scan.nextInt();
         System.out.println("Digite a chance de dano critico (int): ");
        int danoCritico = scan.nextInt();
        Personagem personagem = new Personagem(nome, pontosVida, forca, defesa, habilidades, danoCritico);
        Personagem personagemEscolhido = escolherPersonagem(personagem);
        if (personagemEscolhido != null) {
            personagens.add(personagemEscolhido);
        }
        return personagemEscolhido;
    }

    public Personagem escolherPersonagem(Personagem personagem) {
        System.out.println("Escolha um tipo de personagem: ");
        System.out.println("1-Arqueiro\n2-Guerreiro\n3-Inimigo\n4-Mago");
        int opt = scan.nextInt();
        Personagem novoPersonagem = null;

        switch (opt) {
            case 1:
                novoPersonagem = GerenciadorPersonagem.criarArqueiro(personagem);
                break;
            case 2:
                novoPersonagem = GerenciadorPersonagem.criarGuerreiro(personagem);
                break;
            case 3:
                novoPersonagem = GerenciadorPersonagem.criarInimigo(personagem);
                break;
            case 4:
                novoPersonagem = GerenciadorPersonagem.criarMago(personagem);
                break;
            default:
                System.out.println("Opção inválida.");

        }
        return novoPersonagem;
    }

    public void imprimirItensPersonagem(Personagem personagem) {
        System.out.println("\033[34m------------------------------------------------------------------------------------------------\033[0m");
        System.out.printf("\033[34m%-6s %-20s %-30s %-10s\033[0m%n", "Index", "Nome", "Descrição", "Raridade");
        System.out.println("\033[34m----------------------------------------------\033[0m");

        int index = 1;
        for (Item item : personagem.getInventario()) {
            System.out.printf("\033[34m%-6d %-20s %-30s %-10s\033[0m%n", index, item.getNome(), item.getDescricao(), item.getRaridade());
            index++;
        }
        System.out.println("\033[34m------------------------------------------------------------------------------------------------\033[0m");
    }


    public void verificarEFornecerBau(Personagem jogador) {
        int INIMIGOS_PARA_BAU = 1;

        if (jogador.getInimigosDerrotados() >= INIMIGOS_PARA_BAU ) {
            System.out.println("\033[33mUm baú apareceu! Você ganhou um item.\033[0m");
            Item itemRecebido = GerenciadorItens.gerarItemAleatorio();
            jogador.adicionarItem(itemRecebido);
            System.out.println("\033[33mVocê recebeu: " + itemRecebido.getNome() + " - " + itemRecebido.getDescricao() + "\033[0m");
        }
    }

    public Personagem gerenciadorDeCadastroPersonagens() {
        System.out.println("\nBem vindo ao Gerenciador para cadastro de personagens!");
        System.out.println("+------+--------------+----------------+-------------+-------------+");
        boolean flag = true;
        while (flag) {
            if (personagemSelecionado != null) {
                System.out.println("Personagem selecionado: " + personagemSelecionado.getNome());
                imprimirPersonagemVerde(personagemSelecionado, 0, false);
            }
            System.out.println("1 - Selecionar um personagem");
            System.out.println("2 - Criar novo");
            System.out.println("3 - Voltar ao menu inicial");
            System.out.print("Escolha uma opção: ");

            int opt = scan.nextInt();
            switch (opt) {
                case 1:
                    personagemSelecionado = selecionarPersonagem();
                    break;
                case 2:
                    personagemSelecionado = cadastrarNovoPersonagem();
                    break;
                case 3:
                    if (personagens.isEmpty()) {
                        System.out.println("Não há usuário cadastrado para iniciar uma batalha. Gostaria de sair mesmo assim? (s/n)");
                        char resposta = scan.next().toLowerCase().charAt(0);
                        if (resposta == 's') {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    } else {
                        flag = false;
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
            }
        }
        return personagemSelecionado;
    }

    public static void imprimirPersonagens(ArrayList<Personagem> personagens) {
        System.out.println("+------+--------------+----------------+-------------+-------------+");
        System.out.println("| Índice |    Nome      |  Pontos de Vida |    Força    |   Defesa    |");
        System.out.println("+------+--------------+----------------+-------------+-------------+");

        for (int i = 0; i < personagens.size(); i++) {
            Personagem personagem = personagens.get(i);
            System.out.printf("| \033[32m%-6d\033[0m | \033[32m%-12s\033[0m | \033[32m%-15d\033[0m | \033[32m%-11d\033[0m | \033[32m%-11d\033[0m |\n",
                    i, personagem.getNome(), personagem.getPontosVida(), personagem.getForca(), personagem.getDefesa());
        }

        System.out.println("+------+--------------+----------------+-------------+-------------+");
    }


    public void imprimirPersonagemVerde(Personagem personagem, int vidaInimigo, boolean emBatalha) {
        System.out.println("+------+--------------+----------------+-------------+-------------+");
        System.out.println("|    Nome      |  Pontos de Vida |    Força    |   Defesa    |");
        System.out.println("+------+--------------+----------------+-------------+-------------+");
        System.out.printf("| \033[32m%-12s\033[0m | \033[32m%-15d\033[0m | \033[32m%-11d\033[0m | \033[32m%-11d\033[0m |\n",
                personagem.getNome(), emBatalha ? vidaInimigo : personagem.getPontosVida(), personagem.getForca(), personagem.getDefesa());
        System.out.println("+------+--------------+----------------+-------------+-------------+");
        System.out.println(personagem.getPontosExperiencia()+" XP | NÍVEL " + personagem.getNivel()+ " | TIPO " +personagem.toString()+ "\n");
    }

    public void imprimirPersonagemVermelho(Personagem personagem, int vidaInimigo, boolean emBatalha) {
        System.out.println("+------+--------------+----------------+-------------+-------------+");
        System.out.println("|    Nome      |  Pontos de Vida |    Força    |   Defesa    |");
        System.out.println("+------+--------------+----------------+-------------+-------------+");
        System.out.printf("| \033[31m%-12s\033[0m | \033[31m%-15d\033[0m | \033[31m%-11d\033[0m | \033[31m%-11d\033[0m |\n",
                personagem.getNome(), emBatalha ? vidaInimigo : personagem.getPontosVida(), personagem.getForca(), personagem.getDefesa());
        System.out.println("+------+--------------+----------------+-------------+-------------+");
    }




    public Personagem selecionarPersonagem() {
        imprimirPersonagens(personagens);
        System.out.print("Digite o índice do personagem: ");
        int indice = scan.nextInt();
        if (indice >= 0 && indice < personagens.size()) {
            return personagens.get(indice);
        } else {
            System.out.println("Índice inválido. Tente novamente.");
            return null;
        }
    }

    public void gerenciadorDoJogo(){

        System.out.println("Bem vindo ao jogo RPG de Turno!");
        System.out.println("Para iniciar uma batalha vc deve cadastrar um personagem (tipo Arqueiro, Mago ou Guerreiro)");

        boolean flag = true;
        while (flag) {
            System.out.println("+------+--------------+----------------+-------------+-------------+");
            System.out.println("                      RPG de Turnos                                 ");
            System.out.println("+------+--------------+----------------+-------------+-------------+");
            if (personagemSelecionado != null) {
                System.out.println("Personagem selecionado: " + personagemSelecionado.getNome());
                imprimirPersonagemVerde(personagemSelecionado, 0, false);

            }
            System.out.println("1 - Cadastrar Jogador");
            System.out.println("2 - Iniciar uma batalha");
            System.out.println("3 - Sair do jogo");
            System.out.print("Escolha uma opção: ");

            int opt = scan.nextInt();
            switch (opt) {
                case 1:
                    personagemSelecionado = gerenciadorDeCadastroPersonagens();
                    break;
                case 2:
                    iniciarBatalha(personagemSelecionado);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
            }
        }

    }

    public void iniciarBatalha(Personagem personagemSelecionado){

        if (personagemSelecionado !=null && personagemSelecionado.getNome() != null) {
            Batalha batalha = new Batalha();

            Inimigo inimigoSelecionado = GerenciadorPersonagem.selecionarInimigoAleatorio(inimigos);
            System.out.println("Inimigo selecionado: " + inimigoSelecionado.getNome());
            imprimirPersonagemVermelho(inimigoSelecionado, 0, false);

            this.personagensEmBatalha = new ArrayList<>();
            personagensEmBatalha.add(inimigoSelecionado);
            personagensEmBatalha.add(personagemSelecionado);

            if (batalha.iniciarPartida(personagensEmBatalha)) {
                batalha.ordemPorPontosVida(personagensEmBatalha);
                batalha.imprimirOrdemDosJogadores(personagensEmBatalha);
                iniciandoRodadas(inimigoSelecionado, personagemSelecionado );
            }
        } else {
            System.out.println("Algo deu errado nenhum personagem encontrado");
        }
    }

    public Habilidade selecionarHabilidade(ArrayList<Habilidade> habilidades) {
        System.out.println("Selecione uma habilidade:");

        for (int i = 0; i < habilidades.size(); i++) {
            System.out.println((i + 1) + ". " + habilidades.get(i).getNome());
        }

        System.out.print("Escolha uma opção: ");
        int opt = scan.nextInt();

        if (opt < 1 || opt > habilidades.size()) {
            System.out.println("Opção inválida.");
            return null;
        }

        return habilidades.get(opt - 1);
    }

    public void selecionarEAplicarItem(Personagem personagem, Personagem inimigo) {

        if (personagem.getInventario().isEmpty()) {
            System.out.println("Nenhum item encontrado.");
        } else {
            imprimirItensPersonagem(personagem);
            System.out.print("Escolha um número (digite 0 para nenhum): ");
            int escolha = scan.nextInt();

            if (escolha == 0) {
                System.out.println("Nenhum item selecionado.");
            } else if (escolha > 0 && escolha <= personagem.getInventario().size()) {
                Item itemSelecionado = personagem.getInventario().get(escolha - 1);
                System.out.println("Você selecionou: " + itemSelecionado.getNome());

                if (itemSelecionado.isPocaoSono()) {
                    System.out.println("O inimigo está com sono!");
                    inimigo.setDormindo(true);
                } else if(itemSelecionado.isVeneno()) {
                    System.out.println("O inimigo esta atordoado");
                    inimigo.setAtordoado(true);
                } else if(itemSelecionado.isQueimado()) {
                    System.out.println("O inimigo esta queimado");
                    inimigo.setAtordoado(true);
                }
            } else {
                System.out.println("Opção inválida. Escolha novamente.");
            }
        }
    }




    public void iniciandoRodadas(Personagem inimigo, Personagem jogador) {
        boolean continuarBatalha = true;

        int vidaJogador = jogador.getPontosVida();
        int vidaInimigo = inimigo.getPontosVida();
        int danoBaseInimigo = inimigo.calcularDano(jogador, inimigo.getHabilidades().get(0));;
        int danoBaseJogador = jogador.calcularDano(inimigo, null);

        while (continuarBatalha) {


            for (Personagem personagem : personagensEmBatalha) {
                if (continuarBatalha) {
                    if (personagem instanceof Inimigo) {
                        if (!inimigo.isAtordoado() || !inimigo.isDormindo()) {
                            System.out.println("Inimigo " + personagem.getNome() + " ataca!");
                            System.out.println("Dano causado pelo inimigo: " + danoBaseInimigo + "/" + vidaJogador);

                            vidaJogador = jogador.atacar(danoBaseInimigo, vidaJogador);
                            imprimirPersonagemVerde(jogador, vidaJogador, true);

                            if (vidaJogador <= 0) {
                                System.out.println("Você foi derrotado! Fim da batalha.");
                                continuarBatalha = false;
                                break;
                            }
                        } else {
                            if (inimigo.isAtordoado()) {
                                System.out.println("Inimigo " + personagem.getNome() + " está atordoado e não pode atacar.");
                                inimigo.setAtordoado(false);
                            }
                            if (inimigo.isDormindo()) {
                                System.out.println("Inimigo " + personagem.getNome() + " está dormindo e não pode atacar.");
                                inimigo.setDormindo(false);
                            }
                        }

                    } else {
                        boolean escolhaValida = false;
                        while (!escolhaValida) {
                            System.out.println("O que você gostaria de fazer, " + personagem.getNome() + "?");
                            System.out.println("1 - Atacar");
                            System.out.println("2 - Usar Habilidade");
                            System.out.println("3 - Defender");
                            System.out.println("4 - Ver items");
                            System.out.println("5 - Fugir");
                            System.out.print("Escolha uma opção: ");
                            int opt = scan.nextInt();

                            switch (opt) {
                                case 1:
                                    System.out.println("Dano causado pelo jogador: " + danoBaseJogador + "/" + vidaInimigo);

                                    vidaInimigo = jogador.atacar(danoBaseJogador, vidaInimigo);
                                    imprimirPersonagemVermelho(inimigo, vidaInimigo, true);

                                    if (vidaInimigo <= 0) {
                                        System.out.println("Inimigo derrotado! Fim da batalha.");
                                        continuarBatalha = false;

                                        int experienciaGanha = inimigo instanceof Inimigo ? ((Inimigo) inimigo).getRecompensaXP() : 0;
                                        jogador.setPontosExperiencia(jogador.getPontosExperiencia() + experienciaGanha);
                                        System.out.println("Você ganhou " + experienciaGanha + " pontos de experiência. Total: " + jogador.getPontosExperiencia());
                                        GerenciadorPersonagem.verificarNivel(personagem);
                                        verificarEFornecerBau(personagem);
                                        break;
                                    }
                                    break;
                                case 2:
                                    System.out.println("Escolha uma habilidade para atacar:");
                                    Habilidade habilidadeSelecionada = selecionarHabilidade(jogador.getHabilidades());
                                    danoBaseJogador = personagem.calcularDano(inimigo, habilidadeSelecionada);
                                    System.out.println("Dano causado pelo jogador: " + danoBaseJogador + "/" + vidaInimigo);

                                    vidaInimigo = jogador.atacar(danoBaseJogador, vidaInimigo);
                                    imprimirPersonagemVermelho(inimigo, vidaInimigo, true);

                                    if (vidaInimigo <= 0) {
                                        System.out.println("Inimigo derrotado! Fim da batalha.");
                                        continuarBatalha = false;

                                        int experienciaGanha = inimigo instanceof Inimigo ? ((Inimigo) inimigo).getRecompensaXP() : 0;
                                        jogador.setPontosExperiencia(jogador.getPontosExperiencia() + experienciaGanha);
                                        System.out.println("Você ganhou " + experienciaGanha + " pontos de experiência. Total: " + jogador.getPontosExperiencia());
                                        GerenciadorPersonagem.verificarNivel(personagem);
                                        verificarEFornecerBau(personagem);
                                        break;
                                    }
                                    break;
                                case 3:
                                    danoBaseInimigo = jogador.defender(danoBaseInimigo);
                                    System.out.println("Dano do inimigo reduzido para: " + danoBaseInimigo);
                                    imprimirPersonagemVermelho(inimigo,vidaInimigo, true);
                                    break;
                                case 4:
                                    selecionarEAplicarItem(personagem, inimigo);
                                    break;
                                case 5:

                                    jogador.fugir();
                                    continuarBatalha = false;
                                    break;
                                default:
                                    System.out.println("Opção inválida. Escolha novamente.");
                                    break;
                            }

                            if (opt == 1 || opt == 2 || opt==3 || opt==5) {
                                escolhaValida = true;
                            }
                        }
                    }
                }
            }
        }
    }



}




