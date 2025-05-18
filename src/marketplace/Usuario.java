package marketplace;

public class Usuario {

    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private Endereco endereco;

    public Usuario(String nome, String telefone, String email, String senha, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Usuario() {
        this.nome = "";
        this.telefone = "";
        this.email = "";
        this.senha = "";
        this.endereco = new Endereco();
    }

    public Usuario(String params[]) {
        this.nome = params[0];
        this.telefone = params[1];
        this.email = params[2];
        this.senha = params[3];
        this.endereco = new Endereco(params[4], params[5], params[6], params[7], params[8], params[9], params[10]);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
