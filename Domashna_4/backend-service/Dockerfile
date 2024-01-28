# Use a base image with Java 17 installed
FROM eclipse-temurin:17

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/backend-service.jar backend-service.jar

# Copy the CSV file into the container
COPY src/main/resources/filtered_database.csv /filtered_database.csv

# Expose the port that your Spring Boot application will run on
EXPOSE 9090

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "backend-service.jar"]