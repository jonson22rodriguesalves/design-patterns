package user;

import java.util.List;
import java.util.Scanner;

import service.SistemaMarketingFacade;  // Adicione esta linha
import service.*;


/**
 * Classe responsável por gerenciar a interface de menu do sistema de marketing.
 * Separa a lógica de exibição e interação do menu da lógica de negócios principal.
 */
public class Menu {
    private Scanner scanner;
    private SistemaMarketingFacade facade;
    private GerenciadorClientes gerenciador;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.facade = new SistemaMarketingFacade();
        this.gerenciador = GerenciadorClientes.getInstancia();
        inicializarClientesDemo();
    }

    /**
     * Exibe o menu principal e gerencia as opções selecionadas
     */
    public void exibirMenuPrincipal() {
        int opcao;
        do {
            exibirOpcoesMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    enviarMensagemTodos();
                    break;
                case 2:
                    enviarMensagemClienteEspecifico();
                    break;
                case 3:
                    processarRespostaCliente();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    cadastrarNovoCliente();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void exibirOpcoesMenu() {
        System.out.println("\n=== Sistema Integrado de Marketing ===");
        System.out.println("1. Enviar mensagem para todos os clientes");
        System.out.println("2. Enviar mensagem para cliente específico");
        System.out.println("3. Processar resposta de cliente");
        System.out.println("4. Listar Clientes");
        System.out.println("5. Adicionar Cliente");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int lerOpcao() {
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        return opcao;
    }

    private void enviarMensagemTodos() {
        System.out.print("Digite a mensagem de marketing: ");
        String mensagem = scanner.nextLine();
        facade.enviarMensagemParaTodos(mensagem);
    }

    private void enviarMensagemClienteEspecifico() {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite a mensagem: ");
        String mensagem = scanner.nextLine();

        Cliente cliente = gerenciador.getClientePorNome(nomeCliente);
        if (cliente != null) {
            facade.enviarMensagemParaCliente(nomeCliente, mensagem);
        } else {
            System.out.println("❌ Cliente não cadastrado!");
        }
    }

    private void processarRespostaCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite a resposta: ");
        String resposta = scanner.nextLine();

        Cliente cliente = gerenciador.getClientePorNome(nomeCliente);
        if (cliente != null) {
            facade.processarResposta(nomeCliente, resposta);
        } else {
            System.out.println("❌ Cliente não cadastrado!");
        }
    }

    private void listarClientes() {
        List<Cliente> clientes = gerenciador.getClientes();

        if (clientes.isEmpty()) {
            System.out.println("\n ❌ Nenhum cliente cadastrado!");
        } else {
            System.out.println("\n=== Lista de Clientes Cadastrados ===");
            for (Cliente cliente : clientes) {
                exibirDetalhesCliente(cliente);
            }
        }
    }

    private void exibirDetalhesCliente(Cliente cliente) {
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Rede Social: " + cliente.getFacebook());
        System.out.println("Serviço Preferido: " +
                cliente.getServicoPreferido().getClass().getSimpleName());
        System.out.println("------------------------");
    }

    private void cadastrarNovoCliente() {
        String nome = validarEntrada("[a-zA-Zá-úÁ-Ú\\s]+",
                "Digite o nome do cliente (apenas letras): ",
                "❌ Nome inválido! Use apenas letras e espaços.");

        String email = validarEntrada("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$",
                "Digite o email (ex: usuario@dominio.com): ",
                "❌ Email inválido! Use o formato usuario@dominio.com");

        String telefone = validarTelefone();
        if (telefone == null) {
            System.out.println("Operação cancelada. Voltando ao menu...");
            return;
        }

        System.out.print("Digite o nome da rede social: ");
        String redeSocial = scanner.nextLine();

        ServicoMensagem servico = selecionarServicoMensagem();

        gerenciador.adicionarCliente(new Cliente(nome, email, telefone, redeSocial, servico));
        System.out.println("✅ Cliente cadastrado com sucesso!");
    }

    private String validarTelefone() {
        String telefone;
        boolean telefoneValido;
        boolean desejaContinuar = true;

        do {
            telefone = validarEntrada("\\d{11}|cancelar",
                    "Digite o telefone (11 dígitos, ex: 11988776655) ou 'cancelar' para voltar: ",
                    "❌ Formato inválido! Use 11 dígitos numéricos ou digite 'cancelar'.");

            // Verifica se o usuário deseja cancelar
            if (telefone.equalsIgnoreCase("cancelar")) {
                return null;
            }

            telefoneValido = !telefoneJaCadastrado(telefone);

            if (!telefoneValido) {
                System.out.println("❌ Cliente já cadastrado!");
                System.out.print("Deseja tentar outro número? (s/n): ");
                String resposta = scanner.nextLine();
                desejaContinuar = resposta.equalsIgnoreCase("s");
            }
        } while (!telefoneValido && desejaContinuar);

        return desejaContinuar ? telefone : null;
    }

    private boolean telefoneJaCadastrado(String telefone) {
        return gerenciador.getClientes().stream()
                .anyMatch(c -> c.getTelefone().equals(telefone));
    }

    private String validarEntrada(String regex, String mensagem, String erro) {
        String entrada;
        do {
            System.out.print(mensagem);
            entrada = scanner.nextLine().trim();
            if (!entrada.matches(regex)) {
                System.out.println(erro);
            }
        } while (!entrada.matches(regex));
        return entrada;
    }

    private ServicoMensagem selecionarServicoMensagem() {
        System.out.println("Escolha o serviço de mensagem:");
        System.out.println("1 - WhatsApp");
        System.out.println("2 - Email");
        System.out.println("3 - SMS");
        System.out.println("4 - Redes Sociais");
        System.out.print("Digite o número do serviço: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                return new ServicoWhatsApp();
            case 2:
                return new ServicoEmail();
            case 3:
                return new ServicoSMS();
            case 4:
                return new ServicoRedesSociais();
            default:
                System.out.println("❌ Opção inválida! Usando WhatsApp como padrão.");
                return new ServicoWhatsApp();
        }
    }

    private void inicializarClientesDemo() {
        gerenciador.adicionarCliente(new Cliente("Admin", "admin@appleledsoftware.com",
                "11999999999", "youtube", new ServicoWhatsApp()));
        gerenciador.adicionarCliente(new Cliente("Analista", "analista@appleledsoftware.com",
                "11988888888", "facebook", new ServicoEmail()));
    }
}