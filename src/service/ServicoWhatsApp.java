package service;

import user.Cliente;

/**
 * Implementação concreta do serviço de mensageria via WhatsApp.
 * Segue o padrão Strategy implementando a interface ServicoMensagem.
 * <p>
 * Atributos:
 * - Não possui atributos próprios, utilizando apenas os dados do cliente
 * - Utiliza o número de telefone do cliente para comunicação
 * <p>
 * Métodos:
 * - enviarMensagem(): Implementa o envio de mensagens via WhatsApp
 * - receberResposta(): Implementa o recebimento de respostas via WhatsApp
 */
public class ServicoWhatsApp implements ServicoMensagem {
    /**
     * Envia uma mensagem para o cliente via WhatsApp
     *
     * @param mensagem Conteúdo textual da mensagem (suporta emojis e formatação)
     * @param cliente  Objeto Cliente contendo os dados de contato
     */
    @Override
    public void enviarMensagem(String mensagem, Cliente cliente) {
        System.out.println("Enviando WhatsApp para " + cliente.getNome() + ": " +
                cliente.getTelefone() + ": Mensagem " + mensagem);
    }

    /**
     * Processa uma resposta recebida via WhatsApp
     *
     * @param resposta Conteúdo textual da resposta
     * @param cliente  Objeto Cliente que enviou a resposta
     */
    @Override
    public void receberResposta(String resposta, Cliente cliente) {
        System.out.println("Resposta por WhatsApp de " + cliente.getNome() + ": " +
                cliente.getTelefone() + ": Mensagem " + resposta);
    }
}