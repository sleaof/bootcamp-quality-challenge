# Bootcamp Quality Challenge

A empresa "Sua Avaliação de Casas" precisa ser capaz de calcular os metros quadrados e o custo dos diferentes imóveis que possui em sua carteira de clientes.

Para isso, solicita de cada propriedade: um nome, um bairro e a quantidade de cômodos que tem; ao mesmo tempo, cada cômodo contém um nome, uma largura e um comprimento.

# Tecnologias
## Back end
- [Java](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html) versão 11
- [Maven](https://maven.apache.org/docs/3.8.1/release-notes.html) versão 3.8.1
- [Jacoco](https://www.baeldung.com/jacoco) versão 0.8.5

# API Utilizada
- [Api de Distritos por UF](https://servicodados.ibge.gov.br/api/docs/localidades#api-Distritos-estadosUFDistritosGet)

Obtém o conjunto de distritos do Brasil a partir dos identificadores das Unidades da Federação


# Montando ambiente:

Baixar o projeto usando o comando git clone.

Executando pela linha de comando na pasta da raiz do projeto, crie o jar do projeto:

`./mvnw clean install`

Para executar os testes unitários, use o comando:

`./mvnw test`


# Documentação 
## Acesso as collections usando o Postman:

Faça o download do arquivo na pasta resources :
```
postman_collection.json
```
Import o arquivo no postman para acessar as collections.


# Jacoco
## Acesso ao relatório do Jacoco através do navegador:

Usando o navegador de sua preferencia acesse ao [Jacoco](http://localhost:63342/bootcamp-quality-challenge/bootcamp-challenge-test/target/site/jacoco/index.html):
```
http://localhost:63342/bootcamp-quality-challenge/bootcamp-challenge-test/target/site/jacoco/index.html
```

## Acesso a cobertura de testes do Jacoco na pasta resources:

Acesse o arquivo ```index.html``` do Jacoco:
```
target/site/jacoco/index.html
```
Depois execute o arquivo em um browser de sua preferência.

# Visualização da Cobertura de Testes

![Jacoco](https://github.com/sleaof/bootcamp-quality-challenge/blob/JessikaFernandes/blob/assets/jacoco.png)

## Autor

Jéssika Fernandes

[Linkedin](https://br.linkedin.com/in/ajessikafernandes) | [Github](https://github.com/ajessikafernandes)
