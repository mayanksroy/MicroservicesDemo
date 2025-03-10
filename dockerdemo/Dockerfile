FROM eclipse-temurin:19
LABEL maintainer="mayank@wipro.com"
WORKDIR /app
COPY target/dockerdemo-0.0.1-SNAPSHOT.jar /app/dockerdemo-demo.jar
ENTRYPOINT ["java","-jar","dockerdemo-demo.jar"]