FROM maven:3.9.9-openjdk-21 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package


FROM openjdk:21-alpine
WORKDIR /app
COPY --from=build /app/target/coffee-shop-telegram-bot-0.0.1-SNAPSHOT-plain.jar coffee-shop-telegram-bot-0.0.1-SNAPSHOT.jar
EXPOSE 8888
ENTRYPOINT [ "java", "-jav", "app.jar" ]