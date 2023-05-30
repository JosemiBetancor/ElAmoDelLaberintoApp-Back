FROM openjdk
WORKDIR /app
COPY elAmoDelLaberinto-0.0.1.jar app.jar
EXPOSE 8083
CMD ["java","-jar","app.jar"]