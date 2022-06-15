FROM openjdk:8-jdk-alpine
COPY ./target/provider-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8090
RUN mkdir -p "/opt/logs/com/example"
CMD ["java", "-jar", "app.jar"]
MAINTAINER GGL