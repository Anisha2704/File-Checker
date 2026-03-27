# Use Java 17 runtime
FROM eclipse-temurin:17-jdk-jammy

# Set working folder
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the project
RUN ./mvnw clean package -DskipTests

# Tell Docker which port the app runs on
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/filechecker-0.0.1-SNAPSHOT.jar"]