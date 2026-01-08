FROM maven:3.8.3-openjdk-17

    #Cria um env de nome jar_name com o nome do arquivo desafio-simplify-0.0.1-SNAPSHOT.jar.
ENV JAR_NAME desafio-simplify-0.0.1-SNAPSHOT.jar

    # Create destination directory
RUN mkdir /app

    # Copia o arquivo jar para a pasta /app e renomeia desafio-simplify-0.0.1-SNAPSHOT.jar para app.jar.
COPY /target/JAR_NAME /app/app.jar

    #Executa o .jar dentro da pasta app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "desafio-simplify-0.0.1-SNAPSHOT.jar"]