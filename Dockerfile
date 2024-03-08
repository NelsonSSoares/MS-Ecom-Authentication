FROM openjdk:17
WORKDIR /app
COPY ./target/EcomProductsApi-0.0.1-SNAPSHOT.jar ms-ecom-securitygateway.jar
EXPOSE 8761
ENTRYPOINT java -jar ms-ecom-securitygateway.jar
