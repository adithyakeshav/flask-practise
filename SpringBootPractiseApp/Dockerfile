FROM openjdk:11.0.14.1-oracle
COPY target/product_web_app.jar /app.jar
COPY src/main/resources/appconfig.conf /config.conf
ENTRYPOINT ["java","-jar","/app.jar", "/config.conf"]