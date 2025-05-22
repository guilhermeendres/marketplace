package marketplace;

import java.util.ArrayList;
import java.util.List;

public class Loja {

    private List<Cliente> clientes;
    private List<Fornecedor> fornecedores;
    private List<Admin> admins;
    private List<Produto> produtos;

    public Loja() {
        this.clientes = new ArrayList<>();
        this.fornecedores = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public boolean addUsuario(Usuario usuario) {
        if (usuario != null) {
            switch (usuario) {
                case Cliente cliente -> {
                    usuario.setId(this.clientes.size());
                    return (clientes.add(cliente));
                }
                case Fornecedor fornecedor -> {
                    usuario.setId(this.fornecedores.size());
                    return (fornecedores.add(fornecedor));
                }
                case Admin admin -> {
                    usuario.setId(this.admins.size());
                    return (admins.add(admin));
                }
                default -> {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean editar(Usuario usuarioEditado) {
        if (usuarioEditado == null || usuarioEditado.getId() < 0) {
            return false;
        }

        boolean result = false;
        Usuario alvo = null;

        switch (usuarioEditado) {
            case Cliente cliente -> {
                if (usuarioEditado.getId() < clientes.size()) {
                    alvo = clientes.get(usuarioEditado.getId());
                    ((Cliente) alvo).setCartaoCredito(cliente.getCartaoCredito());
                    result = true;
                }
            }
            case Fornecedor fornecedor -> {
                if (usuarioEditado.getId() < fornecedores.size()) {
                    alvo = fornecedores.get(usuarioEditado.getId());
                    ((Fornecedor) alvo).setDescricao(fornecedor.getDescricao());
                    result = true;
                }
            }
            default -> {
                return false;
            }
        }

        if (alvo != null) {
            alvo.setNome(usuarioEditado.getNome());
            alvo.setTelefone(usuarioEditado.getTelefone());
            alvo.setEmail(usuarioEditado.getEmail());
            alvo.setSenha(usuarioEditado.getSenha());
            alvo.setEndereco(usuarioEditado.getEndereco());
        }

        return result;
    }

    public boolean editar(Produto produtoEditado) {
        if (produtoEditado == null || produtoEditado.getId() < 0 || produtoEditado.getId() >= produtos.size()) {
            return false;
        }

        Produto alvo = produtos.get(produtoEditado.getId());
        alvo.setNome(produtoEditado.getNome());
        alvo.setDescricao(produtoEditado.getDescricao());
        alvo.setFornecedor(produtoEditado.getFornecedor());
        alvo.setEstoque(produtoEditado.getEstoque());
        return true;
    }

    public boolean remover(Usuario usuario) {
        if (usuario != null) {
            switch (usuario) {
                case Cliente cliente -> {
                    return (clientes.remove(cliente));
                }
                case Fornecedor fornecedor -> {
                    return (fornecedores.remove(fornecedor));
                }
                default -> {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean remover(Produto produto) {
        return produto != null && produtos.remove(produto);
    }

    public Usuario procurar(String[] login) {
        if (login == null || login.length < 2) {
            return new Usuario();
        }

        String email = login[0];
        String senha = login[1];

        for (Cliente cliente : clientes) {
            if (email.equals(cliente.getEmail()) && senha.equals(cliente.getSenha())) {
                return cliente;
            }
        }

        for (Fornecedor fornecedor : fornecedores) {
            if (email.equals(fornecedor.getEmail()) && senha.equals(fornecedor.getSenha())) {
                return fornecedor;
            }
        }

        for (Admin admin : admins) {
            if (email.equals(admin.getEmail()) && senha.equals(admin.getSenha())) {
                return admin;
            }
        }
        return new Usuario();
    }

    public Fornecedor getFornecedor(int id) {
        if (id >= 0 && id < fornecedores.size()) {
            return fornecedores.get(id);
        }
        return new Fornecedor();
    }

    public Fornecedor getFornecedor(String nome) {
        if (nome != null) {
            for (Fornecedor fornecedor : fornecedores) {
                if (fornecedor.getNome().equalsIgnoreCase(nome)) {
                    return fornecedor;
                }
            }
        }
        return new Fornecedor();
    }

    public Cliente getCliente(int id) {
        if (id >= 0 && id < clientes.size()) {
            return clientes.get(id);
        }
        return new Cliente();
    }

    public Cliente getCliente(String nome) {
        if (nome != null) {
            for (Cliente cliente : clientes) {
                if (cliente.getNome().equalsIgnoreCase(nome)) {
                    return cliente;
                }
            }
        }
        return new Cliente();
    }

    public boolean addProduto(Produto produto) {
        if (produto != null && produto.getFornecedor() != null) {
            int fornecedorId = produto.getFornecedor().getId();
            if (fornecedorId >= 0 && fornecedorId < fornecedores.size()) {
                produto.setId(produtos.size());
                return produtos.add(produto);
            }
        }
        return false;
    }

    public Produto getProduto(int id) {
        if (id >= 0 && id < produtos.size()) {
            return produtos.get(id);
        }
        return new Produto();
    }

    public Produto getProduto(String nome) {
        if (nome != null) {
            for (Produto produto : produtos) {
                if (produto.getNome().equalsIgnoreCase(nome)) {
                    return produto;
                }
            }
        }
        return new Produto();
    }
}
