FROM openjdk:17-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/parkride-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} parkride.jar
ENTRYPOINT ["java","-jar","/parkride.jar"]