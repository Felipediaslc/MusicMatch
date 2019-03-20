[![Build Status](https://travis-ci.org/Nosbielc/MusicMatch.svg?branch=master)](https://travis-ci.org/Nosbielc/MusicMatch)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.nosbielc.music.match:music-match&metric=alert_status)](https://sonarcloud.io/dashboard/index/com.nosbielc.music.match:music-match)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=com.nosbielc.music.match%3Amusic-match&metric=bugs)](https://sonarcloud.io/dashboard?id=com.nosbielc.music.match%3Amusic-match)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.nosbielc.music.match%3Amusic-match&metric=coverage)](https://sonarcloud.io/dashboard?id=com.nosbielc.music.match%3Amusic-match)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=com.nosbielc.music.match%3Amusic-match&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=com.nosbielc.music.match%3Amusic-match)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=com.nosbielc.music.match%3Amusic-match&metric=security_rating)](https://sonarcloud.io/dashboard?id=com.nosbielc.music.match%3Amusic-match)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=com.nosbielc.music.match%3Amusic-match&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=com.nosbielc.music.match%3Amusic-match)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=com.nosbielc.music.match%3Amusic-match&metric=ncloc)](https://sonarcloud.io/dashboard?id=com.nosbielc.music.match%3Amusic-match)

# MusicMatch
Projeto para seleção de musicas baseando-se na temperatura da cidade/Coordenadas solicitada.

### Detalhes da API RESTful MusicMatch

#### A API RESTful contém as seguintes características:  
* Projeto criado com Spring Boot e Java 8
* Banco de dados H2 e Spring Data JPA
* Migração de banco de dados com Flyway
* Testes unitários e de integração com JUnit e Mockito
* Integração contínua com TravisCI

### Como executar a aplicação (Docker)
```
docker run -d -p 9000:9000 nosbielc/music-match:latest

* Acesse os endpoints através da url http://localhost:9000/musicMatch
* Acesse o Swagger através da url http://localhost:9000/musicMatch/swagger-ui.html#/
* Acesse o Console HSQLDB http://localhost:9000/musicMatch/console
```

### Como executar a aplicação (Maven)
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional, assim como o Git e Java 8.
```
git clone https://github.com/Nosbielc/MusicMatch.git
cd MusicMatch
mvn spring-boot:run

* Acesse os endpoints através da url http://localhost:9000/musicMatch
* Acesse o Swagger através da url http://localhost:9000/musicMatch/swagger-ui.html#/
* Acesse o Console HSQLDB http://localhost:9000/musicMatch/console
```

### Pendências no Projeto
* Documentar metodos
* Implementar mais testes
