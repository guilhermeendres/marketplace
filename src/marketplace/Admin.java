package marketplace;

public class Admin extends Usuario {

    public Admin(Usuario usuario) {
        super(usuario.getNome(), usuario.getTelefone(), usuario.getEmail(), usuario.getSenha(), usuario.getEndereco());
    }

    public Admin() {
        super();
    }

    public Admin(String params[]) {
        super(params);
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
