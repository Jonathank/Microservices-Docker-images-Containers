# start with q base image containing java runtime
FROM openjdk:17-jdk-slim

# Informator about the maintainer of this image
MAINTAINER thanjk 

#Add the application's jar to the image'
COPY target/Accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]
