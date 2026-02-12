package maven_restassure67;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class json_test6 {

    @Test
    void t() {
        RestAssured.baseURI = "https://reqres.in/api";

       // given().header("x-api-key", "reqres_bb1dd9be061542249d5e2021c45302b9")
       
            .get("/users?page=2")
        .then()
            .statusCode(200)
            .body("data[4].first_name", equalTo("George"))
            .body("data.first_name", hasItems("George", "Rachel")); 
    }
}

