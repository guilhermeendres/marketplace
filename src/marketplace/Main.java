package marketplace;

import marketplace.Menu.TipoUsuario;

public class Main {

    private enum MainState {
        INICIO,
        LOGIN,
        CADASTRO,
        SAIR
    }

    private enum ClienteState {
        BUSCA,
        PEDIDOS,
        COMPRA,
        CANCELA_COMPRA,
    }

    private enum FornecedorState {
        ADICIONAR,
        PEDIDOS,
        CANCELA_PEDIDO,
    }

    private enum AdminState {
        PRODUTOS,
        USUARIOS,
        PEDIDOS,
        CANCELA_PEDIDO,
    }

    private Loja loja;
    private Menu menu;
    private MainState mainState;
    private Usuario usuario;

    private Main() {
        this.loja = new Loja();
        this.menu = new Menu();
        this.mainState = MainState.INICIO;
    }

    public static void main(String[] args) {
        Main app = new Main();

        while (true) {
            app.mainStateMachine();
        }

    }

    private void mainStateMachine() {
        switch (this.mainState) {
            case INICIO -> {
                switch (this.menu.autenticacao()) {
                    case 2 -> {
                        this.mainState = MainState.LOGIN;
                    }
                    case 3 -> {
                        this.mainState = MainState.CADASTRO;
                    }
                    default -> {
                        this.mainState = MainState.SAIR;
                    }
                }
            }
            case LOGIN -> {
                switch (this.loja.procurarCadastro(this.menu.login())) {

                    case Admin admin -> {
                        usuario = admin;
                        this.adminStateMachine((Admin) usuario);
                    }
                    case Fornecedor fornecedor -> {
                        usuario = fornecedor;
                        this.fornecedorStateMachine((Fornecedor) usuario);
                    }
                    case Cliente cliente -> {
                        usuario = cliente;
                        this.clienteStateMachine((Cliente) usuario);
                    }
                    default -> {
                        switch (this.menu.retry("Usuário não encontrado")) {
                            case 2 -> {
                                this.mainState = MainState.LOGIN;
                            }
                            default -> {
                                this.mainState = MainState.INICIO;
                            }

                        }
                    }
                }

            }
            case CADASTRO -> {
                switch (this.menu.selecaoTipoUsuario()) {
                    case 2 -> {
                        usuario = new Admin(this.menu.cadastro(new Admin()));
                    }
                    case 3 -> {
                        usuario = new Cliente(this.menu.cadastro(new Cliente()));
                    }
                    case 4 -> {
                        usuario = new Fornecedor(this.menu.cadastro(new Fornecedor()));
                    }
                    default -> {
                        this.mainState = MainState.INICIO;
                    }
                }
                if (mainState != MainState.INICIO) {
                    this.loja.addUsuario(usuario);
                }
                this.mainState = MainState.INICIO;
            }

            case SAIR -> {
                System.exit(0);
            }
        }
    }

    private void clienteStateMachine(Cliente cliente) {
        switch (this.menu.dashboard(usuario)) {

        }
    }

    private void fornecedorStateMachine(Fornecedor fornecedor) {
        switch (this.menu.dashboard(usuario)) {

        }
    }

    private void adminStateMachine(Admin admin) {
        switch (this.menu.dashboard(usuario)) {

        }
    }
}
