FROM eclipse-temurin:19-alpine

RUN mkdir /opt/app
COPY ./target/discovery-server-0.0.1-SNAPSHOT.jar /opt/app/discovery-server.jar
CMD ["java", "-jar", "/opt/app/discovery-server.jar"]