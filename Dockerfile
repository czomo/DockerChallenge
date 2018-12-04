FROM java:8

COPY ./mysql-connector-java-8.0.13.jar  /mysql-connector-java-8.0.13.jar

COPY ./JavaDemo.java /JavaDemo.java

WORKDIR /

RUN javac JavaDemo.java

CMD ["java", "-classpath", "mysql-connector-java-8.0.13.jar:.","JavaDemo"]

