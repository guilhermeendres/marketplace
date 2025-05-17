package marketplace;

public class Menu {

    private Tela tela;

    public Menu() {
        tela = new Tela();
    }

    public int inicio() {

        return (tela.requisitarOpcao(
                "Início",
                "Selecione o nível de acesso",
                new String[]{
                    "Sair",
                    "Admin",
                    "Usuário"
                }
        ));
    }

    public int autenticacao() {
        return (tela.requisitarOpcao(
                "Autenticação",
                "Faça login ou cadastre-se",
                new String[]{
                    "Sair",
                    "Login",
                    "Cadastro"
                }
        ));
    }

    public int selecaoTipoCadastro() {
        return (tela.requisitarOpcao(
                "Cadastro",
                "Selecione o tipo de cadastro",
                new String[]{
                    "Sair",
                    "Fornecedor",
                    "Cliente"
                }
        ));
    }

    public String[] cadastro(Usuario usuario) {
        tela.mostrarMensagem("Preencha os dados do usuário");
        return (tela.requisitarTexto(
                new String[]{
                    "Nome: ",
                    "Telefone: ",
                    "E-mail: ",
                    "Senha: ",
                    "Rua: ",
                    "Número: ",
                    "Complemento: ",
                    "Bairro: ",
                    "CEP:",
                    "Cidade: ",
                    "Estado: ",
                    usuario instanceof Fornecedor ? "Descrição: " : "Cartão de crédito: "
                }
        ));
    }

    public String[] login() {
        return (tela.requisitarTexto(
                new String[]{
                    "E-mail: ",
                    "Senha: "
                }
        ));
    }
}
