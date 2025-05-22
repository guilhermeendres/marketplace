package marketplace;

public class Admin extends Usuario {

    private Loja loja;

    public Admin(Usuario usuario, Loja loja) {
        super(usuario.getNome(), usuario.getTelefone(), usuario.getEmail(), usuario.getSenha(), usuario.getEndereco());
        this.loja = loja;
    }

    public Admin() {
        super();
        this.loja = new Loja();
    }

    public Admin(String params[], Loja loja) {
        super(params);
        this.loja = loja;
    }

    public void cadastrar(Usuario usuario) {
        loja.addUsuario(usuario);
    }

    public boolean cadastrar(Produto produto) {
        if (!((this.procurar(produto.getFornecedor())).getNome().isBlank())) {
            loja.addProduto(produto);
            return true;
        }
        return false;
    }

    public void editar(Usuario usuarioEditado) {
        Usuario usuario = this.procurar(usuarioEditado);
        usuarioEditado.setId(usuario.getId());
        loja.editar(usuarioEditado);
    }

    public void editar(Produto produtoEditado) {
        Produto produto = this.procurar(produtoEditado);
        produtoEditado.setId(produto.getId());
        loja.editar(produtoEditado);
    }

    public Usuario procurar(Usuario usuario) {

        if (usuario instanceof Cliente) {
            if (usuario.getNome().isBlank()) {
                return loja.getCliente(usuario.getId());
            } else if (usuario.getId() >= 0) {
                return loja.getCliente(usuario.getNome());
            }
        } else if (usuario instanceof Fornecedor) {
            if (usuario.getNome().isBlank()) {
                return loja.getFornecedor(usuario.getId());
            } else if (usuario.getId() >= 0) {
                return loja.getFornecedor(usuario.getNome());
            }
        }

        return new Usuario();
    }

    public Produto procurar(Produto produto) {
        if (produto.getNome().isBlank()) {
            return loja.getProduto(produto.getId());
        } else if (produto.getId() >= 0) {
            return loja.getProduto(produto.getNome());
        }
        return new Produto();
    }

    public void remover(Usuario usuario) {
        if (usuario instanceof Cliente) {
            usuario = this.loja.getCliente(usuario.getId());
        } else if (usuario instanceof Fornecedor) {
            usuario = this.loja.getFornecedor(usuario.getId());
        }
        this.loja.remover(usuario);
    }

    public void remover(Produto produto) {
        produto = this.loja.getProduto(produto.getId());
        this.loja.remover(produto);
    }

    @Override
    public String toString() {
        return "Admin{"
                + "nome='" + getNome() + '\''
                + ", telefone='" + getTelefone() + '\''
                + ", email='" + getEmail() + '\''
                + ", senha='" + getSenha() + '\''
                + ", endereco=" + getEndereco()
                + '}';
    }
}
