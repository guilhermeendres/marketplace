package marketplace;

import java.util.Scanner;

public class TelaRequisicao extends Tela {

    private String requisicoes[];
    private String respostas[];

    public TelaRequisicao(String titulo, String requisicao[]) {
        super(titulo);
        this.requisicoes = requisicao;
        this.respostas = new String[requisicao.length];
    }

    @Override
    public void exibir() {
        scanner = new Scanner(System.in);
        super.exibir();

        if (requisicoes == null || requisicoes.length == 0) {
            System.out.println("Nenhuma requisição disponível.");
            return;
        }

        if (respostas == null || respostas.length == 0) {
            respostas = new String[requisicoes.length];
        }

        for (int i = 0; i < respostas.length; i++) {
            System.out.println(requisicoes[i]);
            do {
                String resposta = scanner.nextLine().toLowerCase().trim();
                if (validarEntrada(resposta)) {
                    this.respostas[i] = resposta;
                } else {
                    System.out.println("Resposta inválida. Tente novamente.");
                }
            } while (!validarEntrada(respostas[i]));
        }
        scanner.close();
    }

    public String[] getRequisicoes() {
        return requisicoes;
    }

    public void setRequisicoes(String[] requisicoes) {
        if (requisicoes != null && requisicoes.length > 0) {
            this.requisicoes = requisicoes;
        }
    }

    public String[] getRespostas() {
        return respostas;
    }

    private boolean validarEntrada(String entrada) {
        return entrada != null && !entrada.trim().isEmpty();
    }

}
