package marketplace;

import java.util.Scanner;

public class Main {

    private enum MainState {
        INICIO,
        LOGIN,
        CADASTRO,
        SAIR
    }

    private enum ClienteState {
        BUSCA,
        PEDIDOS,
        COMPRA,
        CANCELA_COMPRA,
    }

    private enum FornecedorState {
        ADICIONAR,
        PEDIDOS,
        CANCELA_PEDIDO,
    }

    private enum AdminState {
        PRODUTOS,
        USUARIOS,
        PEDIDOS,
        CANCELA_PEDIDO,
    }

    private Loja loja;
    private Menu menu;
    private MainState mainState;
    private Usuario usuario;

    private Main() {
        this.loja = new Loja();
        this.menu = new Menu();
        this.mainState = MainState.INICIO;
    }

    public static void main(String[] args) {
        Main app = new Main();

        while (true) {
            app.mainStateMachine();
        }

    }

    private void mainStateMachine() {
        switch (this.mainState) {
            case INICIO -> {
                switch (this.menu.autenticacao()) {
                    case 2 -> {
                        this.mainState = MainState.LOGIN;
                    }
                    case 3 -> {
                        this.mainState = MainState.CADASTRO;
                    }
                    default -> {
                        this.mainState = MainState.SAIR;
                    }
                }
            }
            case LOGIN -> {
                switch (this.loja.procurarCadastro(this.menu.login())) {

                    case Admin admin -> {
                        usuario = admin;
                        this.adminStateMachine((Admin) usuario);
                    }
                    case Cliente cliente -> {
                        usuario = cliente;
                        this.clienteStateMachine((Cliente) usuario);
                    }
                    default -> {
                        switch (this.menu.retry("Usuário não encontrado")) {
                            case 2 -> {
                                this.mainState = MainState.LOGIN;
                            }
                            default -> {
                                this.mainState = MainState.INICIO;
                            }

                        }
                    }
                }

            }
            case CADASTRO -> {
                switch (this.menu.selecaoTipoUsuario()) {
                    case 2 -> {
                        usuario = new Admin(this.menu.cadastro(new Admin()));
                    }
                    case 3 -> {
                        usuario = new Cliente(this.menu.cadastro(new Cliente()));
                    }
                    default -> {
                        this.mainState = MainState.INICIO;
                    }
                }
                if (mainState != MainState.INICIO) {
                    this.loja.addUsuario(usuario);
                }
                this.mainState = MainState.INICIO;
            }

            case SAIR -> {
                System.exit(0);
            }
        }
    }

    private void clienteStateMachine(Cliente cliente) {
        switch (this.menu.dashboard(usuario)) {

        }
    }

    private void adminStateMachine(Admin admin) {
        switch (this.menu.dashboard(admin)) {
        	case 2:
        		switch(menu.telaFornecedores()) {
        			case 2:
        				cadastrarFornecedor();
        				break;
        			case 3:
        				alterarFornecedor();
        				break;
        			case 4:
        				removerFornecedor();
        				break;
        			case 5:
        				listarFornecedores();
        				break;
        			case 6:
        				Scanner sc = new Scanner(System.in);
        				switch(menu.telaBuscaFronecedor()) {
        					case 2:
        						System.out.println("\nDigite o nome do fornecedor: ");
        						String nome = sc.nextLine();
        						Fornecedor f1 = buscarForPorNome(nome);
        						if (f1 != null) {
        							f1.toString();
        				        } else {
        				            System.out.println("Fornecedor não encontrado!");
        				        }
        						break;
        					case 3:
        						System.out.println("\nDigite o cnpj do fornecedor: ");
        						String cnpj = sc.nextLine();
        						Fornecedor f2 = buscarForPorCNPJ(cnpj);
        						if (f2 != null) {
        							f2.toString();
        				        } else {
        				            System.out.println("Fornecedor não encontrado!");
        				        }
        						break;
        				}
        				sc.close();
        				break;
        		}
        }
    }
    
    public Fornecedor buscarForPorNome(String nome) {
        for (Fornecedor f : loja.getFornecedores()) {
            if (f.getNome().equalsIgnoreCase(nome)) {
            	return f;
            }
        }
        return null;
    }
    
    public Fornecedor buscarForPorCNPJ(String cnpj) {
        for (Fornecedor f : loja.getFornecedores()) {
            if (f.getCnpj().equalsIgnoreCase(cnpj)) {
            	return f;
            }
        }
        return null;
    }
    
    public void cadastrarFornecedor() {
    	Fornecedor f = new Fornecedor(menu.cadastroFornecedor());
    	loja.getFornecedores().add(f);
    	System.out.println("Fornecedor cadastrado com sucesso!");
    }
    
    public void alterarFornecedor() {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("\n---- Alteração de Fornecedor ----");
    	System.out.println("\nDigite o cnpj do fornecedor: ");

		String resposta = sc.nextLine();
		
		Fornecedor f = buscarForPorCNPJ(resposta);
		
		if (f != null) {
			
			f.toString();
			
            System.out.print("Novo nome: ");
            f.setNome(sc.nextLine());
            System.out.print("Nova descrição: ");
            f.setDesc(sc.nextLine());
            System.out.print("Novo e-mail: ");
            f.setEmail(sc.nextLine());
            System.out.print("Novo telefone: ");
            f.setTelefone(sc.nextLine());
            
            System.out.print("Nova rua: ");
            f.getEndereco().setRua(sc.nextLine());
            System.out.print("Novo número: ");
            f.getEndereco().setNumero(sc.nextLine());
            System.out.print("Novo Complemento: ");
            f.getEndereco().setComplemento(sc.nextLine());
            System.out.print("Novo bairro: ");
            f.getEndereco().setBairro(sc.nextLine());
            System.out.print("Novo cep: ");
            f.getEndereco().setCep(sc.nextLine());
            System.out.print("Nova cidade: ");
            f.getEndereco().setCidade(sc.nextLine());
            System.out.print("Novo estado: ");
            f.getEndereco().setEstado(sc.nextLine());
            
            System.out.println("Fornecedor alterado com sucesso!");
        } else {
            System.out.println("Fornecedor não encontrado!");
        }
    	
    	sc.close();
    }
    
    public void removerFornecedor() {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("\n---- Remoção de Fornecedor ----");
    	System.out.println("\nDigite o cnpj do fornecedor: ");

		String resposta = sc.nextLine();
		
		Fornecedor f = buscarForPorCNPJ(resposta);
		
		if (f != null) {
			
			loja.getFornecedores().remove(f);
            
            System.out.println("Fornecedor alterado com sucesso!");
        } else {
            System.out.println("Fornecedor não encontrado!");
        }
    	
    	sc.close();
    }
    
    public void listarFornecedores() {
    	for (Fornecedor f : loja.getFornecedores()) {
            System.out.println("\n");
            f.toString();
        }
    }
}
