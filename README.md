# Projeto de CRUD em Java com Servlet

Este é um exemplo de um projeto de CRUD (Create, Read, Update, Delete) em Java utilizando Servlets e conectando a um banco de dados MySQL. O projeto é uma aplicação web que permite gerenciar funcionários em um banco de dados. Você pode criar, editar, visualizar e excluir funcionários.

## Tabela de Conteúdo

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Descrição](#descrição)
- [Instruções de Uso](#instruções-de-uso)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Capturas de Tela](#capturas-de-tela)
- [Contribuições](#contribuições)
- [Licença](#licença)

## Tecnologias Utilizadas

- Java
- Servlets
- MySQL
- HTML

## Descrição

Este projeto consiste em um sistema de gerenciamento de funcionários, onde você pode realizar as seguintes operações:

- **Criar Funcionário**: Adicione informações de um novo funcionário, incluindo nome, senha, email e país.
- **Editar Funcionário**: Atualize as informações de um funcionário existente.
- **Excluir Funcionário**: Remova um funcionário do banco de dados.
- **Visualizar Funcionários**: Liste todos os funcionários cadastrados.

## Instruções de Uso

1. **Pré-requisitos**:

   - [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
   - [Eclipse IDE](https://www.eclipse.org/downloads/)
   - Servidor Web (por exemplo, [Apache Tomcat](http://tomcat.apache.org/))
   - Banco de Dados MySQL

2. **Configuração do Banco de Dados**:

   - Crie um banco de dados chamado `crud_exemplo` no MySQL.
   - Configure as informações de conexão com o banco de dados no arquivo `FuncionarioDao.java`.

3. **Importação do Projeto**:

   - Clone este repositório ou faça o download do código-fonte.
   - Importe o projeto para o Eclipse.

4. **Execução do Projeto**:

   - Configure o servidor web (Tomcat) no Eclipse.
   - Inicie o servidor.
   - Execute a aplicação no navegador acessando `http://localhost:8080/seucontexto` (ajuste o contexto da aplicação).

5. **Uso da Aplicação**:

   - Abra a aplicação no navegador.
   - Você poderá criar, editar, excluir e visualizar funcionários.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

- `index.jsp`: Página HTML para adicionar ou editar funcionários.
- `FuncionarioDao.java`: Classe Java para interagir com o banco de dados.
- `EditServlet.java`: Servlet para editar funcionários.
- `EditServlet2.java`: Servlet para processar as edições no banco de dados.
- `SaveServlet.java`: Servlet para adicionar funcionários.
- `ViewServlet.java`: Servlet para visualizar a lista de funcionários.
- `DeleteServlet.java`: Servlet para excluir funcionários.
- Outros arquivos relacionados ao projeto.

Essas classes e arquivos desempenham funções específicas na aplicação web de gerenciamento de funcionários. A estrutura do projeto é organizada para tornar o desenvolvimento, manutenção e expansão do projeto mais fácil e eficiente.

## Capturas de Tela

Aqui estão algumas capturas de tela da aplicação em execução:

1. **Tela de Cadastro**:
   ![Tela de Cadastro](caminho_da_imagem1.png)
   Descrição: Esta captura de tela mostra a tela de cadastro, onde você pode adicionar informações de um novo funcionário.

2. **Cadastro com Sucesso**:
   ![Cadastro com Sucesso](caminho_da_imagem2.png)
   Descrição: Nesta captura de tela, você pode ver a confirmação de que o cadastro foi bem-sucedido.

3. **Editar Funcionário**:
   ![Editar Funcionário](caminho_da_imagem3.png)
   Descrição: Aqui, você pode ver a tela de edição, onde é possível modificar as informações de um funcionário existente.

4. **Funcionário Editado**:
   ![Funcionário Editado](caminho_da_imagem4.png)
   Descrição: Esta captura de tela mostra a confirmação de que o funcionário foi editado com sucesso.

5. **Excluir Funcionário**:
   ![Excluir Funcionário](caminho_da_imagem5.png)
   Descrição: Aqui, você pode ver a tela de exclusão, onde é possível remover um funcionário do banco de dados.
   
## Contribuições

Contribuições são bem-vindas! Se você deseja melhorar ou expandir este projeto, fique à vontade para criar um fork e enviar um pull request.

## Licença

Este projeto é licenciado sob a [Licença MIT](LICENSE), o que significa que você pode usá-lo livremente, modificar e distribuir de acordo com os termos da licença.
