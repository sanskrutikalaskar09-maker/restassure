package maven_restassure67;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class non_primitive_auth {

    @Test
    public void testBearerTokenAuth() {
        RestAssured.baseURI = "https://reqres.in/api";

        given()
       // .header("x-api-key", "reqres_bb1dd9be061542249d5e2021c45302b9") 
        .when()
            .get("/users/2")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .log().all();
    }
}

