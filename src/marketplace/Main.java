package marketplace;

import marketplace.Menu.TipoUsuario;

public class Main {

    private enum State {
        INICIO,
        LOGIN,
        CADASTRO,
        AÇÃO,
        SAIR
    }
    private Loja loja;
    private Menu menu;
    private State state;
    private Usuario usuario;

    private Main() {
        this.loja = new Loja();
        this.menu = new Menu();
        this.state = State.INICIO;
    }

    public static void main(String[] args) {
        Main app = new Main();

        while (true) {
            app.stateMachine(app);
        }

    }

    private void stateMachine(Main app) {
        switch (app.state) {
            case INICIO -> {
                switch (app.menu.autenticacao()) {
                    case 2 -> {
                        app.state = State.LOGIN;
                    }
                    case 3 -> {
                        app.state = State.CADASTRO;
                    }
                    default -> {
                        app.state = State.SAIR;
                    }
                }
            }
            case LOGIN -> {
                switch (app.loja.procurarCadastro(app.menu.login())) {

                    case Admin admin -> {
                        usuario = admin;
                        app.state = State.AÇÃO;
                    }
                    case Fornecedor fornecedor -> {
                        usuario = fornecedor;
                        app.state = State.AÇÃO;
                    }
                    case Cliente cliente -> {
                        usuario = cliente;
                        app.state = State.AÇÃO;
                    }
                    default -> {
                        app.state = State.INICIO;
                    }
                }

            }
            case CADASTRO -> {
                switch (app.menu.selecaoTipoUsuario()) {
                    case 2 -> {
                        usuario = new Admin();
                    }
                    case 3 -> {
                        usuario = new Cliente();
                    }
                    case 4 -> {
                        usuario = new Fornecedor();
                    }
                    default -> {
                        app.state = State.INICIO;
                    }
                }
                app.loja.addUsuario(usuario);
            }

            case AÇÃO -> {

                switch (app.menu.dashboard()) {
                    case 1 -> {
                    }
                }
            }
            case SAIR -> {
                System.exit(0);
            }
        }

        // switch (app.menu.inicio()) {
        //     case 1 -> { System.exit(0); } // Sair
        //     case 2 -> { String login[] = app.menu.login(); }
        //     case 3 -> {
        //         switch(app.menu.autenticacao()) {
        //             case 1 -> { System.exit(0); } // Sair
        //             case 2 -> { String login[] = app.menu.login(); }
        //             case 3 -> {
        //                 switch(app.menu.selecaoTipoCadastro()) {
        //                     case 1 -> { System.exit(0); } // Sair
        //                     case 2 -> { 
        //                         app.loja.addFornecedor(new Fornecedor(app.menu.cadastro(TipoUsuario.FORNECEDOR))); 
        //                     }
        //                     case 3 -> { 
        //                         app.loja.addCliente(new Cliente(app.menu.cadastro(TipoUsuario.CLIENTE)));
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
    }
}
