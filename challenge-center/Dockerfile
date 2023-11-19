FROM eclipse-temurin:19-alpine

RUN mkdir /opt/app
COPY ./target/challenge-center-0.0.1-SNAPSHOT.jar /opt/app/challenge-center.jar
CMD ["java", "-jar", "/opt/app/challenge-center.jar"]