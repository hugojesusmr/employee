FROM openjdk:11-jre-slim
ARG JAR_FILE=build/libs/employee-1.0.jar
ADD ${JAR_FILE} employee.jar
ENTRYPOINT ["java","-jar","/employee.jar"]