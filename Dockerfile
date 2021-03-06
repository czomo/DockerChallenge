FROM java:8

COPY ./mysql-connector-java-8.0.13.jar  /mysql-connector-java-8.0.13.jar

COPY ./JavaDemo.java /JavaDemo.java

COPY ./ss.sh /ss.sh

ENV CLASSPATH=/mysql-connector-java-8.0.13.jar:${CLASSPATH}

RUN chmod +x /ss.sh

ENTRYPOINT ["./ss.sh"]
