FROM azul/zulu-openjdk:8
ADD target/SpringBootJwtAuthentication-0.0.1.jar SpringBootJwtAuthentication-0.0.1.jar
COPY target/SpringBootJwtAuthentication-0.0.1.jar demo-be.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "demo-be.jar"]
