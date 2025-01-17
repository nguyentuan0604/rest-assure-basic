package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import utils.ConfigUtils;

public class BaseTest {

    protected static RequestSpecification requestSpec;

    @BeforeAll
    public static void setup() {
        // Set the base URI from the config file
        RestAssured.baseURI = ConfigUtils.getProperty("baseURI");

        // Initialize RequestSpecification
        requestSpec = RestAssured.given()
                .contentType("application/json")
                .header("Accept", "application/json");
    }
}
