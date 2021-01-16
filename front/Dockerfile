FROM ubuntu:latest
RUN apt-get update
RUN apt-get install -y openjdk-11-jdk
COPY target/front.jar front.jar
CMD ["java", "-jar", "front.jar"]