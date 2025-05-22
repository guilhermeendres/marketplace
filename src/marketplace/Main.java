package marketplace;

public class Main {

    private enum MainState {
        INICIO,
        LOGIN,
        CADASTRO,
        ADMIN,
        USUARIO,
        FORNECEDOR,
        CLIENTE,
        SAIR,
        VOLTAR
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
        INICIO,
        GERENCIAR,
    }

    private Loja loja;
    private Menu menu;
    private MainState mainState;
    private AdminState admState;
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
                switch(this.menu.autenticacao()) {
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
                switch (this.loja.procurar(this.menu.login())) {

                    case Admin admin -> {
                        usuario = admin;
                        this.mainState = mainState.ADMIN;
                    }
                    case Fornecedor fornecedor -> {
                        usuario = fornecedor;
                        this.mainState = mainState.FORNECEDOR;
                    }
                    case Cliente cliente -> {
                        usuario = cliente;
                        this.mainState = mainState.CLIENTE;
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
                        usuario = new Admin(this.menu.cadastro(new Admin()), loja);
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

            case ADMIN -> {
                this.admState = admState.INICIO;

                while (mainState != MainState.LOGIN) {
                    switch (admState) {
                        case INICIO -> {
                        	Usuario alvo = new Usuario();
                            switch (this.menu.dashboard(usuario)) {
                                case 2 -> { //Gerenciar Fornecedores
                                    alvo = new Fornecedor();
                                    switch (this.menu.gerenciamento()) {
                                        case 2 -> { //adicionar
                                            ((Admin) usuario).cadastrar(new Fornecedor(this.menu.cadastro(alvo)));
                                        }
                                        case 3 -> { //editar
                                            alvo.setId(this.menu.pedirId());
                                            ((Admin) usuario).editar(new Fornecedor(this.menu.editar(alvo)));
                                        }
                                        case 4 -> { //remover
                                            alvo.setId(this.menu.pedirId());
                                            ((Admin) usuario).remover(alvo);
                                        }
                                        case 5 -> { //procurar
                                            int tipoBusca = this.menu.pedirTipoBusca();
                                            switch(tipoBusca) {
                                                case 2 -> { //id
                                                    alvo.setId(this.menu.pedirId());
                                                }
                                                case 3 -> { //nome
                                                    String nome[] = this.menu.pedirNome();
                                                    alvo.setNome(nome[0]);
                                                }
                                                default -> {
                                                    return;
                                                }
                                            }
                                            alvo = ((Admin) usuario).procurar(alvo);
                                            System.out.println(alvo.toString());
                                        }
                                        default -> {
                                            return;
                                        }

                                    }
                                }
                                case 3 -> { //Gerenciar Clientes
                                    alvo = new Cliente();
                                    switch (this.menu.gerenciamento()) {
                                        case 2 -> { //adicionar
                                            ((Admin) usuario).cadastrar(new Cliente(this.menu.cadastro(alvo)));
                                        }
                                        case 3 -> { //editar
                                            alvo.setId(this.menu.pedirId());
                                            ((Admin) usuario).editar(new Cliente(this.menu.editar(alvo)));
                                        }
                                        case 4 -> { //remover
                                            alvo.setId(this.menu.pedirId());
                                            ((Admin) usuario).remover(alvo);
                                        }
                                        case 5 -> { //procurar
                                            int tipoBusca = this.menu.pedirTipoBusca();
                                            switch(tipoBusca) {
                                                case 2 -> { //id
                                                    alvo.setId(this.menu.pedirId());
                                                }
                                                case 3 -> { //nome
                                                    String nome[] = this.menu.pedirNome();
                                                    alvo.setNome(nome[0]);
                                                }
                                                default -> {
                                                    return;
                                                }
                                            }
                                            alvo = ((Admin) usuario).procurar(alvo);
                                            System.out.println(alvo.toString());
                                        }
                                        default -> {
                                            return;
                                        }
                                    }
                                }
                                case 4 -> { //Gerenciar Produto
                                    Produto produto = new Produto();
                                    alvo = new Fornecedor();
                                    switch (this.menu.gerenciamento()) {
                                        case 2 -> { //Adicionar
                                            String params[] = this.menu.cadastro(produto);
                                            alvo.setId(Integer.parseInt(params[4]));
                                            alvo = ((Admin) usuario).procurar(alvo);
                                            produto = new Produto(params, (Fornecedor)alvo);
                                            ((Admin) usuario).cadastrar(produto);
                                        }
                                        case 3 -> { //Editar
                                            produto.setId(this.menu.pedirId());
                                            ((Admin) usuario).editar(new Produto(this.menu.editar(produto)));
                                        }
                                        case 4 -> { //Remover
                                            produto.setId(this.menu.pedirId());
                                            ((Admin) usuario).remover(new Produto(this.menu.editar(produto)));
                                        }
                                        case 5 -> {
                                            int tipoBusca = this.menu.pedirTipoBusca();
                                            switch(tipoBusca) {
                                                case 2 -> { //id
                                                    produto.setId(this.menu.pedirId());
                                                }
                                                case 3 -> { //nome
                                                    String nome[] = this.menu.pedirNome();
                                                    produto.setNome(nome[0]);
                                                }
                                                default -> {
                                                    return;
                                                }
                                            }
                                            produto = ((Admin) usuario).procurar(produto);
                                            System.out.println(produto.toString());
                                        }
                                        default -> {
                                            return;
                                        }
                                    }
                                }
                                default -> {
                                    admState = AdminState.INICIO;
                                }
                            }
                            this.admState = AdminState.INICIO;
                        }
                        default -> {
                            return;
                        }

                    }

                }
            }

            case SAIR -> {
                System.exit(0);
            }

            default -> {
                return;
            }
        }
    }
}
