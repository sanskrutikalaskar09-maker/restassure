package maven_restassure67;

	import org.testng.annotations.Test;
	//import io.restassured.RestAssured;

	import static io.restassured.RestAssured.*;
	//import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

	public class rest_put {

	    @Test
	    void test_put() {
	    	JSONObject request = new JSONObject();
	    	request.put("name","rashi");
	    	request.put("Job","trainer");

	        given()
	            .header("Content-Type", "application/json")
	            //.header("x-api-key", "reqres_bb1dd9be061542249d5e2021c45302b9")
	            .body(request.toJSONString())
	        .when()
	            .put("https://reqres.in/api/users/2")
	        .then()
	            .statusCode(200) 
	            .log().all();
	    }
	}

