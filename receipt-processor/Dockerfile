
FROM openjdk:11-jre-slim

WORKDIR /app

COPY build/libs/receipt-processor-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
