FROM eclipse-temurin:19-alpine

RUN mkdir /opt/app
COPY ./target/heartrate-monitor-0.0.1-SNAPSHOT.jar /opt/app/heartrate-monitor.jar
CMD ["java", "-jar", "/opt/app/heartrate-monitor.jar"]