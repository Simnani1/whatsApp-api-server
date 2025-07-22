# Start with a JDK base image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar file (replace with your actual jar name)
COPY target/whatsapp-backend.jar app.jar

# Expose port
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
