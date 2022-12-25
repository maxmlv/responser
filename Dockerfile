FROM maven:3.8.6-jdk-11-slim AS BUILD

COPY src /home/app/src
COPY pom.xml /home/app/pom.xml
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim

COPY --from=build /home/app/target/responser-thyme-0.0.1-SNAPSHOT.jar /usr/local/lib/responser-thyme.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/local/lib/responser-thyme.jar"]