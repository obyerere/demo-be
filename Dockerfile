
FROM azul/zulu-openjdk:8
ADD target/*.jar *.jar
COPY target/*.jar demo-be.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "demo-be.jar"]
