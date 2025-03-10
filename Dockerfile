FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/business_development_backend-0.0.1-SNAPSHOT.jar business_development_backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "business_development_backend.jar"]












