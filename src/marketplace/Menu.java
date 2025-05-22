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

    public String[] cadastro(Produto produto) {
        tela.mostrarMensagem("Preencha os dados do produto");
        return (tela.requisitarTexto(
                new String[]{
                    "Nome: ",
                    "Descrição: ",
                    "Quantidade: ",
                    "Preço: ",
                    "Código do Fornecedor"
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
        return tela.requisitarOpcao(
                "Dashboard",
                "Selecione uma opção",
                tipoUsuario instanceof Admin ? new String[]{
                    "Voltar",
                    "Gerenciar Fornecedores",
                    "Gerenciar Clientes",
                    "Gerenciar Produtos"
                } : tipoUsuario instanceof Fornecedor ? new String[]{
                    "Voltar",
                    "Adicionar Produto",
                    "Remover Produto",
                    "Listar Produtos"
                } : tipoUsuario instanceof Cliente ? new String[]{
                    "Voltar",
                    "Buscar Produto",
                    "Ver Pedidos"
                } : new String[]{}
        );
    }

    public int gerenciamento() {
        return (tela.requisitarOpcao(
                "Gerenciamento",
                "Selecione uma opção: ",
                new String[]{
                    "Voltar",
                    "Adicionar",
                    "Editar",
                    "Remover",
                    "Procurar"
                }
        ));
    }

    public int pedirTipoBusca() {
        return(tela.requisitarOpcao(
            "Selecione a opção:",
            new String[]{
                "Voltar",
                "Busca por id",
                "Busca por nome"
            }
        ));
    }

    public int pedirId() {
        return (tela.requisitarEntradaNumerica(
            new String[] {
                "Digite o id do usuario: "
            }
        ));
    }

    public String[] pedirNome() {
        return (tela.requisitarTexto(
            new String[] {
                "Digite o nome do usuario: "
            }
        ));
    }

    public String[] editar(Usuario tipoUsuario) {
        return (tela.requisitarTexto(
                new String[]{
                    "Novo nome: ",
                    "Novo telefone: ",
                    "Novo E-mail: ",
                    "Nova Senha: ",
                    "Nova Rua: ",
                    "Novo Número: ",
                    "Novo Complemento: ",
                    "Novo Bairro: ",
                    "Novo CEP:",
                    "Nova Cidade: ",
                    "Novo Estado: ",
                    tipoUsuario instanceof Fornecedor ? "Nova Descrição: " : tipoUsuario instanceof Cliente ? "Novo Cartão de Crédito: " : ""
                }
        ));
    }

    public String[] editar(Produto produto) {
        return (tela.requisitarTexto(
            new String[]{
                "Novo nome: ",
                "Nova descrição: ",
                "Nova quantidade: ",
                "Novo preço: "
            }
    ));
    }

    public int procurar(Usuario tipoUsuario) {
        return (tela.requisitarOpcao(
                "Escolha o modo de busca",
                new String[]{
                    "Busca por Id",
                    "Busca por Nome"
                }
        ));
    }

    public String[] buscaProduto() {
        return (tela.requisitarTexto(
                "Buscar Produto",
                new String[]{"Digite o nome do produto que deseja buscar: "}
        ));
    }

}
