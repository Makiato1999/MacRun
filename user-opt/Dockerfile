FROM eclipse-temurin:19-alpine

RUN mkdir /opt/app
COPY ./target/user-opt-0.0.1-SNAPSHOT.jar /opt/app/user-opt.jar
CMD ["java", "-jar", "/opt/app/user-opt.jar"]