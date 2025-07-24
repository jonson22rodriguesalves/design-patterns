package user;

import service.ServicoMensagem;

/**
 * Classe que representa um cliente do sistema de marketing e mensageria.
 * <p>
 * Atributos:
 * - nome (String): Nome completo do cliente
 * - email (String): Endereço de e-mail do cliente
 * - telefone (String): Número de telefone para contato
 * - facebook (String): Perfil/URL do Facebook (opcional)
 * - servicoPreferido (ServicoMensagem): Serviço de mensagem preferido pelo cliente (WhatsApp, SMS, etc)
 * <p>
 * Métodos:
 * - Construtor: Inicializa todos os atributos do cliente
 * - Getters: Fornecem acesso controlado aos atributos privados
 * - responderMensagem: Permite ao cliente responder mensagens através do serviço preferido
 */
public class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private String facebook;
    private ServicoMensagem servicoPreferido;

    /**
     * Construtor da classe Cliente.
     *
     * @param nome             Nome completo do cliente
     * @param email            E-mail válido do cliente
     * @param telefone         Telefone no formato adequado
     * @param facebook         URL ou identificador do Facebook (pode ser vazio)
     * @param servicoPreferido Serviço de mensageria preferido pelo cliente
     */
    public Cliente(String nome, String email, String telefone, String facebook, ServicoMensagem servicoPreferido) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.facebook = facebook;
        this.servicoPreferido = servicoPreferido;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getFacebook() {
        return facebook;
    }

    public ServicoMensagem getServicoPreferido() {
        return servicoPreferido;
    }

    /**
     * Envia uma resposta do cliente através do seu serviço de mensagem preferido.
     *
     * @param resposta Texto da resposta a ser enviada
     */
    public void responderMensagem(String resposta) {
        servicoPreferido.receberResposta(resposta, this);
    }
}