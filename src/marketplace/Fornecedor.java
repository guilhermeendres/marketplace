package marketplace;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor extends Usuario {

    private String descricao;
    private List<Produto> produtos;
    private Loja loja;

    public Fornecedor(Usuario usuario, String descricao) {
        super(usuario.getNome(), usuario.getTelefone(), usuario.getEmail(), usuario.getSenha(), usuario.getEndereco());
        this.descricao = descricao;
        this.produtos = new ArrayList<>();
    }

    public Fornecedor() {
        super();
        this.descricao = "";
        this.produtos = new ArrayList<>();
    }

    public Fornecedor(String params[]) {
        super(params);
        this.descricao = params[11];
        this.produtos = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public void addProdutoLoja(Produto produto) {
        if (produto != null) {
            loja.addProduto(produto);
        }
    }

    @Override
    public String toString() {
        return ("\nFornecedor: " + this.getNome()
                + "\nDescrição: " + this.getDescricao()
                + "\nTelefone: " + this.getTelefone() + " E-mail: " + this.getEmail());
    }

}
