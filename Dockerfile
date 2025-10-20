FROM openjdk:17-jdk-slim
WORKDIR /app
COPY MyFirstCRUDOperation-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8282
ENTRYPOINT ["java", "-jar", "app.jar"]

