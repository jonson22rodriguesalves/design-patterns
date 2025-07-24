package service;

import user.Cliente;
import user.GerenciadorClientes;

/**
 * Classe Facade para integração simplificada dos subsistemas de marketing e mensageria.
 * Implementa o padrão Facade para fornecer uma interface unificada e simplificada para o sistema complexo.
 * <p>
 * Atributos:
 * - mensageria (MarketingMensageria): Subsistema de envio de mensagens
 * - gerenciadorClientes (GerenciadorClientes): Subsistema de gerenciamento de clientes (Singleton)
 * <p>
 * Métodos Públicos:
 * - enviarMensagemParaTodos(): Envia mensagem para todos os clientes cadastrados
 * - enviarMensagemParaCliente(): Envia mensagem para um cliente específico
 * - processarResposta(): Processa respostas recebidas dos clientes
 */
public class SistemaMarketingFacade {
    private MarketingMensageria mensageria;
    private GerenciadorClientes gerenciadorClientes;

    /**
     * Construtor padrão que inicializa os subsistemas:
     * - Cria nova instância de MarketingMensageria
     * - Obtém instância única do GerenciadorClientes (Singleton)
     */
    public SistemaMarketingFacade() {
        this.mensageria = new MarketingMensageria();
        this.gerenciadorClientes = GerenciadorClientes.getInstancia();
    }

    /**
     * Envia uma mensagem para todos os clientes cadastrados
     *
     * @param mensagem Texto da mensagem a ser enviada
     */
    public void enviarMensagemParaTodos(String mensagem) {
        for (Cliente cliente : gerenciadorClientes.getClientes()) {
            mensageria.setServico(cliente.getServicoPreferido());
            mensageria.enviarMensagem(mensagem, cliente);
        }
    }

    /**
     * Envia mensagem para um cliente específico
     *
     * @param nomeCliente Nome do cliente destinatário
     * @param mensagem    Texto da mensagem a ser enviada
     */
    public void enviarMensagemParaCliente(String nomeCliente, String mensagem) {
        Cliente cliente = gerenciadorClientes.getClientePorNome(nomeCliente);
        if (cliente != null) {
            mensageria.setServico(cliente.getServicoPreferido());
            mensageria.enviarMensagem(mensagem, cliente);
        }
    }

    /**
     * Processa uma resposta recebida de um cliente
     *
     * @param nomeCliente Nome do cliente que enviou a resposta
     * @param resposta    Texto da resposta recebida
     */
    public void processarResposta(String nomeCliente, String resposta) {
        Cliente cliente = gerenciadorClientes.getClientePorNome(nomeCliente);
        if (cliente != null) {
            cliente.responderMensagem(resposta);
        }
    }
}