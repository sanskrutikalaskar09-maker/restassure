package maven_restassure67;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSON_TEST4 {
	@Test
	void  request1() {
	RequestSpecification http = RestAssured.given();
	//http.header("x-api-key","reqres_bb1dd9be061542249d5e2021c45302b9");
	http.baseUri("https://reqres.in/api");
	Response response = http.get("/user?page=2");
	
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	
	System.out.println(response.getStatusLine());
	System.out.println(response.getHeader("content-type"));
	
	int code = response.getStatusCode();
	Assert.assertEquals(code, 200);
}
}
