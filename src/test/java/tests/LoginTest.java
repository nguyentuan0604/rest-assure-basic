package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utils.TemplateUtils;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredential() {
        // Define data for the template
        Map<String, Object> data = new HashMap<>();
        data.put("username", "QaAdminUser");
        data.put("password", "myPassword");

        // Generate payload using FreeMarker
        String payload = TemplateUtils.generatePayload("login_payload.ftl", data);

        // Send the request
        Response response = requestSpec
                .body(payload)
                .when()
                .post("/login")
                .then()
                .statusCode(200)  // Expected success status code
                .body("message", equalTo("Login successful")) // Validate response message
                .body("token", notNullValue()) // Ensure token is returned
                .extract()
                .response();

        System.out.println("Response: " + response.asString());
    }

    @Test
    public void testLoginWithInvalidCredential() {
        // Define data for the template
        Map<String, Object> data = new HashMap<>();
        data.put("username", "wrongUser");
        data.put("password", "wrongPassword");

        // Generate payload using FreeMarker
        String payload = TemplateUtils.generatePayload("login_payload.ftl", data);

        // Send the request
        Response response = requestSpec
                .body(payload)
                .when()
                .post("/login")
                .then()
                .statusCode(401)  // Expected failure status code
                .body("message", equalTo("Invalid credentials")) // Validate error message
                .extract()
                .response();

        System.out.println("Response: " + response.asString());
    }
}
