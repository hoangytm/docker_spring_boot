FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/example.smallest-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
CMD mkdir upload_file
#ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["java", "-Dspring.profiles.active=test","-jar","/app.jar"]