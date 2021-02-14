FROM ubuntu:latest
RUN apt-get update
RUN apt-get install -y openjdk-11-jdk curl
COPY target/approval.jar approval.jar
ENV JDBC_CONNECTION_STRING jdbc:h2:mem:demodb
ENTRYPOINT exec java $JAVA_OPTS -jar approval.jar
