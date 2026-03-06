# Spring Boot SOAP Service - Clean Architecture

Complete SOAP service boilerplate following Clean Architecture principles with Java, Spring Boot, and JAX-WS.

## 🏛️ Architecture

This project follows Clean Architecture with clear separation of concerns:

```
┌────────────────────────────────────────────┐
│          Infrastructure Layer            │
│   (SOAP Adapters, Persistence, Config)   │
└─────────────┬──────────────────────────────┘
             │
┌─────────────┴──────────────────────────────┐
│         Application Layer              │
│        (Use Cases / Services)          │
└─────────────┬──────────────────────────────┘
             │
┌─────────────┴──────────────────────────────┐
│           Domain Layer                │
│  (Entities, Ports, Business Logic)   │
└────────────────────────────────────────────┘
```

### Layers

**Domain Layer** (innermost)
- Entities: Core business objects (`User`)
- Ports: Interfaces defining contracts (`GetUserUseCase`, `UserRepositoryPort`)
- Exceptions: Domain-specific exceptions
- No dependencies on outer layers

**Application Layer**
- Use Cases: Business logic implementation (`GetUserUseCaseImpl`)
- Orchestrates domain objects
- Depends only on domain layer

**Infrastructure Layer** (outermost)
- Input Adapters: SOAP endpoints (`UserSoapEndpoint`)
- Output Adapters: Repositories (`InMemoryUserRepository`)
- Configuration: Spring configuration classes
- Depends on application and domain layers

## 🚀 Technologies

- Java 17
- Spring Boot 3.2.3
- Spring Web Services
- JAXB for XML binding
- Lombok
- Maven

## 📋 Prerequisites

- JDK 17 or higher
- Maven 3.6+

## 🔧 How to Use

### 1. Clone the repository
```bash
git clone https://github.com/ElioNeto/springboot-soap-boilerplate.git
cd springboot-soap-boilerplate
```

### 2. Build the project
```bash
mvn clean install
```

### 3. Run the application
```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## 📚 SOAP Endpoints

### WSDL
Access the WSDL at: `http://localhost:8080/ws/users.wsdl`

### Sample Request

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:user="http://example.com/soap/users">
   <soapenv:Header/>
   <soapenv:Body>
      <user:getUserRequest>
         <user:id>1</user:id>
      </user:getUserRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Testing with cURL

```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml" \
  -d '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://example.com/soap/users"><soapenv:Header/><soapenv:Body><user:getUserRequest><user:id>1</user:id></user:getUserRequest></soapenv:Body></soapenv:Envelope>'
```

## 📁 Project Structure

```
src/main/java/com/example/soap/
├── domain/                           # Domain Layer (Core)
│   ├── entity/
│   │   └── User.java                 # Domain entity
│   ├── exception/
│   │   └── UserNotFoundException.java
│   └── port/
│       ├── input/
│       │   └── GetUserUseCase.java   # Input port (use case interface)
│       └── output/
│           └── UserRepositoryPort.java # Output port (repository interface)
│
├── application/                      # Application Layer
│   └── usecase/
│       └── GetUserUseCaseImpl.java   # Use case implementation
│
└── infrastructure/                   # Infrastructure Layer
    ├── adapter/
    │   ├── input/
    │   │   └── soap/
    │   │       └── UserSoapEndpoint.java # SOAP adapter
    │   └── output/
    │       └── persistence/
    │           └── InMemoryUserRepository.java # Repository implementation
    └── config/
        └── WebServiceConfig.java     # Spring WS configuration
```

## 🛠️ Adding New Features

### 1. Create Domain Entity
```java
// domain/entity/YourEntity.java
public class YourEntity {
    // Business logic and data
}
```

### 2. Define Ports
```java
// domain/port/input/YourUseCase.java
public interface YourUseCase {
    Result execute(Input input);
}

// domain/port/output/YourRepositoryPort.java
public interface YourRepositoryPort {
    Optional<Entity> findById(Long id);
}
```

### 3. Implement Use Case
```java
// application/usecase/YourUseCaseImpl.java
@Service
public class YourUseCaseImpl implements YourUseCase {
    // Business logic implementation
}
```

### 4. Create Adapters
```java
// infrastructure/adapter/input/soap/YourSoapEndpoint.java
@Endpoint
public class YourSoapEndpoint {
    // SOAP endpoint implementation
}

// infrastructure/adapter/output/persistence/YourRepository.java
@Repository
public class YourRepository implements YourRepositoryPort {
    // Persistence implementation
}
```

### 5. Add XSD Schema
Create your `.xsd` file in `src/main/resources/xsd/` and run:
```bash
mvn clean compile
```

## 🎯 Clean Architecture Benefits

- **Independence**: Business logic is independent of frameworks, UI, and databases
- **Testability**: Easy to unit test business rules without external dependencies
- **Flexibility**: Easy to swap implementations (e.g., change from in-memory to database)
- **Maintainability**: Clear separation of concerns makes code easier to understand and modify
- **Scalability**: Well-organized structure supports growth

## 📝 License

This project is licensed under the MIT License.

## 👤 Author

**Elio Neto**
- GitHub: [@ElioNeto](https://github.com/ElioNeto)
