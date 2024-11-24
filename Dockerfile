## Stage 1: Build the application
#FROM maven:3.8.3-openjdk-17 AS build
#WORKDIR /hotel-booking
#
## Copy only the project definition files
#COPY pom.xml .
#
## Download dependencies and cache them
#RUN mvn dependency:go-offline -B
#
## Copy the source code
#COPY src ./src
#
## Build the WAR file
#RUN mvn clean package -DskipTests
#
## Stage 2: Set up the runtime environment
#FROM --platform=linux/amd64 openjdk:17-jdk-slim AS runtime
#WORKDIR /hotel-booking
#
## Copy the built WAR file from the previous stage
#COPY --from=build /hotel-booking/target/hotel-booking-0.0.1-SNAPSHOT.jar deploy.jar
#
## Expose the port on which the application will run
#EXPOSE 8080
#
## Start the application
#ENTRYPOINT ["java", "-jar", "deploy.jar"]
# Stage 1: build
# Start with a Maven image that includes JDK 21
FROM maven:3.9.8-amazoncorretto-21 AS build

# Copy source code and pom.xml file to /app folder
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build source code with maven
RUN mvn package -DskipTests

#Stage 2: create image
# Start with Amazon Correto JDK 21
FROM amazoncorretto:21.0.4

# Set working folder to App and copy complied file from above step
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]