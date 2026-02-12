package maven_restassure67;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class primitive_auth {

    @Test
    public void testBasicAuth() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
         //   .auth().basic("postman", "password")   
        .when()
          //  .get("/basic-auth")
        .then()
            .statusCode(200)
           // .body("authenticated", equalTo(true))
            .log().all();
    }
}
