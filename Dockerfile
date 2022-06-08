FROM gradle AS builder
WORKDIR /statisticalAnalysis/
COPY . .
RUN gradle build 


FROM openjdk:11-jdk-alpine
COPY --from=builder /statisticalAnalysis/build/libs/StatisticalAnalysis-0.0.1-SNAPSHOT.jar /bankruptcheck/StatisticalAnalysis-0.0.1-SNAPSHOT.jar
WORKDIR /statisticalAnalysis/
ENTRYPOINT ["java","-jar","StatisticalAnalysis-0.0.1-SNAPSHOT.jar"]
