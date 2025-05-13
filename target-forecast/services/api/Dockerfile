# Stage 1: Build the core module
FROM gradle:8.14.0-jdk21-noble	AS     build-core
COPY --chown=gradle:gradle . /home/gradle   
WORKDIR /home/gradle
RUN gradle :core:clean :core:build --no-daemon

# Stage 2: Build the API module
FROM gradle:8.14.0-jdk21-noble	 AS     build-api
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
RUN gradle :services:api:clean :services:api:build --no-daemon

# Stage 3: Build the final image
FROM eclipse-temurin:21
RUN mkdir /app
WORKDIR /app
COPY --from=build-api /home/gradle/services/api/build/libs/api-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
