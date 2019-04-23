FROM openjdk:8-jdk-alpine

RUN apk update && apk add bash

RUN mkdir -p /yacht/app

ENV YACHT_HOME /yacht/app

COPY /target/mostdev-api-0.0.1.jar $YACHT_HOME/mostdev-api.jar

WORKDIR $YACHT_HOME

ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mostdev-mongo:27017/mostdev-apps", "-Djava.security.egd=file:/dev/./urandom", "-jar", "mostdev-api.jar"]