package marketplace;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private List<Cliente> clientes;
    private List<Fornecedor> fornecedores;
    private List<Produto> produtos;
    private int codigoProdutos = 0; // variavel para guardar o codigo de um novo produto
    private static Scanner scanner;

    public static void main(String[] args) {
        Main main = new Main();

        main.init();

        main.exibirMenuInicial();
    }

    private void init() {
        clientes = new ArrayList<>();
        fornecedores = new ArrayList<>();
    }

    private void exibirMenuInicial() {
        TelaOpcoes tela = new TelaOpcoes(
                "Selecione seu nível de acesso:", new String[]{
                    "Admin",
                    "Usuário",
                    "Sair"
                });
        tela.exibir();
        switch (tela.getOpcaoSelecionada()) {
            case 1:
                // exibirMenuAdmin();
                break;
            case 2:
                exibirMenuUsuario();
                break;
            case 3:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void exibirMenuUsuario() {
        TelaOpcoes tela = new TelaOpcoes(
                "Faça login ou crie uma conta:", new String[]{
                    "Criar conta",
                    "Login"
                });
        tela.exibir();
        switch (tela.getOpcaoSelecionada()) {
            case 1:
                criarUsuario();
                break;
            case 2:
                fazerLogin();
                break;
            default:
                exibirMenuInicial();
                break;
        }
    }

    private void criarUsuario() {
        TelaOpcoes tela = new TelaOpcoes(
                "Selecione o tipo de usuário", new String[]{
                    "Cliente",
                    "Fornecedor"
                });
        switch (tela.getOpcaoSelecionada()) {
            case 1:
                criarCliente();
                break;
            case 2:
                criarFornecedor();
                break;
            case 3:
            	criarProduto();
            	break;
            default:
                exibirMenuInicial();
                break;
        }
    }

    private void criarProduto() {
    	codigoProdutos++;
    	TelaRequisicao tela = new TelaRequisicao(
                "Cadastrar produto", new String[]{
                    "Nome: ", // informacoes[0]
                    "Descrição: ", // informacoes[1]
                });
        tela.exibir();
        String[] informacoes = tela.getRequisicoes();
        Produto produto = new Produto(informacoes[0], informacoes[1], codigoProdutos);
        produtos.add(produto);
        exibirMenuUsuario();
	}

	private void criarFornecedor() {
    	TelaRequisicao tela = new TelaRequisicao(
                "Cadastrar fornecedor", new String[]{
                    "Nome: ", // informacoes[0]
                    "Descrição: ", // informacoes[1]
                    "E-mail: ", // informacoes[2]
                    "Telefone: ", // informacoes[3]
                    "Rua: ", // informacoes[4]
                    "Número: ", // informacoes[5]
                    "Complemento: ", // informacoes[6]
                    "Bairro: ", // informacoes[7]     
                    "CEP: ", // informacoes[8]    
                    "Cidade: ", // informacoes[9]
                    "Estado: ", // informacoes[10]
                });
        tela.exibir();
        String[] informacoes = tela.getRequisicoes();
        Endereco endereco = new Endereco(informacoes[4], informacoes[5], informacoes[6], informacoes[7], informacoes[8], informacoes[9], informacoes[10]);
        Fornecedor fornecedor = new Fornecedor(informacoes[0], informacoes[1], informacoes[2], informacoes[3], endereco);
        fornecedores.add(fornecedor);
        exibirMenuUsuario();
	}

	private void fazerLogin() {
        TelaRequisicao tela = new TelaRequisicao(
                "Login", new String[]{
                    "Email: ", // informacoes[0]
                    "Senha: " // informacoes[1]
                });
        tela.exibir();
        String[] informacoes = tela.getRequisicoes();
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(informacoes[0]) && cliente.getSenha().equals(informacoes[1])) {
                System.out.println("Login realizado com sucesso!");
                return;
            }
        }
        System.out.println("Email ou senha inválidos.");
    }

    private void criarCliente() {
        TelaRequisicao tela = new TelaRequisicao(
                "Criar conta de cliente", new String[]{
                    "Nome: ", // informacoes[0]
                    "Telefone: ", // informacoes[1]
                    "Email: ", // informacoes[2]
                    "Senha: ", // informacoes[3]
                    "Rua: ", // informacoes[4]
                    "Número: ", // informacoes[5]
                    "Complemento: ", // informacoes[6]
                    "Bairro: ", // informacoes[7]     
                    "CEP: ", // informacoes[8]    
                    "Cidade: ", // informacoes[9]
                    "Estado: ", // informacoes[10]
                    "Cartão de crédito: " // informacoes[11]
                });
        tela.exibir();
        String[] informacoes = tela.getRequisicoes();
        Endereco endereco = new Endereco(informacoes[4], informacoes[5], informacoes[6], informacoes[7], informacoes[8], informacoes[9], informacoes[10]);
        Usuario usuario = new Usuario(informacoes[0], informacoes[1], informacoes[2], informacoes[3], endereco);
        Cliente cliente = new Cliente(usuario, informacoes[11]);
        clientes.add(cliente);
        exibirMenuUsuario();
    }
}
