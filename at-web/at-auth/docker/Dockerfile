FROM openjdk:8-jre-alpine
MAINTAINER atai2 <1114677814@qq.com>

COPY ../target/at-auth-0.0.1-SNAPSHOT.jar /opt/at-auth-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/opt/at-auth-0.0.1-SNAPSHOT.jar"]
EXPOSE 9000