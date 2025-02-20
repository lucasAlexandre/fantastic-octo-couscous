FROM maven:3.8.5-openjdk-17 AS build
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app
RUN mvn package

ENV AGE_MIN_VALUE=30
ENV STATES_TARGET=SP
ENV VALUATION_MAX_VALUE=100000
ENV VALUATION_MIN_VALUE=70000

ARG NODE_ENV

FROM eclipse-temurin:17-jdk
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/target/testeItau-0.0.1.jar app.jar
EXPOSE 8080

##ENTRYPOINT ["mvn"]
##CMD ["clean verify sonar:sonar -Dsonar.projectKey=fantastic-octo-couscous -Dsonar.projectName='fantastic-octo-couscous' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_49db0917f4e43445fe75f113e6bceceae471b853"]

CMD ["java", "-jar", "app.jar"]