docker run \
    -it \
    -v $HOME/Clients/spinach/code/skill-demo/target-forecast:/home/gradle \
    -p 8082:8080 \
    eclipse-temurin:21 \
    bash