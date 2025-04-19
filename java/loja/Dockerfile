# Etapa 1: Build da aplicação
FROM maven:3.9.4-eclipse-temurin-21 AS build

COPY java/loja /opt/app
WORKDIR /opt/app

# Compila e empacota o .jar sem rodar os testes
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final com apenas o JAR
FROM eclipse-temurin:21-jdk

# Copia o .jar da etapa de build (ajuste o nome se for diferente)
COPY --from=build /opt/app/target/*.jar /opt/app/loja.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/opt/app/loja.jar"]
