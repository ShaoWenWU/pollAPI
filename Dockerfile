FROM java:8-jdk-alpine

COPY ./target/pollAPI-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch CodingChallenge-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","pollAPI-0.0.1-SNAPSHOT.jar"]
