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

# Create a script to handle environment variables
RUN echo '#!/bin/sh\n\
sed -i "s|#{COSMOS_DB_ENDPOINT}#|$COSMOS_DB_ENDPOINT|g" /app/application.properties\n\
sed -i "s|#{COSMOS_DB_KEY}#|$COSMOS_DB_KEY|g" /app/application.properties\n\
sed -i "s|#{COSMOS_DB_DATABASE}#|$COSMOS_DB_DATABASE|g" /app/application.properties\n\
java --add-opens java.base/java.math=ALL-UNNAMED -jar app.jar\n'\
> /app/run.sh && chmod +x /app/run.sh

# Copy the application.properties file
COPY src/main/resources/application.properties /app/application.properties

# Set the entrypoint to our new script
ENTRYPOINT ["/app/run.sh"]

# Expose the port your application runs on
EXPOSE 8080