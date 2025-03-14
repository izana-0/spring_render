# First stage: Build
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests

# Second stage: Runtime
FROM openjdk:21-alpine
WORKDIR /app
COPY --from=build /app/target/coffee-shop-telegram-bot-0.0.1-SNAPSHOT-plain.jar coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar"]
