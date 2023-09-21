FROM bitnami/java:17

EXPOSE 8080

WORKDIR /app

COPY /build/libs/spring-github-actions-demo-0.0.1-SNAPSHOT.jar /app/spring-github-actions-demo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "./spring-github-actions-demo-0.0.1-SNAPSHOT.jar"]
