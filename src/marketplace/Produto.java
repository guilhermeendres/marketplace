package marketplace;

public class Produto {
	
	private String nome;
	private String descricao;
	private int codigo;
	private Fornecedor fornecedor;
	private Estoque estoque;
	
	public Produto(String nome, String descricao, int cod) {
		this.nome = nome;
		this.descricao = descricao;
		this.codigo = cod;
		this.estoque.setPreco(0);
		this.estoque.setQuantidade(0);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	@Override
	public String toString() {
		return ("\nProduto #" + this.codigo +
				"\nNome: " + this.nome +
				"\nDescrição: " + this.descricao +
				"\nFornecedor: " + this.fornecedor.getNome() + 
				"\nQuantidade em estoque: " + this.estoque.getQuantidade() + 
				"\nPreço: " + this.estoque.getPreco());
	}
	
}
