FROM java:8

WORKDIR /

ADD JavaDemo.jar JavaDemo.jar

EXPOSE 3306

CMD java - jar JavaDemo.jar
