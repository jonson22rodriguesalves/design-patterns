package service;

import user.Cliente;

/**
 * Implementação concreta do serviço de mensageria via redes sociais.
 * Segue o padrão Strategy implementando a interface ServicoMensagem.
 * <p>
 * Atributos:
 * - Não possui atributos próprios, utilizando apenas os dados do cliente
 * - Utiliza o perfil do Facebook do cliente para as operações
 * <p>
 * Métodos:
 * - enviarMensagem(): Implementa o postagem em redes sociais
 * - receberResposta(): Implementa o recebimento de comentários/respostas
 */
public class ServicoRedesSociais implements ServicoMensagem {
    /**
     * Realiza postagem em rede social do cliente
     *
     * @param mensagem Conteúdo textual da postagem
     * @param cliente  Objeto Cliente contendo os dados do perfil social
     */
    @Override
    public void enviarMensagem(String mensagem, Cliente cliente) {
        System.out.println("Postando para " + cliente.getNome() + ": " +
                cliente.getFacebook() + ": Mensagem " + mensagem);
    }

    /**
     * Processa um comentário/resposta recebido em rede social
     *
     * @param resposta Conteúdo textual do comentário/resposta
     * @param cliente  Objeto Cliente que enviou o comentário
     */
    @Override
    public void receberResposta(String resposta, Cliente cliente) {
        System.out.println("Comentário de " + cliente.getNome() + ": " +
                cliente.getFacebook() + ": Mensagem " + resposta);
    }
}
