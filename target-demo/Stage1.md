# MARKUP
docker run \
    -it \
    -v $PWD:/home/gradle \
    -p 8080:8080 \
    gradle:7.6.4-jdk17-noble \
    bash