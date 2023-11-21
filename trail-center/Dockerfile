FROM eclipse-temurin:19-alpine

RUN mkdir /opt/app
COPY ./target/trail-center-0.0.1-SNAPSHOT.jar /opt/app/trail-center.jar
CMD ["java", "-jar", "/opt/app/trail-center.jar"]