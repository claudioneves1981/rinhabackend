# Define a imagem base
FROM openjdk:11

# Copia o arquivo JAR do seu projeto para dentro do container
COPY target/rinhabackend-0.0.1-SNAPSHOT.jar /app/rinhabackend-0.0.1-SNAPSHOT.jar


# Define o diretório de trabalho
WORKDIR /app

# Instala o Postgres
RUN apt-get update && apt-get install -y postgresql

# Expõe a porta do seu projeto
EXPOSE 8080

# Define o comando de inicialização do seu projeto
CMD ["java", "-jar", "rinhabackend-0.0.1-SNAPSHOT.jar"]
