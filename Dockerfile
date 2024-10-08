FROM openjdk:17.0-jdk-slim
COPY target/classes/ParkingLot/ /app
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
CMD java