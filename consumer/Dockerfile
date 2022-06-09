FROM openjdk:8-jdk-alpine
ADD ./target/consumer-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8091
CMD ["java", "-jar", "app.jar"]
MAINTAINER GGL