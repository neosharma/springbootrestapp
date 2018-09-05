FROM openjdk:8
ADD target/myrestapp-0.0.1-SNAPSHOT.jar myrestapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=container","-jar","myrestapp.jar"]