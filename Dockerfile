FROM openjdk:11-jre-slim
EXPOSE 8082
ARG JAR_FILE=build/libs/employee.jar
ADD ${JAR_FILE} employee.jar
ENTRYPOINT ["java","-jar","/employee.jar"]