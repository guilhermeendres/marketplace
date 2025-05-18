package marketplace;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private String cartaoCredito;
    private List<Pedido> pedidos;

    public Cliente(Usuario usuario, String cartaoCredito) {
        super(usuario.getNome(), usuario.getTelefone(), usuario.getEmail(), usuario.getSenha(), usuario.getEndereco());
        this.cartaoCredito = cartaoCredito;
        this.pedidos = new ArrayList<>();
    }

    public Cliente() {
        super();
        this.cartaoCredito = "";
        this.pedidos = new ArrayList<>();
    }

    public Cliente(String params[]) {
        super(params);
        this.cartaoCredito = params[11];
        this.pedidos = new ArrayList<>();
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Pedido getPedido(int numero) {
        for (Pedido pedido : pedidos) {
            if (pedido != null && pedido.getNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

}
