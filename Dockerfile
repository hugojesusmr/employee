FROM openjdk:11-jre-slim
EXPOSE 8082
ARG JAR_FILE=build/libs/employee-1.0.jar
ADD ${JAR_FILE} employee.jar
ENTRYPOINT ["java","-jar","/employee.jar"]