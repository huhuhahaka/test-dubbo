FROM openjdk:8-jdk-alpine
COPY ./target/consumer-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8091
RUN mkdir -p "/opt/logs/com/example"
CMD ["java", "-jar", "app.jar"]
MAINTAINER GGL