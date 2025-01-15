FROM maven:3.9.9-openjdk-21 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package


FROM openjdk:21-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8888
ENTRYPOINT [ "java", "-jav", "app.jar" ]