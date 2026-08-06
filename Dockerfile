# jre requirement
FROM eclipse-temurin:21-jdk-alpine

# directory
WORKDIR /app

# 3. jar file to contain
COPY target/*.jar app.jar

# port app runs on
EXPOSE 8080

# command to run
ENTRYPOINT ["java", "-jar", "app.jar"]