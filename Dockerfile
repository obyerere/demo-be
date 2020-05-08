
FROM azul/zulu-openjdk:8
COPY target/*.jar demo-be.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "demo-be.jar"]
