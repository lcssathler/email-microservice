# Microsserviços com Comunicação Assíncrona via RabbitMQ

Este projeto demonstra a comunicação **não bloqueante** entre dois microsserviços independentes utilizando **Spring Boot**, **RabbitMQ** e **PostgreSQL**. O objetivo é simular um cenário real de troca de mensagens assíncronas entre sistemas desacoplados, promovendo escalabilidade e resiliência.

## 🧰 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4**
  - Spring Web
  - Spring AMQP
  - Spring Data JPA
- **RabbitMQ** como broker de mensagens
- **PostgreSQL** como banco de dados relacional
- **CloudAMQP** para provisionamento gratuito de um broker RabbitMQ na nuvem

## 🧩 Arquitetura do Projeto

O sistema é composto por **dois microsserviços independentes**:

### 1. Producer Service (Emissor)
- Expõe uma API REST que aceita requisições HTTP.
- Persiste os dados em seu próprio banco PostgreSQL.
- Publica uma mensagem no RabbitMQ com os dados relevantes do evento.

### 2. Consumer Service (Receptor)
- Fica escutando mensagens em uma fila do RabbitMQ.
- Processa a mensagem recebida de forma assíncrona.
- Também persiste os dados recebidos no seu próprio banco PostgreSQL.

A comunicação entre os serviços é feita exclusivamente via **mensageria assíncrona**, sem chamadas HTTP diretas entre eles.

## ☁️ CloudAMQP

Para facilitar a implementação e testes, foi utilizado o serviço gratuito da [CloudAMQP](https://www.cloudamqp.com/) para provisionar um broker RabbitMQ acessível publicamente. Isso permitiu uma comunicação real entre serviços executando em diferentes ambientes locais ou remotos.

