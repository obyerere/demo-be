FROM azul/zulu-openjdk:8
ADD target/demo-be-0.0.1.jar demo-be-0.0.1.jar
COPY target/demo-be-0.0.1.jar demo-be-0.0.1.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "demo-be-0.0.1.jar"]
