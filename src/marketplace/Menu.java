package marketplace;

public class Menu {

    private Tela tela;

    public Menu() {
        tela = new Tela();
    }

    public int autenticacao() {
        return (tela.requisitarOpcao(
                "======== ATENTICAÇÃO ========",
                "Faça login ou cadastre-se:",
                new String[]{
                    "Sair",
                    "Login",
                    "Cadastro"
                }
        ));
    }

    public int selecaoTipoUsuario() {
        return (tela.requisitarOpcao(
                "======== CADASTRO ========",
                "Selecione o tipo de cadastro:",
                new String[]{
                    "Voltar",
                    "Admin",
                    "Cliente",
                }
        ));
    }

    public String[] cadastro(Usuario tipoUsuario) {
        tela.mostrarMensagem("Preencha os dados do usuário:");
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
                    "CEP: ",
                    "Cidade: ",
                    "Estado: ",
                    tipoUsuario instanceof Cliente ? "Cartão de Crédito: " : ""
                }
        ));
    }

    public String[] login() {
        return (tela.requisitarTexto(
                "======== LOGIN ========",
                "Por favor, insira suas credenciais:",
                new String[]{
                    "E-mail: ",
                    "Senha: "
                }
        ));
    }

    public int retry(String mensagem) {
        return (tela.requisitarOpcao(
                "Erro:",
                mensagem,
                new String[]{
                    "Voltar",
                    "Tentar novamente"
                }
        ));
    }

    public int dashboard(Usuario tipoUsuario) {
        return tela.requisitarOpcao(
                "======== DASHBOARD ========",
                "Selecione uma opção",
                tipoUsuario instanceof Admin ? new String[]{
                    "Voltar",
                    "Gerenciar Fornecedores",
                    "Gerenciar Produtos"
                } : tipoUsuario instanceof Cliente ? new String[]{
                    "Voltar",
                    "Buscar Produto",
                    "Ver Pedidos"
                } : new String[]{}
        );
    }

    public String[] buscaProduto() {
        return (tela.requisitarTexto(
                "---- Buscar Produto ----",
                new String[]{"Digite o nome do produto que deseja buscar: "}
        ));
    }
    
    public int telaFornecedores() {
        return (tela.requisitarOpcao(
                "======== FORNECEDORES ========",
                new String[]{
                    "Voltar",
                    "Cadastrar",
                    "Alterar",
                    "Remover",
                    "Listar",
                    "Buscar"
                }
        ));
    }
    
    public int telaBuscaFronecedor() {
        return (tela.requisitarOpcao(
                "---- Buscar Fornecedor ----",
                new String[]{
                    "Voltar",
                    "Por nome",
                    "Por cnpj",
                }
        ));
    }
    
    public String[] cadastroFornecedor() {
    	tela.mostrarMensagem("---- Cadastro de Fornecedor ----");
        tela.mostrarMensagem("Preencha os dados do fornecedor:");
        
        return (tela.requisitarTexto(
                new String[]{
                    "Nome: ",
                    "Descrição",
                    "Telefone: ",
                    "E-mail: ",
                    "CNPJ: ",
                    "Rua: ",
                    "Número: ",
                    "Bairro: ",
                    "Complemento: ",
                    "Cidade: ",
                    "Estado: ",
                    "CEP: ",
                }
        ));
    }


}
