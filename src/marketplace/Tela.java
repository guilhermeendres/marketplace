package marketplace;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                do {
                    entradas[i] = scanner.nextLine();
                    if (entradas[i].isBlank()) {
                        System.out.print("Entrada inválida. Tente novamente: ");
                    }
                } while (entradas[i].isBlank());
            }
            return entradas;
        }
        return new String[0];
    }

    public int requisitarOpcao(String titulo, String descricao, String opcoes[]) {

        if (titulo != null && !titulo.isBlank()) {
            System.out.println(titulo);
        }

        if (descricao != null && !descricao.isBlank()) {
            System.out.println(descricao);
        }

        if (opcoes != null && opcoes.length > 0) {

            int opcaoSelecionada = 0;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < opcoes.length; i++) {
                sb.append(i + 1).append(" - ").append(opcoes[i]).append("\n");
            }

            System.out.print(sb.toString());

            do {
                opcaoSelecionada = receberOpcao(scanner.nextLine().trim());
                if (opcaoSelecionada <= 0 || opcaoSelecionada > opcoes.length) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcaoSelecionada <= 0 || opcaoSelecionada > opcoes.length);

            return opcaoSelecionada;
        }
        return 0;
    }

    public int requisitarOpcao(String titulo, String opcoes[]) {

        if (titulo != null && !titulo.isBlank()) {
            System.out.println(titulo);
        }

        if (opcoes != null && opcoes.length > 0) {

            int opcaoSelecionada = 0;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < opcoes.length; i++) {
                sb.append(i + 1).append(" - ").append(opcoes[i]).append("\n");
            }

            System.out.print(sb.toString());

            do {
                opcaoSelecionada = receberOpcao(scanner.nextLine().trim());
                if (opcaoSelecionada <= 0 || opcaoSelecionada > opcoes.length) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcaoSelecionada <= 0 || opcaoSelecionada > opcoes.length);

            return opcaoSelecionada;
        }
        return 0;
    }

    public int requisitarOpcao(String opcoes[]) {

        if (opcoes != null && opcoes.length > 0) {

            int opcaoSelecionada = 0;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < opcoes.length; i++) {
                sb.append(i + 1).append(" - ").append(opcoes[i]).append("\n");
            }

            System.out.print(sb.toString());

            do {
                opcaoSelecionada = receberOpcao(scanner.nextLine().trim());
                if (opcaoSelecionada <= 0 || opcaoSelecionada > opcoes.length) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcaoSelecionada <= 0 || opcaoSelecionada > opcoes.length);

            return opcaoSelecionada;
        }
        return 0;
    }

    public void mostrarMensagem(String mensagem) {

        if (mensagem != null && !mensagem.isBlank()) {
            System.out.println(mensagem);
        }
    }

    /**
     * Método para receber um número inteiro de uma string
     *
     * @param entrada
     * @return o número inteiro encontrado na string ou 0 se não houver
     */
    private int receberOpcao(String entrada) {
        /**
         * Cria um padrão regex para encontrar números inteiros na entrada
         *
         * Deve tratar: - Entradas sem números - Entradas com números misturados
         * com letras - Entradas com espaços em branco - Entradas vazias ou
         * nulas
         */
        Pattern pattern = Pattern.compile("\\d+"); // \\d+ encontra um ou mais dígitos consecutivos
        Matcher matcher = pattern.matcher(entrada); // faz a busca usando o padrão definido
        if (entrada != null && !entrada.trim().isEmpty()) {
            if (matcher.find()) {
                return Integer.parseInt(matcher.group());
            }
        }
        return 0;
    }
}
