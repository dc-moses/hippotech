FROM ubuntu:latest
RUN apt-get update
RUN apt-get install -y openjdk-11-jdk curl
COPY target/front.jar front.jar
ENTRYPOINT exec java $JAVA_OPTS -jar front.jar
