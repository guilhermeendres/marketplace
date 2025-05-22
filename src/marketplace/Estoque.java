package marketplace;

public class Estoque {

    private int quantidade;
    private double preco;
    private Produto produto;

    public Estoque(int quantidade, double preco) {
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Estoque() {
        this.quantidade = 0;
        this.preco = 0;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setProduto(Produto produto) {
        if (this.produto == null) {
            this.produto = produto;
            produto.setEstoque(this);
        }
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return ("\nProduto #" + this.produto.getId()
                + "\nNome: " + this.produto.getNome()
                + "\nQuantidade em estoque: " + this.quantidade
                + "\nPreço: " + this.preco);
    }

}
