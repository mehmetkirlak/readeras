FROM amazoncorretto:11 AS build

WORKDIR /app

COPY pom.xml /app/pom.xml
COPY .mvn /app/.mvn
COPY mvnw /app/mvnw
RUN ./mvnw dependency:resolve

COPY . .
RUN ./mvnw package -DskipTests

FROM amazoncorretto:11
WORKDIR readeras
ADD target/readeras-0.0.1-SNAPSHOT.jar readeras.jar
ENTRYPOINT ["java","-jar","readeras.jar"]


#COPY pom.xml .
#COPY .mvn .mvn
#COPY mvnw mvnw
#RUN ./mvnw dependency:resolve
#
#COPY src src
#
#FROM amazoncorretto:11.0.16
#WORKDIR readeras
#COPY --from=build target/readeras-0.0.1-SNAPSHOT.jar readeras-0.0.1.jar
#
#EXPOSE 8080