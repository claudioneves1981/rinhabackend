# Define a imagem base

FROM debian:latest

# Copia o arquivo JAR do seu projeto para dentro do container
COPY target/rinhabackend-0.0.1-SNAPSHOT.jar /app/rinhabackend-0.0.1-SNAPSHOT.jar

# Define o diretório de trabalho
WORKDIR /app

RUN apt-get update && apt-get install -y postgresql && apt-get install -y openjdk-17-jdk

RUN chmod 750 /etc/postgresql/15/main


# Expõe a porta do seu projeto
EXPOSE 8080

# Define o comando de inicialização do seu projeto
CMD ["java", "-jar", "rinhabackend-0.0.1-SNAPSHOT.jar"]
