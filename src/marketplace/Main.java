package marketplace;

public class Main {
    private Loja loja;
    private Menu menu;

    public Main() {
        this.loja = new Loja();
        this.menu = new Menu();
    }

    public static void main(String[] args) {
        Main app = new Main();
        switch (app.menu.inicio()) {
            case 1 -> { System.exit(0); } // Sair
            case 2 -> { String login[] = app.menu.login(); }
            case 3 -> {
                switch(app.menu.autenticacao()) {
                    case 1 -> { System.exit(0); } // Sair
                    case 2 -> { String login[] = app.menu.login(); }
                    case 3 -> {
                        String infoCadastro[];
                        switch(app.menu.selecaoTipoCadastro()) {
                            case 1 -> { System.exit(0); } // Sair
                            case 2 -> { infoCadastro = app.menu.cadastro(new Fornecedor()); }
                            case 3 -> { infoCadastro = app.menu.cadastro(new Cliente()); }
                        }
                    }
                }
            }
        }
        
    }
}
