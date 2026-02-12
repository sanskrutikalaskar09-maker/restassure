package maven_restassure67;

	import org.testng.annotations.Test;
	import io.restassured.RestAssured;

	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

	public class rest_post {

	    @Test
	    void test_post() {
	        // Step 1: Set Base URI
	        RestAssured.baseURI = "https://reqres.in/api";

	        // Step 2: Define request body (JSON)
	        String requestBody = "{\n" +
	                "    \"name\": \"John\",\n" +
	                "    \"job\": \"Developer\"\n" +
	                "}";

	        // Step 3: Send POST request
	        given()
	            .header("Content-Type", "application/json") // set header
	           // .header("x-api-key", "reqres_bb1dd9be061542249d5e2021c45302b9")
	            .body(requestBody)                          // attach JSON body
	        .when()
	            .post("/users")                             // endpoint for creating user
	        .then()
	            .statusCode(201)                            // validate response code
	            .body("name", equalTo("John"))              // validate response body
	            .body("job", equalTo("Developer"))
	            .log().all();                               // log full response
	    }
	}
	