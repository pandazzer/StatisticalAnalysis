FROM gradle AS builder
WORKDIR /statisticalAnalysis/
COPY . .
RUN gradle build 


FROM hirokimatsumoto/alpine-openjdk-11:latest
COPY --from=builder /statisticalAnalysis/build/libs/StatisticalAnalysis-0.0.1-SNAPSHOT.jar /statisticalAnalysis/StatisticalAnalysis-0.0.1-SNAPSHOT.jar
COPY --from=builder /statisticalAnalysis/src/main/resources/songs_normalize.csv /statisticalAnalysis/src/main/resources/songs_normalize.csv
WORKDIR /statisticalAnalysis/
ENTRYPOINT ["java","-jar","StatisticalAnalysis-0.0.1-SNAPSHOT.jar"]
