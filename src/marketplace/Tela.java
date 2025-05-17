package marketplace;

import java.util.Scanner;

public class Tela {

    private static final Scanner scanner = new Scanner(System.in);

    public String[] requisitarTexto(String titulo, String descricao, String mensagens[]) {

        if (titulo != null && !titulo.isBlank()) {
            System.out.println(titulo);
        }

        if (descricao != null && !descricao.isBlank()) {
            System.out.println(descricao);
        }

        if (mensagens != null && mensagens.length > 0) {

            String[] entradas = new String[mensagens.length];

            for (int i = 0; i < mensagens.length; i++) {
                System.out.print(mensagens[i]);
                entradas[i] = scanner.nextLine();
            }
            return entradas;
        }
        return new String[0];
    }

    public String[] requisitarTexto(String titulo, String mensagens[]) {

        if (titulo != null && !titulo.isBlank()) {
            System.out.println(titulo);
        }

        if (mensagens != null && mensagens.length > 0) {

            String[] entradas = new String[mensagens.length];

            for (int i = 0; i < mensagens.length; i++) {
                System.out.print(mensagens[i]);
                entradas[i] = scanner.nextLine();
            }
            return entradas;
        }
        return new String[0];
    }

    public String[] requisitarTexto(String mensagens[]) {

        if (mensagens != null && mensagens.length > 0) {

            String[] entradas = new String[mensagens.length];

            for (int i = 0; i < mensagens.length; i++) {
                System.out.print(mensagens[i]);
                entradas[i] = scanner.nextLine();
            }
            return entradas;
        }
        return new String[0];
    }

    public String requisitarOpcao(String titulo, String descricao, String opcoes[]) {

        if (titulo != null && !titulo.isBlank()) {
            System.out.println(titulo);
        }

        if (descricao != null && !descricao.isBlank()) {
            System.out.println(descricao);
        }

        if (opcoes != null && opcoes.length > 0) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < opcoes.length; i++) {
                sb.append(i + 1).append(" - ").append(opcoes[i]).append("\n");
            }

            System.out.print(sb.toString());

            String opcao = scanner.nextLine().trim();

            return opcao;
        }
        return "0";
    }

    public String requisitarOpcao(String titulo, String opcoes[]) {

        if (titulo != null && !titulo.isBlank()) {
            System.out.println(titulo);
        }

        if (opcoes != null && opcoes.length > 0) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < opcoes.length; i++) {
                sb.append(i + 1).append(" - ").append(opcoes[i]).append("\n");
            }

            System.out.print(sb.toString());

            String opcao = scanner.nextLine().trim();

            return opcao;
        }
        return "0";
    }

    public String requisitarOpcao(String opcoes[]) {

        if (opcoes != null && opcoes.length > 0) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < opcoes.length; i++) {
                sb.append(i + 1).append(" - ").append(opcoes[i]).append("\n");
            }

            System.out.print(sb.toString());

            String opcao = scanner.nextLine().trim();

            return opcao;
        }
        return "0";
    }

    public void mostrarMensagem(String mensagem) {

        if (mensagem != null && !mensagem.isBlank()) {
            System.out.println(mensagem);
        }
    }
}
