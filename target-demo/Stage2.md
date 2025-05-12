docker run \
    -it \
    -v $PWD/build/libs:/app \
    -p 8080:8080 \
    -e SPRING_PROFILES_ACTIVE=docker \
    -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/products_db \
    -e SPRING_DATASOURCE_USERNAME=user \
    -e SPRING_DATASOURCE_PASSWORD=password \
    eclipse-temurin:21 \
    java -jar /app/target-demo-0.0.1-SNAPSHOT.jar


