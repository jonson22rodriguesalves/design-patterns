package service;

import user.Cliente;

/**
 * Interface que define o contrato para serviços de envio de mensagens, seguindo o padrão Strategy.
 * Permite a implementação de diferentes estratégias de comunicação com os clientes.
 * <p>
 * Atributos:
 * - Interfaces não possuem atributos, apenas definem contratos
 * <p>
 * Métodos:
 * - enviarMensagem(): Define como mensagens são enviadas aos clientes
 * - receberResposta(): Define como respostas dos clientes são processadas
 */
public interface ServicoMensagem {
    /**
     * Envia uma mensagem para o cliente especificado
     *
     * @param mensagem O conteúdo da mensagem a ser enviada
     * @param cliente  O cliente destinatário da mensagem
     */
    void enviarMensagem(String mensagem, Cliente cliente);

    /**
     * Processa uma resposta recebida de um cliente
     *
     * @param resposta O conteúdo da resposta recebida
     * @param cliente  O cliente que enviou a resposta
     */
    void receberResposta(String resposta, Cliente cliente);
}