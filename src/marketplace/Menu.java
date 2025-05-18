package marketplace;

public class Menu {

    private Tela tela;

    public Menu() {
        tela = new Tela();
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

    public int selecaoTipoUsuario() {
        return (tela.requisitarOpcao(
                "Cadastro",
                "Selecione o tipo de cadastro",
                new String[]{
                    "Voltar",
                    "Admin",
                    "Cliente",
                    "Fornecedor"
                }
        ));
    }

    public String[] cadastro(Usuario tipoUsuario) {
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
                    tipoUsuario instanceof Fornecedor ? "Descrição: " : tipoUsuario instanceof Cliente ? "Cartão de Crédito: " : ""
                }
        ));
    }

    public String[] login() {
        return (tela.requisitarTexto(
                "Login",
                "Por favor, insira seu e-mail e senha",
                new String[]{
                    "E-mail: ",
                    "Senha: "
                }
        ));
    }

    public int retry(String mensagem) {
        return (tela.requisitarOpcao(
                "Erro",
                mensagem,
                new String[]{
                    "Voltar",
                    "Tentar novamente"
                }
        ));
    }

    public int dashboard(Usuario tipoUsuario) {
        return (tela.requisitarOpcao(
                "Dashboard",
                "Selecione uma opção",
                new String[]{
                    "Voltar",
                    "Comprar",
                    "Vender",
                    "Gerenciar Estoque"
                }
        ));
    }
}
