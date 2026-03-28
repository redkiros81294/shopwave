# se4801-assignment1-ATE-7702-14

## Student Information

- **Name**: Yared Kiros
- **Student Number**: ATE/7702/14

![Java Version](https://img.shields.io/badge/Java-21-blue)
![Spring Boot Version](https://img.shields.io/badge/Spring%20Boot-3.5.12-blue)
![Maven](https://img.shields.io/badge/Maven-3.x-blue)
![H2 Database](https://img.shields.io/badge/Database-H2-green)

## Project Overview

se4801-assignment1-ATE-7702-14 is a production-ready Java Spring Boot application designed as an e-commerce platform foundation. It provides a robust REST API for product management with comprehensive entity relationships, service layer business logic, and proper error handling. The project follows enterprise-grade coding standards with SOLID principles, clean architecture patterns, and extensive test coverage across multiple layers.

## Technology Stack

| Component | Version | Description |
|-----------|---------|-------------|
| Java | 21 | Primary programming language |
| Spring Boot | 3.5.12 | Application framework |
| Spring Data JPA | 3.5.12 | Data access layer |
| Hibernate | 6.4.x | ORM implementation |
| H2 Database | 2.x | In-memory database for development |
| Lombok | 1.18.x | Code generation via annotations |
| Maven | 3.x | Build tool with wrapper |

### Dependencies

- `spring-boot-starter-web` - REST API development
- `spring-boot-starter-data-jpa` - JPA/Hibernate integration
- `spring-boot-starter-validation` - Request validation
- `spring-boot-starter-actuator` - Application monitoring
- `h2` - In-memory database
- `lombok` - Reduced boilerplate code
- `spring-boot-starter-test` - Testing framework

## Prerequisites and Installation

### Requirements

- Java Development Kit (JDK) 21 or higher
- Maven 3.x (or use the included Maven wrapper)

### Installation

1. Clone the repository or extract the project archive
2. Navigate to the project root directory:
   ```bash
   cd se4801-assignment1-ATE-7702-14
   ```
3. Build the project using Maven wrapper:
   ```bash
   ./mvnw clean install
   ```

## Build and Run Commands

### Run the Application

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

### Build for Production

```bash
./mvnw clean package
```

The executable JAR will be generated in the `target/` directory.

### Run Tests

```bash
./mvnw test
```

### Additional Commands

- **Compile without tests**: `./mvnw compile`
- **Skip tests during build**: `./mvnw clean package -DskipTests`
- **View test reports**: `./mvnw surefire-report:report`

### Access H2 Console

When running with `spring.h2.console.enabled=true` (default), access:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (empty)

## Project Structure

```
se4801-assignment1-ATE-7702-14/
├── src/main/
│   ├── java/com/shopwave/
│   │   ├── controller/         # REST API controllers
│   │   │   └── ProductController.java
│   │   ├── dto/               # Data Transfer Objects
│   │   │   ├── CreateProductRequest.java
│   │   │   └── ProductDTO.java
│   │   ├── enums/             # Enumeration types
│   │   │   └── OrderStatus.java
│   │   ├── exception/         # Custom exceptions
│   │   │   ├── GlobalExceptionHandler.java
│   │   │   └── ProductNotFoundException.java
│   │   ├── mapper/            # Object mappers
│   │   │   └── ProductMapper.java
│   │   ├── model/             # Entity classes
│   │   │   ├── Category.java
│   │   │   ├── Order.java
│   │   │   ├── OrderItem.java
│   │   │   └── Product.java
│   │   ├── repository/        # Data repositories
│   │   │   ├── CategoryRepository.java
│   │   │   └── ProductRepository.java
│   │   ├── service/           # Business logic services
│   │   │   └── ProductService.java
│   │   └── shopwavestarter/   # Application entry point
│   │       └── ShopwaveStarterApplication.java
│   └── resources/
│       └── application.properties
├── src/test/
│   ├── java/com/shopwave/
│   │   ├── ProductControllerTest.java     # Controller unit tests
│   │   ├── ProductRepositoryTest.java     # Repository integration tests
│   │   ├── ProductServiceTest.java        # Service unit tests
│   │   └── shopwavestarter/
│   │       └── ShopwaveStarterApplicationTests.java  # Context load test
│   ├── resources/
│   │   ├── application.properties        # Test configuration
│   │   └── application-test.properties   # Test-specific properties
│   └── TestSuiteDocumentation.md         # Test suite documentation
└── pom.xml
```

### Layer Architecture

- **Model Layer**: Entity classes with JPA annotations defining database schema
- **Repository Layer**: Spring Data JPA interfaces for data access
- **Service Layer**: Business logic with transactional support
- **Controller Layer**: REST endpoints with request/response handling
- **DTO Layer**: Data transfer objects for API communication
- **Exception Layer**: Centralized error handling with global exception handler

## Configuration Documentation

### Application Properties

The main configuration file is located at `src/main/resources/application.properties`:

```properties
server.port=8080
app.name=ShopWave
spring.h2.console.enabled=true
```

### Configuration Properties

| Property | Default | Description |
|----------|---------|-------------|
| `server.port` | 8080 | HTTP server port |
| `app.name` | ShopWave | Application name |
| `spring.h2.console.enabled` | true | Enable H2 web console |
| `spring.jpa.hibernate.ddl-auto` | create-drop | Schema generation mode |
| `spring.jpa.show-sql` | false | Enable SQL logging |

### Database Configuration

The project uses H2 in-memory database configured for development:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

## REST API Endpoints

### Product Management

| Method | Endpoint | Description |
|--------|-----------|-------------|
| GET | `/api/products` | Get all products (paginated) |
| GET | `/api/products/{id}` | Get product by ID |
| POST | `/api/products` | Create new product |
| GET | `/api/products/search` | Search products |
| PATCH | `/api/products/{id}/stock` | Update product stock |

### Example Request: Create Product

```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop Pro",
    "desc": "High-performance laptop",
    "price": 1299.99,
    "stock": 50,
    "categoryId": 1
  }'
```

## AI-Powered Development

This project was developed with the assistance of advanced AI tools that significantly enhanced code quality, debugging capabilities, and adherence to enterprise development principles.

### AI Tools and Technologies

**MinMax M2.5** served as the primary AI model, providing intelligent code analysis, architecture recommendations, and implementation guidance throughout the development lifecycle. The model demonstrated exceptional capability in understanding complex Spring Boot patterns, JPA entity relationships, and RESTful API design principles.

**KiloCode VSCode Extension** acted as the agent-based AI assistant, enabling seamless integration of AI capabilities directly into the development environment. This combination facilitated real-time code suggestions, intelligent error detection, and automated refactoring opportunities.

### Debugging and Error Resolution

The AI tools played a crucial role in identifying and resolving issues during development:

- **Compilation Error Resolution**: The AI assistant detected and corrected naming inconsistencies across entity classes, DTOs, and test files. This included synchronizing field names between Product entity and ProductDTO to ensure proper data mapping.

- **Test Infrastructure Debugging**: When @DataJpaTest encountered context loading failures, the AI analyzed Spring Boot's auto-configuration reports and identified conflicts between Flyway auto-configuration and the H2 in-memory database. The solution involved creating specialized test configurations that explicitly disable conflicting auto-configurations.

- **Build Configuration Optimization**: The AI recommended and implemented proper annotation processor paths in pom.xml to ensure Lombok's code generation works correctly during compilation.

### SOLID Principles Verification

The code was continuously evaluated against SOLID principles:

- **Single Responsibility (S)**: Each class has a distinct purpose—ProductService handles business logic, ProductController manages HTTP requests, ProductRepository provides data access.

- **Open/Closed (O)**: Entities use builder patterns allowing extension without modification. The GlobalExceptionHandler can be extended with new exception types without changing existing code.

- **Liskov Substitution (L)**: Repository interfaces extend Spring Data's JpaRepository, ensuring all CRUD methods work consistently across any JPA implementation.

- **Interface Segregation (D)**: DTOs are focused on specific use cases—CreateProductRequest for input, ProductDTO for output—avoiding bloated interfaces.

- **Dependency Inversion (D)**: Services depend on repository interfaces, not concrete implementations, allowing for easy mocking in tests and future implementation changes.

### Enterprise Application Development

The AI-assisted development ensured production-ready code through:

- **Proper Transaction Management**: All service methods use @Transactional annotations with appropriate read-only settings for query operations.

- **Validation Layer**: Request validation using Jakarta Bean Validation annotations (@NotBlank, @DecimalMin, @Min) ensures data integrity at the API boundary.

- **Exception Handling**: A centralized GlobalExceptionHandler provides consistent error responses with appropriate HTTP status codes.

- **Security Considerations**: Input sanitization through validation annotations prevents common injection attacks.

- **Performance Optimization**: Lazy loading strategies and efficient database queries through Spring Data JPA method derivation.

This comprehensive approach ensures that shopwaveStarter meets enterprise standards for maintainability, scalability, and reliability.

