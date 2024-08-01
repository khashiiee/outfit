# Use Maven image with Java 21 to build the application
FROM maven:3-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use Eclipse Temurin JRE 21 image for the runtime
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Set the entrypoint to run the Spring Boot application with the specified JVM arguments
ENTRYPOINT ["sh", "-c", "java --add-opens java.base/java.math=ALL-UNNAMED -jar app.jar"]

# Expose the port your application runs on
EXPOSE 8080