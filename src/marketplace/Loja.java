package marketplace;

import java.util.List;
import java.util.ArrayList;

public class Loja {
    private List<Cliente> clientes;
    private List<Fornecedor> fornecedores;
    private Estoque estoque;

    public Loja() {
        this.clientes = new ArrayList<>();
        this.fornecedores = new ArrayList<>();
        this.estoque = new Estoque();
    }
}
