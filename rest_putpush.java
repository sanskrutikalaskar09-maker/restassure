package maven_restassure67;

	import org.testng.annotations.Test;
	import io.restassured.RestAssured;

	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

	public class rest_putpush {

	    @Test
	    void test_put() {
	        RestAssured.baseURI = "https://reqres.in/api";

	        // JSON body for updating a user
	        String requestBody = "{\n" +
	                "    \"name\": \"John\",\n" +
	                "    \"job\": \"Manager\"\n" +
	                "}";

	        given()
	            .header("Content-Type", "application/json")
	           // .header("x-api-key", "reqres_bb1dd9be061542249d5e2021c45302b9")
	            .body(requestBody)
	        .when()
	            .put("/users/2")
	        .then()
	            .statusCode(200) // OK
	            .body("name", equalTo("John"))
	            .body("job", equalTo("Manager"))
	            .log().all();
	    }
	}