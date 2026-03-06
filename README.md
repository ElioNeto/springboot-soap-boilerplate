# Spring Boot SOAP Boilerplate

Boilerplate completo para criar serviços SOAP usando Java, Spring Boot e JAX-WS.

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.2.3
- Spring Web Services
- JAXB para binding XML
- Maven

## 📋 Pré-requisitos

- JDK 17 ou superior
- Maven 3.6+

## 🔧 Como usar

### 1. Clone o repositório
```bash
git clone https://github.com/ElioNeto/springboot-soap-boilerplate.git
cd springboot-soap-boilerplate
```

### 2. Compile o projeto
```bash
mvn clean install
```

### 3. Execute a aplicação
```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## 📚 Endpoints SOAP

### WSDL
Acesse o WSDL em: `http://localhost:8080/ws/users.wsdl`

### Exemplo de requisição

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

### Testando com cURL

```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml" \
  -d '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:user="http://example.com/soap/users"><soapenv:Header/><soapenv:Body><user:getUserRequest><user:id>1</user:id></user:getUserRequest></soapenv:Body></soapenv:Envelope>'
```

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/example/soap/
│   │       ├── Application.java              # Classe principal
│   │       ├── config/
│   │       │   └── WebServiceConfig.java     # Configuração SOAP
│   │       └── endpoint/
│   │           └── UserEndpoint.java         # Endpoint exemplo
│   └── resources/
│       ├── xsd/
│       │   └── users.xsd                     # Schema XSD
│       └── application.yml                    # Configurações
```

## 🛠️ Adicionando novos serviços

### 1. Crie um novo schema XSD
Adicione seu arquivo `.xsd` em `src/main/resources/xsd/`

### 2. Execute o Maven para gerar as classes
```bash
mvn clean compile
```
As classes Java serão geradas automaticamente em `target/generated-sources/jaxb/`

### 3. Crie um Endpoint
Crie uma classe anotada com `@Endpoint` e implemente os métodos com `@PayloadRoot`

### 4. Configure o WSDL
Adicione um bean no `WebServiceConfig.java` para expor o WSDL

## 📝 Licença

Este projeto está sob a licença MIT.

## 👤 Autor

**Elio Neto**
- GitHub: [@ElioNeto](https://github.com/ElioNeto)
