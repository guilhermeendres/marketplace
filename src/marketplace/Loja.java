package marketplace;

import java.io.FileReader;
import java.security.Identity;
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

    public boolean editar(Usuario usuarioEditado) {
        Usuario alvo;
        boolean result = false;
        switch (usuarioEditado) {
            case Cliente cliente -> {
                alvo = clientes.get(usuarioEditado.getId());
                ((Cliente) alvo).setCartaoCredito(((Cliente) usuarioEditado).getCartaoCredito());
                result = true;
            }
            case Fornecedor fornecedor -> {
                alvo = fornecedores.get(usuarioEditado.getId());
                ((Fornecedor) alvo).setDescricao(((Fornecedor) usuarioEditado).getDescricao());
                result = true;
            }
            default -> {
                alvo = new Usuario();
            }
        }
        alvo.setNome(usuarioEditado.getNome());
        alvo.setTelefone(usuarioEditado.getTelefone());
        alvo.setEmail(usuarioEditado.getEmail());
        alvo.setSenha(usuarioEditado.getSenha());
        alvo.setEndereco(usuarioEditado.getEndereco());
        return result;
    }

    public boolean editar(Produto produtoEditado) {
        Produto alvo;
        boolean result = false;
        alvo = produtos.get(produtoEditado.getId());
        if (alvo != null) {
            result = true;
        }
        alvo.setNome(produtoEditado.getNome());
        alvo.setDescricao(produtoEditado.getDescricao());
        alvo.setFornecedor(produtoEditado.getFornecedor());
        alvo.setEstoque(produtoEditado.getEstoque());
        return result;
    }

    public boolean remover(Usuario usuario) {
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

    public boolean remover(Produto produto) {
        return produtos.remove(produto);
    }

    public Usuario procurar(String[] login) {

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

        if (fornecedores != null) {
            for (Fornecedor fornecedor : fornecedores) {
                if (email.equals(fornecedor.getEmail()) && senha.equals(fornecedor.getSenha())) {
                    return fornecedor;
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

    public Fornecedor getFornecedor(int id) {
        if (fornecedores != null) {
            for (Fornecedor fornecedor : fornecedores) {
                if (fornecedor.getId() == id) {
                    return fornecedor;
                }
            }
        }
        return new Fornecedor(); 
    }

    public Fornecedor getFornecedor(String nome) {
        if (fornecedores != null) {
            for (Fornecedor fornecedor : fornecedores) {
                if (fornecedor.getNome().equalsIgnoreCase(nome)) {
                    return fornecedor;
                }
            }
        }
        return new Fornecedor(); 
    }

    public Cliente getCliente(int id) {
        if (clientes != null) {
            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    return cliente;
                }
            }
        }
        return new Cliente(); 
    }

    public Cliente getCliente(String nome) {
        if (clientes != null) {
            for (Cliente cliente : clientes) {
                if (cliente.getNome().equalsIgnoreCase(nome)) {
                    return cliente;
                }
            }
        }
        return new Cliente(); 
    }

    public boolean addProduto(Produto produto) {
        boolean result = false;
        if (produto != null) {
            try {
                getFornecedor(produto.getFornecedor().getId());
            } catch (Exception e) {
                return false;
            }
            finally {
                if (result) {
                    return (produtos.add(produto)); 
                }
            }
        }
        return false;
    }

    public Produto getProduto(int id) {
        if (produtos != null) {
            for (Produto produto : produtos) {
                if (produto.getId() == id) {
                    return produto;
                }
            }
        }
        return new Produto(); 
    }

    public Produto getProduto(String nome) {
        if (produtos != null) {
            for (Produto produto : produtos) {
                if (produto.getNome().equalsIgnoreCase(nome)) {
                    return produto;
                }
            }
        }
        return new Produto(); 
    }
}
