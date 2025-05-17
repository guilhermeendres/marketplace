package marketplace;

public class Menu {

    // private enum State {
    //     INICIO,
    //     CADASTRO,
    //     LOGIN,
    //     NULO,
    // }
    private enum NivelAcesso {
        ADMIN,
        USUARIO,
    }

    // private State estadoAnterior;
    // private State estadoAtual;
    // private State estadoProximo;
    private Tela tela;

    public Menu() {
        // estadoAnterior = State.NULO;
        // estadoAtual = State.NULO;
        // estadoProximo = State.INICIO;
        tela = new Tela();
    }

    public void run() {
        // if (estadoAtual != estadoProximo) {
        //     estadoAnterior = estadoAtual;
        //     estadoAtual = estadoProximo;
        // }

        switch (inicio()) {
            case 1 -> {

            }
            case 2 -> {

            }
            case 3 -> {

            }
            default -> {
                System.out.println("Erro"); // adicionar tratamento de exceções se sobrar tempo
                exit();
            }
        }
    }

    private int inicio() {

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

    private void exit() {
        System.out.println("Saindo...");
        System.exit(0);
    }

}
