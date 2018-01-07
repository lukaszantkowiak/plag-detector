FROM openjdk:8-jre-alpine
ADD plag-api/target/plag-api-0.0.1-SNAPSHOT.jar plag-api.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "plag-api.jar"]
