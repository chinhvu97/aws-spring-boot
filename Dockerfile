FROM gradle:7.6.0-jdk17-alpine AS BUILD
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean bootJar --no-daemon

FROM openjdk:17-oracle
EXPOSE 8080

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]
