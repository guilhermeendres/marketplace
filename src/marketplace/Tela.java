package marketplace;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tela {

    private String titulo;
    protected Scanner scanner;

    public Tela(String titulo) {
        this.titulo = titulo;
    }

    public void exibir() {
        System.out.println("\n\n" + titulo + "\n");
    }

    public boolean setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            return false;
        }
        this.titulo = titulo;
        return true;
    }

    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Método para receber um número inteiro de uma string
     *
     * @param entrada
     * @return o número inteiro encontrado na string ou 0 se não houver
     */
    protected int receberInteiro(String entrada) {
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
