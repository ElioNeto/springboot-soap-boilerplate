# Spring Boot SOAP Boilerplate

Complete boilerplate for creating SOAP services using Java, Spring Boot, and JAX-WS.

## 🚀 Technologies

- Java 17
- Spring Boot 3.2.3
- Spring Web Services
- JAXB for XML binding
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
src/
├── main/
│   ├── java/
│   │   └── com/example/soap/
│   │       ├── Application.java              # Main class
│   │       ├── config/
│   │       │   └── WebServiceConfig.java     # SOAP configuration
│   │       └── endpoint/
│   │           └── UserEndpoint.java         # Sample endpoint
│   └── resources/
│       ├── xsd/
│       │   └── users.xsd                     # XSD schema
│       └── application.yml                    # Configuration
```

## 🛠️ Adding New Services

### 1. Create a new XSD schema
Add your `.xsd` file to `src/main/resources/xsd/`

### 2. Run Maven to generate classes
```bash
mvn clean compile
```
Java classes will be automatically generated in `target/generated-sources/jaxb/`

### 3. Create an Endpoint
Create a class annotated with `@Endpoint` and implement methods with `@PayloadRoot`

### 4. Configure the WSDL
Add a bean in `WebServiceConfig.java` to expose the WSDL

## 📝 License

This project is licensed under the MIT License.

## 👤 Author

**Elio Neto**
- GitHub: [@ElioNeto](https://github.com/ElioNeto)
