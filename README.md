IF-TICKETS

Plataforma de venda de ingressos online desenvolvida como projeto prático para aplicar conceitos de Programação Orientada a Objetos (POO) e tecnologias modernas de desenvolvimento web.

Funcionalidades:
Tela de Login e Cadastro:
Autenticação de usuários.
Cadastro de novos usuários.
Tela de Eventos:
Listagem de eventos disponíveis.
Compra de ingressos.
Tela de Minhas Compras:
Visualização de ingressos comprados.
Cancelamento de compras.

Tecnologias Utilizadas:
Back-end
Java com Spring Boot: Framework para desenvolvimento ágil e eficiente.
Banco de Dados H2: Banco de dados relacional em memória, ideal para testes.
Uso do Postman: Para manuseio das rotas utilizadas pelo Back-end
Front-end
JavaScript, HTML e CSS: Tecnologias básicas para a interface do usuário.


Conceitos de POO Aplicados:
Classes e Objetos: Modelagem de entidades como Usuario, Evento e Ingresso.
Composição: Relacionamento entre classes (ex.: Evento contém uma lista de Ingresso).
Herança: Criação de classes específicas (ex.: Admin herda de Usuario).
Polimorfismo: Métodos com comportamentos diferentes (ex.: cancelarCompra() em Ingresso e IngressoVIP).
Encapsulamento: Proteção de dados (ex.: atributo senha privado em Usuario).
Interfaces e Classes Abstratas: Definição de contratos e comportamentos comuns (ex.: interface Autenticavel).
Como Executar o Projeto
Clone o repositório:
git clone https://github.com/seu-usuario/if-tickets.git
      2.  Navegue até o diretório do projeto:
cd if-tickets.
      3.   Execute o back-end (Spring Boot):
./mvnw spring-boot:run
      4.     Abra o arquivo index.html no navegador para acessar o front-end.


Capturas de tela da interface gráfica em funcionamento
[Telas da interface gráfica](https://github.com/user-attachments/files/19187630/Interface.pdf)
