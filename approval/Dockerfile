FROM ubuntu:latest
RUN apt-get update
RUN apt-get install -y openjdk-11-jdk
COPY target/approval.jar approval.jar
CMD ["java", "-jar", "approval.jar"]