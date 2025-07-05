FROM gradle:8.7-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project

RUN gradle bootJar --no-daemon

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
