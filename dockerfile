FROM maven:3.8.3-openjdk-17

  # Create destination directory
RUN mkdir /app

  # Bundle app source
COPY /target/desafio-simplify-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=prod", "/app/app.jar"]