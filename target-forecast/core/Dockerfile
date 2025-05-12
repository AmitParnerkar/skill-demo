### Dockerfile for Target Service
### Build Stage 

# Use the official Gradle image as a build stage
# This image includes the Gradle build tool and JDK 17

FROM gradle:7.6.4-jdk17-noble AS build
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
RUN gradle clean
RUN gradle build --no-daemon

