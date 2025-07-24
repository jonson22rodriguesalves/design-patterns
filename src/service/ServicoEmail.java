package service;

import user.Cliente;

/**
 * Implementação concreta do serviço de mensageria via e-mail.
 * Segue o padrão Strategy implementando a interface ServicoMensagem.
 * <p>
 * Atributos:
 * - Não possui atributos próprios, utilizando apenas os dados do cliente
 * <p>
 * Métodos:
 * - enviarMensagem(): Implementa o envio de mensagens por e-mail
 * - receberResposta(): Implementa o recebimento de respostas por e-mail
 */
public class ServicoEmail implements ServicoMensagem {
    /**
     * Envia uma mensagem para o cliente via e-mail
     *
     * @param mensagem Conteúdo textual da mensagem a ser enviada
     * @param cliente  Objeto Cliente contendo os dados do destinatário
     */
    @Override
    public void enviarMensagem(String mensagem, Cliente cliente) {
        System.out.println("Enviando e-mail para " + cliente.getNome() + ": " +
                cliente.getEmail() + ": Mensagem " + mensagem);
    }

    /**
     * Processa uma resposta recebida do cliente via e-mail
     *
     * @param resposta Conteúdo textual da resposta recebida
     * @param cliente  Objeto Cliente que enviou a resposta
     */
    @Override
    public void receberResposta(String resposta, Cliente cliente) {
        System.out.println("Resposta por e-mail de " + cliente.getNome() + ": " +
                cliente.getEmail() + ": Mensagem " + resposta);
    }
}