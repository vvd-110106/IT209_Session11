# =======================================================
# Stage 1: Build stage (Gradle Build & Dependencies)
# =======================================================
FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app

# Copy gradle wrapper & configuration files first to leverage Docker layer caching
COPY gradlew settings.gradle build.gradle ./
COPY gradle/ gradle/

# Grant execution rights and pre-fetch dependencies
RUN chmod +x ./gradlew && ./gradlew dependencies --no-daemon || true

# Copy source code and build executable jar
COPY src/ src/
RUN ./gradlew bootJar --no-daemon || ./gradlew build -x test --no-daemon

# =======================================================
# Stage 2: Production Runtime stage (Lightweight Alpine)
# =======================================================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Run as non-root user for security best practice
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

# Copy jar from builder stage
COPY --from=builder --chown=appuser:appgroup /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
