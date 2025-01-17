# **Test Automation Framework**

This project is a test automation framework built using **RestAssured**, **JUnit 5**, and **FreeMarker**. 
It is designed for API testing, with features like dynamic payload generation, reusable components, and centralized configuration.

---

## **Features**

- API testing using **RestAssured**.
- Modular structure with reusable components.
- Dynamic payload generation using **FreeMarker templates**.
- Centralized configuration via `config.properties`.
- Easy integration with CI/CD pipelines using **Gradle**.

---
## **Prerequisites**

Ensure you have the following installed:
1. **Java**: JDK 8 or higher
2. **Gradle**: Gradle Wrapper (`gradlew`) included

## **Setup and Installation**

1. **Setup**:
   ```bash
   ./gradlew build

2. **Run Test**:
    ```bash
   ./gradlew test