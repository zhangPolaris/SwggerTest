FROM kdvolder/jdk8
VOLUME /tmp
ADD target/demo.jar app.jar
#RUN bash -c 'touch /app.jar'
EXPOSE 8001
ENTRYPOINT ["java","-jar","/app.jar"]
