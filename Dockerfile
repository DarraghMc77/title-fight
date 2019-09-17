FROM java:8-jre

ADD target/title-fight-1.0-SNAPSHOT.jar title-fight-1.0-SNAPSHOT.jar

ADD config.yml config.yml

CMD java -jar title-fight-1.0-SNAPSHOT.jar server config.yml

EXPOSE 8080

EXPOSE 8081
