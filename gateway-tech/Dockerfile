FROM eclipse-temurin:19-alpine

RUN mkdir /opt/app
COPY ./target/gateway-tech-0.0.1-SNAPSHOT.jar /opt/app/gateway-tech.jar
CMD ["java", "-jar", "/opt/app/gateway-tech.jar"]