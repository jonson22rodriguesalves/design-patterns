package service;

import user.Cliente;

/**
 * Implementação concreta do serviço de mensageria via SMS.
 * Segue o padrão Strategy implementando a interface ServicoMensagem.
 * <p>
 * Atributos:
 * - Não possui atributos próprios, utilizando apenas os dados do cliente
 * - Utiliza o número de telefone do cliente para envio/recebimento
 * <p>
 * Métodos:
 * - enviarMensagem(): Implementa o envio de mensagens SMS
 * - receberResposta(): Implementa o recebimento de respostas via SMS
 */
public class ServicoSMS implements ServicoMensagem {
    /**
     * Envia uma mensagem SMS para o número do cliente
     *
     * @param mensagem Conteúdo textual da mensagem (limitado a 160 caracteres)
     * @param cliente  Objeto Cliente contendo o número de telefone
     */
    @Override
    public void enviarMensagem(String mensagem, Cliente cliente) {
        System.out.println("Enviando SMS para " + cliente.getNome() + ": " +
                cliente.getTelefone() + ": Mensagem " + mensagem);
    }

    /**
     * Processa uma resposta recebida via SMS
     *
     * @param resposta Conteúdo textual da resposta
     * @param cliente  Objeto Cliente que enviou a resposta
     */
    @Override
    public void receberResposta(String resposta, Cliente cliente) {
        System.out.println("Resposta por SMS de " + cliente.getNome() + ": " +
                cliente.getTelefone() + ": Mensagem " + resposta);
    }
}