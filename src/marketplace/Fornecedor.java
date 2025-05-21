package marketplace;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor{

	private String cnpj;
	private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;
    private String desc;
    private List<Produto> produtos;

    public Fornecedor(String params[]) {
        this.nome = params[0];
        this.desc = params[1];
        this.telefone = params[2];
        this.email = params[3];
        this.cnpj = params[4];
        this.endereco.setRua(params[5]);
        this.endereco.setNumero(params[6]);
        this.endereco.setBairro(params[7]);
        this.endereco.setComplemento(params[8]);
        this.endereco.setCidade(params[9]);
        this.endereco.setEstado(params[10]);
        this.endereco.setCep(params[11]);
        this.produtos = new ArrayList<>(null);
    }

    public String getDescricao() {
        return desc;
    }
    public void setDescricao(String descricao) {
        this.desc = descricao;
    }

    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
        return ("\nCNPJ: " + this.getCnpj() + " | Fornecedor: " + this.getNome() + " | Descrição: " + this.getDescricao()
                + "\nTelefone: " + this.getTelefone() + " | E-mail: " + this.getEmail());
    }

}
