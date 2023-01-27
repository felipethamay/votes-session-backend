# Votes session backend

No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação. Imagine que você deve criar uma solução para dispositivos móveis para gerenciar e participar dessas sessões de votação. 

Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de uma API REST:

●	Cadastrar uma nova pauta

●	Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default)

●	Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta)

●	Contabilizar os votos e dar o resultado da votação na pauta

Para fins de exercício, a segurança das interfaces pode ser abstraída e qualquer chamada para as interfaces pode ser considerada como autorizada. A solução deve ser construída em java, usando Spring-boot, mas os frameworks e bibliotecas são de livre escolha (desde que não infrinja direitos de uso).

É importante que as pautas e os votos sejam persistidos e que não sejam perdidos com o restart da aplicação.

O foco dessa avaliação é a comunicação entre o backend e o aplicativo mobile. Essa comunicação é feita através de mensagens no formato JSON, onde essas mensagens serão interpretadas pelo cliente para montar as telas onde o usuário vai interagir com o sistema. A aplicação cliente não faz parte da avaliação, apenas os componentes do servidor.

<br />

## Requisitos

Para construir e executar o aplicativo, você precisa:

- [JDK 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven](https://maven.apache.org)

<br />

## Executando a aplicação localmente
Existem várias maneiras de executar um aplicativo Spring Boot em sua máquina local. Uma maneira é executar o método principal `VotesSessionBackendApplication.java` na classe com.votes.session, em sua IDE.

Como alternativa, você pode usar o plug-in Spring Boot Maven da seguinte forma:

```shell
mvn spring-boot:run
```

<br />

## Base de dados

Banco de dados Java SQL embarcado no projeto:

- [H2](https://www.h2database.com/html/main.html)

<br />

## Bibliotecas utilizadas

- [Lombok](https://projectlombok.org/)

<br />

## Documentação

- [Swagger](http://localhost:8080/swagger-ui.html)