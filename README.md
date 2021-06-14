# Bootcamp Quality Challenge

A empresa "Sua Avaliação de Casas" precisa ser capaz de calcular os metros quadrados e o custo dos diferentes imóveis que possui em sua carteira de clientes.

Para isso, solicita de cada propriedade: um nome, um bairro e a quantidade de cômodos que tem; ao mesmo tempo, cada cômodo contém um nome, uma largura e um comprimento.

# Tecnologias
## Back end
- [Java](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html) versão 11
- [Maven](https://maven.apache.org/docs/3.8.1/release-notes.html) versão 3.8.1

### Montando ambiente:

Baixar o projeto usando o comando git clone.

Executando pela linha de comando na pasta da raiz do projeto, crie o jar do projeto:

`./mvnw clean install`

Para executar os testes unitários, use o comando:

`./mvnw test`

### Acesso as collections usando o Postman:

Faça o download do arquivo na pasta resources :
```
postman_collection.json
```
Import o arquivo no postman para acessar as collections.

### Acesso a cobertura de testes do Jacoco:

Acesse o arquivo ```index.html``` do Jacoco:
```
target/site/jacoco/index.html
```
Depois execute o arquivo em um browser de sua preferência.

## Autor

Jéssika Fernandes

[Linkedin](https://br.linkedin.com/in/ajessikafernandes) | [Github](https://github.com/ajessikafernandes)
