### Dockerfile for Target Service
### Build Stage 

# Use the official Gradle image as a build stage
# This image includes the Gradle build tool and JDK 17
FROM gradle:7.6.4-jdk17-noble AS build
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
RUN gradle clean
RUN gradle build --no-daemon



# Use the official Amazon Corretto image as a base for the production image
# This image includes the Amazon Corretto JDK 17
### Production run image
FROM amazoncorretto:17
RUN mkdir /app
WORKDIR /app
COPY --from=build /home/gradle/build/libs/target-demo-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]