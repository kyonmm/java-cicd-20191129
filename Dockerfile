FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
WORKDIR /opt/apps
ADD . /opt/apps
RUN ./gradlew shadowJar
EXPOSE 8080
CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar build/libs/something-0.1-all.jar