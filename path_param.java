package maven_restassure67;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class path_param {

    @Test
    void test_pathParam() {
        
        RestAssured.baseURI = "https://reqres.in/api";
        int userId = 2;
        given()
            .pathParam("id", userId)                 
           // .header("x-api-key", "reqres_bb1dd9be061542249d5e2021c45302b9")
        .when()
            .get("/users/{id}")                     
        .then()
            .statusCode(200)                        
            .body("data.id", equalTo(userId))        
            .log().all();                           
    }
}
