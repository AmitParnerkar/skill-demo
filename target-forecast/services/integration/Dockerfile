FROM gradle:8.14.0-jdk21-noble	 AS     build
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
# Build the core module
RUN gradle :core:clean :core:build --no-daemon
# Build the Integration module
RUN gradle :services:integration:clean :services:integration:build --no-daemon

# Build the final image
FROM eclipse-temurin:21
RUN mkdir /app
WORKDIR /app
COPY --from=build /home/gradle/services/integration/build/libs/integration-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
