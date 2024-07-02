package Item;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GerenciadorItens {

    private static final List<Item> POSSIVEIS_ITENS = Arrays.asList(
            new Item("Espada Comum", "Uma espada simples", TipoRaridade.COMUM),
            new Item("Poção de Vida", "Restaura 50 pontos de vida", TipoRaridade.COMUM),
            new Item("Armadura Rara", "Fornece uma defesa boa", TipoRaridade.RARO),
            new Item("Elixir Mágico", "Restaura completamente a mana", TipoRaridade.EPICO),
            new Item("Anel da Força", "Aumenta a força em 10 pontos", TipoRaridade.EPICO),
            new Item("Veneno", "Atordoar o inimigo", TipoRaridade.COMUM),
            new Item("Queimadura", "Queima o inimigo", TipoRaridade.COMUM),
            new Item("Poção do Sono", "Deixa o inimigo sem jogar pro um turno", TipoRaridade.COMUM),
            new Item("Armadura de Dragão", "Fornece uma defesa excepcional", TipoRaridade.LENDARIO)
    );

    public static Item gerarItemAleatorio() {
        Random random = new Random();
        int index = random.nextInt(POSSIVEIS_ITENS.size());
        return POSSIVEIS_ITENS.get(index);
    }
}
