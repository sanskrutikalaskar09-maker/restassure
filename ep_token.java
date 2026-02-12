package maven_restassure67;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ResponseOptions;

public class ep_token {
	@Test
	public void onr() {
		RestAssured.baseURI ="https://api.github.com";
	//	String ep ="";       fill the blank 
	//	 token = "";
		
		ResponseOptions res2 = (ResponseOptions) RestAssured
				.given().auth().oauth2(token)
				.get(ep).getBody();
		
		System.out.println(res2.toString());
	}

}
