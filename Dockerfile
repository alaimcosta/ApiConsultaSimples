FROM openjdk:17-jdk-alpine

COPY target/apiConsulta-1.0-SNAPSHOT.jar app-1.0.0.jar

ENTRYPOINT [ "java", "-jar", "app-1.0.0.jar" ]