# Habilitando un cluster Apache Kafka

_Es un proyecto que permite desplegar un cluster Apache Kafka en contenedores Docker_

## Comenzando 🚀
### Pre-requisitos 📋

* Docker
* Docker Compose


### Instalación 🔧

_Ejecutar los siguientes comandos:_

_Clonar el proyecto_

```
git clone https://github.com/rzbroncano/Habilitando-un-cluster-Apache-Kafka.git
```

_Crear un archivo "docker-compose.yml" con el siguiente contenido:_

```
version: '2'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
    ports:
      - 22181:2181
  
  kafka:
    image: confluentinc/cp-kafka:latest
    depends_on:
      - zookeeper
    ports:
      - 29092:29092
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092,PLAINTEXT_HOST://localhost:29092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
```

_Iniciamos el cluster Kafka_

```
docker-compose up -d
```
_Ejecutamos los siguiente comandos paa validar si inicio los servicios dentro del cluster Kafka_


```
$ nc -z localhost 22181
$ nc -z localhost 29092

ó

netstat -ano | grep 22181
netstat -ano | grep 29092
```

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Visual Studio](https://spring.io/) - Herramienta de desarrollo

## Contribuyendo 🖇️

Por favor lee el [CONTRIBUTING.md](https://gist.github.com/villanuevand/xxxxxx) para detalles de nuestro código de conducta, y el proceso para enviarnos pull requests.

## Autores ✒️

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Renzo Broncano** - *Trabajo Inicial* - [rzbroncano](https://github.com/rzbroncano)


---
⌨️ con ❤️ por [rzbroncano](https://github.com/rzbroncano) 😊
