#doesnt connect to db
#build stage
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11.0.11-jdk-slim
WORKDIR /app
COPY --from=build /home/app/target/wikime_storage-1.0-SNAPSHOT.jar /wikime_storage.jar
EXPOSE 8081
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo:27017/wikime_storage", "-jar","/wikime_storage.jar"]