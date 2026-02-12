package maven_restassure67;

	import org.testng.annotations.Test;
	import io.restassured.RestAssured;

	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

	public class rest_patch {

	    @Test
	    void test_patch() {
	        // Step 1: Set Base URI
	        RestAssured.baseURI = "https://reqres.in/api";

	        // Step 2: Define request body (only updating job field)
	        String requestBody = "{\n" +
	                "    \"job\": \"Senior Developer\"\n" +
	                "}";

	        // Step 3: Send PATCH request
	        given()
	            .header("Content-Type", "application/json") // set header
	            //.header("x-api-key", "reqres_bb1dd9be061542249d5e2021c45302b9")
	            .body(requestBody)                          // attach JSON body
	        .when()
	            .patch("/users/2")                          // endpoint for partial update
	        .then()
	            .statusCode(200)                            // validate response code
	            .body("job", equalTo("Senior Developer"))   // validate updated field
	            .log().all();                               // log full response
	    }
	}

