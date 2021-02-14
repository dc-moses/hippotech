FROM ubuntu:latest
RUN apt-get update
RUN apt-get install -y openjdk-11-jdk curl
COPY target/demo.jar demo.jar
ENTRYPOINT exec java $JAVA_OPTS -jar demo.jar
