FROM openjdk:16.0-oraclelinux7

VOLUME /tmp

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]