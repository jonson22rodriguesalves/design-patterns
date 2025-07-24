package service;

import user.Cliente;
import user.Menu;

/**
 * Classe principal que gerencia o sistema de marketing e mensageria.
 * Focada na lógica de negócios.
 */
public class MarketingMensageria {
    private ServicoMensagem servico;

    /**
     * Configura o serviço de mensageria a ser utilizado
     *
     * @param servico Implementação concreta de ServicoMensagem
     */
    public void setServico(ServicoMensagem servico) {
        this.servico = servico;
    }

    /**
     * Envia mensagem para um cliente específico
     *
     * @param mensagem Texto da mensagem a ser enviada
     * @param cliente  Destinatário da mensagem
     */
    public void enviarMensagem(String mensagem, Cliente cliente) {
        if (servico != null && cliente != null) {
            servico.enviarMensagem(mensagem, cliente);
        } else {
            System.out.println("❌ Serviço ou cliente não configurado!");
        }
    }

    /**
     * Método principal para iniciar o sistema
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenuPrincipal();
    }
}