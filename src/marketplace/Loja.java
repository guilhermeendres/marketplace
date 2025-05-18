package marketplace;

import java.util.ArrayList;
import java.util.List;

public class Loja {

    private List<Cliente> clientes;
    private List<Fornecedor> fornecedores;
    private List<Admin> admins;
    private Estoque estoque;

    public Loja() {
        this.clientes = new ArrayList<>();
        this.fornecedores = new ArrayList<>();
        this.estoque = new Estoque();
    }

    public boolean addUsuario(Usuario usuario) {
        switch (usuario) {
            case Cliente cliente -> {
                return (clientes.add(cliente));
            }
            case Fornecedor fornecedor -> {
                return (fornecedores.add(fornecedor));
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
            return null;
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

        return null;
    }
}
