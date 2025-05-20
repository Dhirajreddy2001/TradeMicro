#JDK 
FROM openjdk:17-jdk-slim

# working directory
WORKDIR /app

# Copy JAR file from target to cntainer

COPY target/TAM-0.0.1-SNAPSHOT.jar app.jar

# EXPOSE 8080 port for app to run	
EXPOSE 8080

# Run JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
