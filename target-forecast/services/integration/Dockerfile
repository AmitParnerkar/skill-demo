# Stage 1: Build the core module
FROM gradle:7.6.4-jdk17-noble	AS     build-core
COPY --chown=gradle:gradle . /home/gradle   
WORKDIR /home/gradle/core
RUN gradle clean && gradle build --no-daemon

# Stage 2: Build the integration module
FROM gradle:7.6.4-jdk17-noble	 AS     build-integration
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle/services/integration
RUN gradle clean && gradle build --no-daemon

# Stage 3: Build the final image
FROM amazoncorretto:17
RUN mkdir /app
WORKDIR /app
COPY --from=build-integration /home/gradle/services/integration/build/libs/integration-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
