package maven_restassure67;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class specific_builder {

    RequestSpecification requestSpec;

    @BeforeClass
    public void setup() {
        // Build a reusable request specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
              //  .addHeader("Content-Type", "application/json")
                .build();

        // Assign it globally if you want
        RestAssured.requestSpecification = requestSpec;
    }

    @Test
    public void testGetUser() {
        given()
            .spec(requestSpec)              // use the spec
            //.header("x-api-key", "reqres_bb1dd9be061542249d5e2021c45302b9")
        .when()
            .get("/users/2")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .log().all();
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"John\", \"job\": \"Developer\" }";

        given()
            .spec(requestSpec)              // use the spec
            .body(requestBody)
            //.header("x-api-key", "reqres_bb1dd9be061542249d5e2021c45302b9")
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("John"))
            .log().all();
    }
}
