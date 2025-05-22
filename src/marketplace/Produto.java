package marketplace;

public class Produto {

    private String nome;
    private String descricao;
    private int id;
    private Fornecedor fornecedor;
    private Estoque estoque;

    public Produto(String nome, String descricao, int id) {
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
        this.estoque = new Estoque();
        this.estoque.setQuantidade(0);
        this.estoque.setPreco(0);
    }

    public Produto () {
        this.nome = " ";
        this.descricao = " ";
        this.id = 0;
        this.estoque = new Estoque();
        this.estoque.setQuantidade(0);
        this.estoque.setPreco(0);
    }

    public Produto(String params[]) {
        this.nome = params[0];
        this.descricao = params[1];
        this.estoque = new Estoque(Integer.parseInt(params[2]), Double.parseDouble(params[3]));
    }

    public Produto(String params[], Fornecedor fornecedor) {
        this(params);
        this.fornecedor = fornecedor;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return ("\nProduto #" + this.id
                + "\nNome: " + this.nome
                + "\nDescrição: " + this.descricao
                + "\nFornecedor: " + this.fornecedor.getNome()
                + "\nQuantidade em estoque: " + this.estoque.getQuantidade()
                + "\nPreço: " + this.estoque.getPreco());
    }

}
