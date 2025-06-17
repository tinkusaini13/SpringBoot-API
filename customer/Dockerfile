# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jre

WORKDIR /app
# Set OpenTelemetry version
ENV OTEL_VERSION=1.32.0

# Download OpenTelemetry Java Agent
RUN curl -L https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v${OTEL_VERSION}/opentelemetry-javaagent.jar \
    -o opentelemetry-javaagent.jar
# Copy built jar from builder
COPY --from=builder /app/target/customer-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Set environment variables
ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://otel-collector.monitoring.svc.cluster.local:4318
ENV OTEL_EXPORTER_OTLP_PROTOCOL=http/protobuf
ENV OTEL_SERVICE_NAME=metrics-customer-service
ENV OTEL_TRACES_EXPORTER=otlp
ENV OTEL_LOGS_EXPORTER=otlp
ENV OTEL_METRICS_EXPORTER=otlp
ENV OTEL_PROPAGATORS=tracecontext,baggage
ENV OTEL_RESOURCE_ATTRIBUTES=deployment.environment=dev
ENV OTEL_RESOURCE_DETECTORS=env,host,os

ENTRYPOINT ["java", "-javaagent:opentelemetry-javaagent.jar", "-jar", "app.jar"]
