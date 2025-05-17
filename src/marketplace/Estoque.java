package marketplace;

public class Estoque {
	
	private int quantidade;
	private double preco;
	private Produto produto;
	
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
	
	public Produto getProduto() {
		return produto;
	}
	
	@Override
	public String toString() {
		return ("\nProduto #" + this.produto.getCodigo() +
				"\nNome: " + this.produto.getNome() +
				"\nQuantidade em estoque: " + this.quantidade + 
				"\nPreço: " + this.preco);
	}

}
