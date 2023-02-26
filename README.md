# Guía para configurar y utilizar Apache Kafka en Docker

_Esta es una guía se explicara lo siguiente:_
* Instalación y configuración un nodo/cluster de Apache Kafka con Docker y Docker Compose
* Construir y desplegar un productor con Spring Boot y Spring Kafka
* Construir y desplegar un consumidor con Spring Boot y Spring Kafka

## Comenzando 🚀
### Pre-requisitos 📋

* Docker
* JDK11

## Instalación y configuración un nodo/cluster de Apache Kafka con Docker y Docker Compose
###  Para un nodo

_Ejecutar los siguientes comandos:_

_Clonar el proyecto_

```
git clone https://github.com/rzbroncano/Apache-Kafka-en-Docker.git
```
_Ejecutar el comando para ingresar a la carpeta "single_node"_

```
cd ~/Habilitando-un-cluster-Apache-Kafka/single_node
```

_Iniciamos el cluster Kafka_

```
docker compose up -d
```
_Ejecutamos los siguiente comandos paa validar si inicio los servicios dentro del nodo de Kafka_


```
nc -z localhost 22181
nc -z localhost 29092
```

### Para un cluster

_Ejecutar los siguientes comandos:_

_Ejecutar el comando para ingresar a la carpeta "cluster"_

```
cd ~/Habilitando-un-cluster-Apache-Kafka/cluster
```
_Crear las nuevas redes "network_microservices" y "network_cluster_kafka"_

```
docker network create --driver bridge --subnet=192.169.6.0/24 --ip-range=192.169.6.0/24 network_microservices

docker network create --driver bridge --subnet=192.169.5.0/24 --ip-range=192.169.5.0/24 network_cluster_kafka
```
_Iniciamos el cluster Kafka_

```
docker compose up -d
```
_Ejecutamos los siguiente comandos paa validar si inicio los servicios dentro del cluster Kafka_


```
$ nc -z localhost 22181
$ nc -z localhost 29092
```

## Construir y desplegar un productor con Spring Boot y Spring Kafka

_Previamente se tiene que haber ejecutado las actividades del paso "Instalación y configuración un nodo/cluster de Apache Kafka con Docker y Docker Compose"_

_Ejecutar los siguientes comandos:_

_Clonar el proyecto_

```
git clone https://github.com/rzbroncano/Apache-Kafka-en-Docker.git
```
_Construir el proyecto con Maven_

```
mvn clean package
```
_Construir la imagen docker_

```
docker build -t kafka/sample-kafka-producer .
```
_Levantar el contenedor Docker_

```
docker run -d -p 8080:8080 --network network_microservices -it kafka/sample-kafka-producer .
```
_Agregar el contenedor a la red "network_cluster_kafka"_

```
docker network connect network_cluster_kafka [container_id]
```


## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Visual Studio](https://spring.io/) - Herramienta de desarrollo

## Contribuyendo 🖇️

Por favor lee el [CONTRIBUTING.md](https://github.com/rzbroncano) para detalles de nuestro código de conducta, y el proceso para enviarnos pull requests.

## Autores ✒️

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Renzo Broncano** - *Trabajo Inicial* - [rzbroncano](https://github.com/rzbroncano)


---
⌨️ con ❤️ por [rzbroncano](https://github.com/rzbroncano) 😊