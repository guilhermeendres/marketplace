package marketplace;

import java.util.Scanner;

public class TelaOpcoes extends Tela {

    private String[] opcoes;
    private int opcaoSelecionada;

    public TelaOpcoes(String titulo, String[] opcoes) {
        super(titulo);
        this.opcoes = opcoes;
        this.opcaoSelecionada = 0;
    }

    @Override
    public void exibir() {
        scanner = new Scanner(System.in);
        super.exibir();
        System.out.println("Opções:");
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i + 1) + ". " + opcoes[i]);
        }
        System.out.print("Escolha uma opção: ");
        do {
            int opcao = receberInteiro(scanner.nextLine().toLowerCase().trim());
            if (validarOpcao(opcao)) {
                this.opcaoSelecionada = opcao;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!validarOpcao(opcaoSelecionada));
        scanner.close();
        System.out.println("Você selecionou: " + opcoes[opcaoSelecionada - 1]);
    }

    public String[] getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }

    public int getOpcaoSelecionada() {
        return opcaoSelecionada;
    }

    private boolean validarOpcao(int opcao) {
        return opcao > 0 && opcao <= opcoes.length;
    }

}
