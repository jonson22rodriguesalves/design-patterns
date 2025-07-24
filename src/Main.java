/**
 * Classe principal que inicia a aplicação de Marketing e Mensageria.
 * <p>
 * Atributos:
 * - Não possui atributos próprios, atuando apenas como ponto de entrada do programa.
 * <p>
 * Métodos:
 * - main(String[] args): Método estático que serve como ponto de entrada da aplicação Java.
 * Cria uma instância de Menu e inicia o sistema chamando o método exibirMenuPrincipal().
 */

import user.Menu;

public class Main {
    /**
     * Ponto de entrada principal para a aplicação.
     * @param args Argumentos de linha de comando (não utilizados neste caso)
     */
    public static void main(String[] args) {
        // Cria e inicia o menu principal do sistema
        Menu menu = new Menu();
        menu.exibirMenuPrincipal();
    }
}