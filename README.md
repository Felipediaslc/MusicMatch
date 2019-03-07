[![Build Status](https://travis-ci.org/Nosbielc/MusicMatch.svg?branch=master)](https://travis-ci.org/Nosbielc/MusicMatch)

# MusicMatch
Projeto para seleção de musicas baseando-se na temperatura da localização solicitada.

### Detalhes da API RESTful MusicMatch
A API RESTful contém as seguintes características:  
* Projeto criado com Spring Boot e Java 8
* Banco de dados H2 com JPA e Spring Data JPA
* Migração de banco de dados com Flyway
* Testes unitários e de integração com JUnit e Mockito
* Integração contínua com TravisCI

### Como executar a aplicação
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional, assim como o Git e Java 8.
```
git clone https://github.com/Nosbielc/MusicMatch.git
cd MusicMatch
mvn spring-boot:run
Acesse os endpoints através da url http://localhost:9000/musicMatch
Acesse o Swagger através da url http://localhost:9000/musicMatch/swagger-ui.html#/
Acesse o Console HSQLDB http://localhost:9000/musicMatch/console
```