package maven_restassure67;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
//import static org.hamcrest.Matchers.*;
public class json_rest2 {

	public class Get_test1 {

			@Test
			    void test_get() {
				RestAssured.baseURI="https://reqres.in/api";
				//given().header("x-api-key", "reqres_bb1dd9be061542249d5e2021c45302b9")
				.get("/users?page=2")
				.then().statusCode(200).log().all();
			}
		}


}
