# ETAPA 1: Construcción del jar
# Dockerfile está dividido en 2 capas
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# ETAPA 2: Construcción de la imagen final
FROM openjdk:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/SpringAuditJPA.jar /app/SpringAuditJPA.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/SpringAuditJPA.jar"]