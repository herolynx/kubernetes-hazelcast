FROM openjdk:8-jre-alpine
ADD kubernetes-hazelcast-*-jar-with-dependencies.jar /app.jar

EXPOSE 5701
EXPOSE 8080

ENV JAVA_OPTS -Xmx512m

ENTRYPOINT exec java $JAVA_OPTS \
    -Djava.security.egd=file:/dev/./urandom \
    -jar /app.jar \
