FROM openjdk:11-jdk
COPY target/gerenciamento-de-trafego.jar gerenciamento-de-trafego.jar
ENTRYPOINT ["java", "-jar", "gerenciamento-de-trafego.jar"]
