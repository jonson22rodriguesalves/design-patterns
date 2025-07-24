# Santander Boot Camp 2025

# 🎬 Sistema Integrado de Mensageria Marketing

Sistema Java para gestão de campanhas de marketing multicanal com gerenciamento de clientes, implementando:
* Arquitetura baseada no padrão Facade para integração simplificada
* Gerenciamento centralizado de clientes (Singleton)
* Interface comum para serviços de mensagens (SMS, E-mail, Redes Sociais, WhatsApp)
* Envio segmentado por serviço preferencial ou em massa
* Processamento de respostas dos clientes
* Cadastro e listagem de clientes com validação de dados
* Menu interativo com tratamento de exceções

# 🛠️ Tecnologias Utilizadas
* Java 17+
* Padrões de Design:
    - Singleton (Gerenciador de Clientes)
    - Strategy (Serviços de Mensagem)
    - Facade (Integração de Subsistemas)
* Validação de entradas com regex
* Collections Framework (List, ArrayList)
* Scanner para entrada de dados interativa

* 📚 Pré-requisitos
* Java JDK 17 ou superior
* Conhecimento básico de compilação Java
* Terminal/Console para execução

* 🚀 Como Executar
* Compile o programa:
* bash
* javac -d bin src/*.java src/user/*.java src/service/*.java
 
* Execute o programa:
 
* bash
* java -cp bin Main
 
* Siga o fluxo interativo:
 
* === Sistema Integrado de Marketing ===
1. Enviar mensagem para todos os clientes
2. Enviar mensagem para cliente específico
3. Processar resposta de cliente
4. Listar Clientes
5. Adicionar Cliente
0. Sair
   Escolha uma opção:

* 🎯 Funcionalidades Implementadas
✔️ Sistema baseado em interface para serviços de mensagens
✔️ Implementações para 4 canais de comunicação (WhatsApp, Email, SMS, Redes Sociais)
✔️ Gerenciamento centralizado de clientes (Singleton)
✔️ Cadastro de clientes com validação de dados
✔️ Envio segmentado por serviço preferencial ou em massa
✔️ Processamento de respostas dos clientes
✔️ Arquitetura expansível para novos serviços
✔️ Separação clara entre:

* Camada de Apresentação (Menu)
* Camada de Negócios (MarketingMensageria)
* Camada de Integração (Facade)
* Camada de Dados (GerenciadorClientes)

* 📝 Exemplo de Uso

* === Sistema Integrado de Marketing ===
* Escolha uma opção: 5
*  
* Digite o nome do cliente (apenas letras): João Silva
* Digite o email (ex: usuario@dominio.com): joao@exemplo.com
* Digite o telefone (11 dígitos, ex: 11988776655): 11987654321
* Digite o nome da rede social: facebook
* Escolha o serviço de mensagem:
1 - WhatsApp
2 - Email
3 - SMS
4 - Redes Sociais
* Digite o número do serviço: 1
* ✅ Cliente cadastrado com sucesso!

* Escolha uma opção: 1
* Digite a mensagem de marketing: Promoção exclusiva para novos clientes!
* Enviando WhatsApp para João Silva: 11987654321: Mensagem Promoção exclusiva para novos clientes!

* ⚠️ Importante
* O sistema demonstra o padrão de envio mas não conecta com serviços reais
* Novos serviços podem ser adicionados implementando a interface ServicoMensagem
* Todos os clientes demo são inicializados automaticamente:
* Admin (WhatsApp)
* Analista (Email)
* O sistema não persiste dados entre execuções
 
 ````mermaid
classDiagram
    class ServicoMensagem {
        <<interface>>
        +enviarMensagem(String, Cliente)
        +receberResposta(String, Cliente)
    }
    
    class ServicoWhatsApp {
        +enviarMensagem(String, Cliente)
        +receberResposta(String, Cliente)
    }
    
    class ServicoEmail {
        +enviarMensagem(String, Cliente)
        +receberResposta(String, Cliente)
    }
    
    class ServicoSMS {
        +enviarMensagem(String, Cliente)
        +receberResposta(String, Cliente)
    }
    
    class ServicoRedesSociais {
        +enviarMensagem(String, Cliente)
        +receberResposta(String, Cliente)
    }
    
    class Cliente {
        -nome: String
        -email: String
        -telefone: String
        -facebook: String
        -servicoPreferido: ServicoMensagem
        +responderMensagem(String)
    }
    
    class GerenciadorClientes {
        -clientes: List~Cliente~
        +getInstancia() GerenciadorClientes
        +adicionarCliente(Cliente)
        +getClientes() List~Cliente~
        +getClientePorNome(String) Cliente
    }
    
    class MarketingMensageria {
        -servico: ServicoMensagem
        +setServico(ServicoMensagem)
        +enviarMensagem(String, Cliente)
    }
    
    class SistemaMarketingFacade {
        -mensageria: MarketingMensageria
        -gerenciadorClientes: GerenciadorClientes
        +enviarMensagemParaTodos(String)
        +enviarMensagemParaCliente(String, String)
        +processarResposta(String, String)
    }
    
    class Menu {
        -scanner: Scanner
        -facade: SistemaMarketingFacade
        -gerenciador: GerenciadorClientes
        +exibirMenuPrincipal()
    }
    
    ServicoMensagem <|.. ServicoWhatsApp
    ServicoMensagem <|.. ServicoEmail
    ServicoMensagem <|.. ServicoSMS
    ServicoMensagem <|.. ServicoRedesSociais
    Cliente --> ServicoMensagem
    GerenciadorClientes --> Cliente
    SistemaMarketingFacade --> MarketingMensageria
    SistemaMarketingFacade --> GerenciadorClientes
    Menu --> SistemaMarketingFacade
    Menu --> GerenciadorClientes

 ````
* 📌 Notas de Implementação

* Princípios SOLID Aplicados
* Single Responsibility: Cada classe tem uma única responsabilidade bem definida
* Menu: Interação com usuário
* MarketingMensageria: Lógica de envio
* GerenciadorClientes: Gestão de dados
* Open/Closed:
* Liskov Substitution: Todos os serviços substituem corretamente a interface ServicoMensagem
* Interface Segregation: A interface contém apenas métodos essenciais para serviços de mensagem
* Dependency Inversion:
* Factory Method	no Menu	Criação flexível de objetos

* Padrões Utilizados:
* Singleton: Garante único gerenciador de clientes no sistema 
* Strategy: Diferentes serviços de mensagem implementam a mesma interface
* Facade: Simplifica a interação com subsistemas complexos

* Boas Práticas Implementadas
* Validação Robusta:
* Imutabilidade:
* Tratamento de Erros:
* Acoplamento Fraco:
* Documentação Clara:
 
* Validações:
* Nome: Apenas letras e espaços
* Email: Formato padrão com @ e domínio
* Telefone: 11 dígitos numéricos
 
* Expansibilidade:
* Para adicionar novo serviço:
* Criar classe implementando ServicoMensagem
* Adicionar opção no método selecionarServicoMensagem() do Menu
 
* Clientes Demo:
* São automaticamente cadastrados ao iniciar o sistema:
* new Cliente("Admin", "admin@appleledsoftware.com", "11999999999", "youtube", new ServicoWhatsApp())
* new Cliente("Analista", "analista@appleledsoftware.com", "11988888888", "facebook", new ServicoEmail())
 
 
* 📌 Notas de Implementação
 
* Cada serviço implementa a mesma interface garantindo consistência
* O sistema demonstra o princípio Open/Closed (aberto para extensão)
* Fácil adição de novos serviços sem modificar a lógica principal
* Design desacoplado permite substituir implementações facilmente