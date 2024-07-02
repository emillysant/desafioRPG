package Item;

public class Item {
    private String nome;
    private String descricao;
    private TipoRaridade raridade;

    public Item(String nome, String descricao, TipoRaridade raridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.raridade = raridade;
    }

    public String getNome() {
        return nome;
    }

    public TipoRaridade getRaridade() {
        return raridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isPocaoSono() {
        return this.nome.toLowerCase().contains("poção do sono");
    }

    public boolean isVeneno() {
        return this.nome.toLowerCase().contains("veneno");
    }

    public boolean isQueimado() {
        return this.nome.toLowerCase().contains("queimadura");
    }



    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}