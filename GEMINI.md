# Taco Cloud - Project Overview

Taco Cloud is a Spring Boot application developed as an example for ordering custom tacos. It provides a web interface for customers to select ingredients, design their tacos, and place orders.

## Tech Stack
- **Framework:** Spring Boot 4.0.3
- **Language:** Java 21
- **Templating:** Thymeleaf
- **Boilerplate Reduction:** Lombok
- **Build Tool:** Maven (using Maven Wrapper)

## Architecture
The project follows a standard Spring Boot MVC architecture:
- **`sia.taco_cloud.domain`**: Contains domain entities like `Ingredient`, `Taco`, and `TacoOrder`.
- **`sia.taco_cloud.controllers`**: Contains Spring MVC controllers for handling web requests.
- **`src/main/resources/templates`**: Contains Thymeleaf templates for the UI.
- **`src/main/resources/static`**: Contains static assets like images.

## Building and Running

### Prerequisites
- Java 21
- Internet connection (to download dependencies)

### Key Commands
- **Run the application:**
  ```bash
  ./mvnw spring-boot:run
  ```
- **Run tests:**
  ```bash
  ./mvnw test
  ```
- **Package the application:**
  ```bash
  ./mvnw package
  ```

## Development Conventions

### Coding Style
- **Lombok:** Use `@Data` for domain objects to automatically generate getters, setters, `toString`, `equals`, and `hashCode` methods.
- **Logging:** Use `@Slf4j` for logging within controllers or services.

### Testing
- **Unit/Integration Testing:** Use JUnit 5 and Spring Boot's testing support.
- **Web Testing:** Use `@WebMvcTest` and `MockMvc` for testing controllers in isolation.

### Project Structure
- Follow standard Maven directory layout.
- Use package-based grouping for controllers and domain objects.

## Key Files
- `pom.xml`: Project dependencies and build configuration.
- `TacoCloudApplication.java`: Main entry point for the Spring Boot application.
- `DesignTacoController.java`: Main controller for the taco design page.
- `TacoOrder.java`: Domain object representing a customer order.
- `Ingredient.java`: Domain object representing taco ingredients.
