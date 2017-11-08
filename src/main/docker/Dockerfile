FROM openjdk:8-jre-alpine
ADD kubernetes-hazelcast-*-jar-with-dependencies.jar /app.jar

EXPOSE 5701
EXPOSE 8080

ENV JAVA_OPTS -Xmx512m
ENV GROUP_NAME k8s
ENV GROUP_PASSWORD k8s

ENTRYPOINT exec java $JAVA_OPTS \
    -Djava.security.egd=file:/dev/./urandom \
    -Dgroup.name=$GROUP_NAME -Dgroup.password=$GROUP_PASSWORD \
    -jar /app.jar \
