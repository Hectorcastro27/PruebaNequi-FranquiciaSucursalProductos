FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/PruebaNequi-0.0.1-SNAPSHOT.jar-1.0.0.jar /app/PruebaNequi.jar

EXPOSE 8080

#LABEL authors="Hector Castro"

ENTRYPOINT ["java", "-jar", "PruebaNequi.jar"]