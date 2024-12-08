FROM maven:3.8.4-openjdk-17-slim AS build
COPY . /home/app/BACK-Agenda-de-Compromissos-ProgWeb-Final
RUN mvn -v
RUN mvn -f /home/app/BACK-Agenda-de-Compromissos-ProgWeb-Final/pom.xml clean package



FROM openjdk:17-slim
COPY --from=build /home/app/BACK-Agenda-de-Compromissos-ProgWeb-Final/target/*.jar /usr/local/lib/Agenda.jar
VOLUME /tmp
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/Agenda.jar"]