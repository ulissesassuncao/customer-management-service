FROM maven:3.8.2-openjdk-11-slim AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -f pom.xml clean package

RUN ls -la /app/target/

FROM adoptopenjdk/openjdk11:alpine

WORKDIR /app

RUN ls -la /app/

COPY --from=build /app/target/customer-management-service-0.0.1-SNAPSHOT.jar customer-management-service.jar

EXPOSE 8080

CMD ["java", "-jar", "customer-management-service.jar"]
