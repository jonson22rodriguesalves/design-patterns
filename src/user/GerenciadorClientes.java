package user;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe Singleton para gerenciamento centralizado de clientes.
 * Implementa o padrão Singleton para garantir uma única instância no sistema.
 * <p>
 * Atributos:
 * - instancia (GerenciadorClientes): Única instância da classe (parte do padrão Singleton)
 * - clientes (List<Cliente>): Lista que armazena todos os clientes cadastrados
 * <p>
 * Métodos:
 * - getInstancia(): Método estático para obter a instância única (Singleton)
 * - adicionarCliente(Cliente): Adiciona um novo cliente à lista
 * - getClientes(): Retorna uma cópia da lista de clientes (proteção contra modificações externas)
 * - getClientePorNome(String): Busca cliente pelo nome (case insensitive)
 */
public class GerenciadorClientes {
    private static GerenciadorClientes instancia;
    private List<Cliente> clientes;

    /**
     * Construtor privado (parte do padrão Singleton)
     * Inicializa a lista de clientes como uma ArrayList vazia
     */
    private GerenciadorClientes() {
        clientes = new ArrayList<>();
    }

    /**
     * Obtém a instância única do Gerenciador (Singleton)
     *
     * @return Instância única do GerenciadorClientes
     */
    public static synchronized GerenciadorClientes getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorClientes();
        }
        return instancia;
    }

    /**
     * Adiciona um novo cliente ao gerenciador
     *
     * @param cliente Objeto Cliente a ser adicionado
     */
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * Retorna uma cópia da lista de clientes
     *
     * @return Lista imutável de clientes
     */
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes); // Retorna cópia para evitar alterações externas
    }

    /**
     * Busca um cliente pelo nome (case insensitive)
     *
     * @param nome Nome do cliente a ser buscado
     * @return Objeto Cliente encontrado ou null se não existir
     */
    public Cliente getClientePorNome(String nome) {
        return clientes.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }
}