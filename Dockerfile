# Stage 1: Build the application
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /EduCoreSystem

# Copy only the project definition files
COPY pom.xml .

# Download dependencies and cache them
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the WAR file
RUN mvn clean package -DskipTests

# Stage 2: Set up the runtime environment
FROM --platform=linux/amd64 openjdk:17-jdk-slim AS runtime
WORKDIR /hotel-booking

# Copy the built WAR file from the previous stage
COPY --from=build /hotel-booking/target/hotel-booking-0.0.1-SNAPSHOT.jar deploy.jar

# Expose the port on which the application will run
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "deploy.jar"]
