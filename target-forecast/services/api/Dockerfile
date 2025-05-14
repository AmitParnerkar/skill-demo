FROM gradle:8.14.0-jdk21-noble	 AS     build
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
# Build the core module
RUN gradle :core:clean :core:build --no-daemon
# Build the API module
RUN gradle :services:api:clean :services:api:build --no-daemon

# Build the final image
FROM eclipse-temurin:21
RUN mkdir /app
WORKDIR /app
COPY --from=build /home/gradle/services/api/build/libs/api-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
