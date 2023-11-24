FROM eclipse-temurin:19-alpine

RUN mkdir /opt/app
COPY ./target/game-center-0.0.1-SNAPSHOT.jar /opt/app/game-center.jar
CMD ["java", "-jar", "/opt/app/game-center.jar"]