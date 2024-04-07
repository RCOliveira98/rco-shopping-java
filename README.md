# RCO-Shopping

Este é o README para o projeto RCO-Shopping, uma aplicação construída com Spring Boot, destinada a ser um estudo prático sobre desenvolvimento de aplicações web e-commerce.

## Visão Geral

RCO-Shopping é um projeto de estudo inspirado em um e-commerce convencional. Ele oferece funcionalidades básicas de um sistema de compras online, permitindo aos usuários navegar por uma lista de produtos, adicionar itens ao carrinho de compras e finalizar as compras.

Este projeto foi desenvolvido utilizando o framework Spring Boot, que proporciona uma infraestrutura robusta para a construção de aplicativos Java com facilidade e rapidez. A arquitetura do Spring Boot favorece a modularidade e a simplicidade, permitindo aos desenvolvedores focarem mais na lógica de negócios do que em configurações complicadas.

## Funcionalidades

- **Cadastro de Usuários:** Os usuários podem se cadastrar na plataforma, fornecendo informações básicas como nome, email e senha.
- **Autenticação e Autorização:** A aplicação oferece um sistema de autenticação seguro, permitindo que os usuários façam login em suas contas. Além disso, a autorização é implementada para controlar o acesso às funcionalidades da aplicação.
- **Navegação de Produtos:** Os usuários podem visualizar uma lista de produtos disponíveis na loja, com detalhes como nome, descrição, preço e imagem.
- **Adição ao Carrinho de Compras:** Os usuários podem adicionar produtos ao seu carrinho de compras enquanto navegam pela loja.
- **Finalização de Compra:** Os usuários podem revisar os itens no carrinho de compras e finalizar suas compras, fornecendo detalhes de entrega e pagamento.

## Como Executar o Projeto

1. **Clonar o Repositório:** Clone este repositório para o seu ambiente local utilizando o seguinte comando:

    ```
    git clone https://github.com/seu-usuario/rco-shopping.git
    ```

2. **Configurar o Ambiente de Desenvolvimento:** Certifique-se de ter o JDK e o Maven instalados em sua máquina.

3. **Configurar o Banco de Dados:** Configure as informações de conexão com o banco de dados no arquivo `application.properties`.

4. **Executar a Aplicação:** Navegue até o diretório do projeto clonado e execute o seguinte comando:

    ```
    mvn spring-boot:run
    ```

5. **Acessar a Aplicação:** Após a execução bem-sucedida, a aplicação estará disponível em `http://localhost:8080`.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests com melhorias, correções de bugs ou novas funcionalidades.

## Autores

- [Romário Coelho Oliveira](https://github.com/RCOliveira98) - Desenvolvedor

## Licença

Este projeto é licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT) - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Agradecimentos

- Agradecemos ao Spring Boot pela excelente infraestrutura fornecida para o desenvolvimento deste projeto.
- Agradecemos a todos os contribuidores e membros da comunidade que ajudaram a tornar este projeto possível.
