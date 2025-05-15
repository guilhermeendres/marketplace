package marketplace;

import java.util.List;

public class Fornecedor {
	
	private String nome;
	private String descricao;
	private String email;
	private String telefone;
	private Endereco endereco;
	private List<Produto> produtos;
	
	public Fornecedor(String nome, String descricao, String email, String telefone, Endereco endereco) {
		this.nome = nome;
		this.descricao = descricao;
		this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
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
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto getProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto != null && produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }
	
	@Override
	public String toString() {
		return ("\nFornecedor: " + this.nome + 
				"\nDescrição: " + this.descricao +
				"\nTelefone: " + this.telefone + " E-mail: " + this.email);
	}

}
