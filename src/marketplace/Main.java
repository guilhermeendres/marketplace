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
            case 0 -> { System.exit(0);} // Sair
            case 1 -> { 
                String login[] = app.menu.login();
            }
        }
        
    }
}
