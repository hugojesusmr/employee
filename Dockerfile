FROM openjdk:18-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/employee-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} employee.jar
ENTRYPOINT ["java","-jar","/employee.jar"]