package marketplace;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	private String cartaoCredito;
	private List<Pedido> pedidos;
	
	public Cliente(String cartaoCredito) {
		super();
		this.cartaoCredito = cartaoCredito;
		this.pedidos = new ArrayList<>();
	}
	
	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public Pedido getPedido(int numero) {
		for(Pedido pedido : pedidos) {
			if(pedido != null && pedido.getNumero() == numero) {
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
