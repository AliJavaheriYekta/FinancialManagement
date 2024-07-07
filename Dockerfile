# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Add the application's JAR file to the container
ARG JAR_FILE=target/financial-management-app.jar
ADD ${JAR_FILE} app.jar

# Expose the port on which the application will run
EXPOSE 8082

# The command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]