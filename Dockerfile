FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
WORKDIR /opt/apps
ADD . /opt/apps
RUN ./gradlew shadowJar
EXPOSE 8080
CMD java -Dcom.sun.management.jmxremote \
    -noverify ${JAVA_OPTS} \
    -Ddatasources.default.driverClassName="org.postgresql.Driver" \
    -Ddatasources.default.url="jdbc:postgresql://ec2-54-235-248-185.compute-1.amazonaws.com:5432/df8bucfjhjnfkt?user=hsgpxksecpdvju&password=a8960668cf744d197eb0e6901bcf5638c2c970271691c1be8aa4f7cf54546872" \
    -jar build/libs/something-0.1-all.jar