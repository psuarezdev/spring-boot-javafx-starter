# Spring Boot JavaFX Starter

**Spring Boot JavaFX Starter** is a project designed to integrate JavaFX with Spring Boot, enabling developers to build modern desktop applications with the powerful backend capabilities of Spring Boot and the rich UI features of JavaFX. This template combines database connectivity, authentication, and desktop GUI development in one cohesive framework.

---

## Key Features:
- **JavaFX Integration**:
  - `javafx-controls`: Tools for building graphical user interfaces.
  - `javafx-fxml`: Simplified UI design with FXML support.

- **Spring Boot Starter Dependencies**:
  - `spring-boot-starter-data-jpa`: Simplified interaction with relational databases.
  - `spring-boot-starter-security`: Pre-configured authentication and security mechanisms.
  - `spring-boot-starter-validation`: Input validation for API endpoints.

- **Database Support**:
  - Out-of-the-box configuration for PostgreSQL (runtime dependency).

- **Development Tools**:
  - `lombok`: Boilerplate reduction for Java classes.

- **Testing**:
  - `spring-boot-starter-test` for comprehensive testing support.
  - `spring-security-test` for security-related testing.

---

## Configuration:
To run the project, you need to configure the application properties. Replace placeholders in the following file with your specific values:

```yaml
spring:
  application:
    name: spring-boot-javafx-starter
  datasource:
    url: jdbc:postgresql://localhost:5432/<db_name>
    username: <db_user>
    password: <db_passwd>
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update
```

### Add JavaFX Library  
- Navigate to: **Project Structure** > **Libraries** > **Add**  
- Select the folder for: `javafx-sdk-21.0.5`  
- Ensure the library is properly linked to avoid runtime errors. 

### Run the Program  
When executing the program, add the following VM options to ensure JavaFX modules are loaded:  

```shell
--module-path "javafx-sdk-21.0.5/lib" --add-modules javafx.controls,javafx.fxml
```

---

## Database Settings:
- Replace `<db_name>`, `<db_user>`, and `<db_passwd>` with your database name, username, and password.

---

## Technical Details:
- **Java Version**: 17
- **Build Tool**: Maven
- **Plugins**:
  - `maven-compiler-plugin` with annotation processing for Lombok.
  - `spring-boot-maven-plugin` for building and running Spring Boot applications.