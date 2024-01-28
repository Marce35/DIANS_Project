# Use a base image with Java 17 installed
FROM eclipse-temurin:17

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/frontend-service.jar frontend-service.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "frontend-service.jar"]