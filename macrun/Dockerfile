FROM eclipse-temurin:19-alpine

RUN mkdir /opt/app
COPY ./target/macrun-0.0.1-SNAPSHOT.jar /opt/app/macrun.jar
CMD ["java", "-jar", "/opt/app/macrun.jar"]