package marketplace;

import java.util.ArrayList;
import java.util.List;

public class Loja {

    private List<Cliente> clientes;
    private List<Fornecedor> fornecedores;
    private List<Admin> admins;
    private List<Produto> produtos = new ArrayList<>();

    public Loja() {
        this.clientes = new ArrayList<>();
        this.fornecedores = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public boolean addUsuario(Usuario usuario) {
        switch (usuario) {
            case Cliente cliente -> {
                return (clientes.add(cliente));
            }
            case Admin admin -> {
                return (admins.add(admin));
            }
            default -> {
                return false;
            }
        }
    }

    public Usuario procurarCadastro(String[] login) {

        if (login == null || login.length < 2) {
            return new Usuario();
        }

        String email = login[0];
        String senha = login[1];

        if (clientes != null) {
            for (Cliente cliente : clientes) {
                if (email.equals(cliente.getEmail()) && senha.equals(cliente.getSenha())) {
                    return cliente;
                }
            }
        }

        if (admins != null) {
            for (Admin admin : admins) {
                if (email.equals(admin.getEmail()) && senha.equals(admin.getSenha())) {
                    return admin;
                }
            }
        }

        return new Usuario();
    }

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

    /*public void addProduto(Produto produto) {
        if (produto != null) {
            produtos.add(produto);

        }
    }

    public void addRegistroEstoque(Produto produto, int quantidade, double preco) {
        if (produto != null) {
            Estoque novoEstoque = new Estoque();
            novoEstoque.setProduto(produto);
            novoEstoque.setQuantidade(quantidade);
            novoEstoque.setPreco(preco);
        }
    }

    public void atualizarRegistroEstoque(Produto produto, int quantidade, double preco) {
        if (produto != null) {
            
        }
    }*/

}
