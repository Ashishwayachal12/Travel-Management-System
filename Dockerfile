# Use an official OpenJDK runtime as base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy all project files into the container
COPY . /app

# Compile Java source files
RUN javac -d out $(find . -name "*.java")

# Expose no web port (Swing app runs locally, but included for structure)
EXPOSE 8080

# Set default command to run the main Java class
CMD ["java", "-cp", "out", "Splash"]
