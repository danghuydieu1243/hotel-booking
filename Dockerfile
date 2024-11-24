# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /hotel-booking

# Copy only the project definition files
COPY pom.xml ./

# Pre-fetch dependencies
RUN mvn dependency:resolve dependency:resolve-plugins -B

# Copy the source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Set up the runtime environment
FROM eclipse-temurin:21-jdk-slim AS runtime
WORKDIR /hotel-booking

# Copy the built JAR file from the build stage
COPY --from=build /hotel-booking/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
