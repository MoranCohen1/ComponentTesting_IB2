package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateUser {

	@Test
	public void updateUser() {
		
		JSONObject jo = new JSONObject();
		jo.put("name","Allasani Peddana");
		jo.put("email","allasani.peddana@15ce.com");
		jo.put("status","active");
		
		baseURI="https://gorest.co.in";
		String token = " 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";
		given()
			.contentType(ContentType.JSON) 
			.accept(ContentType.JSON)
			.headers("Authorization","Bearer "+token)
		.when()
			.patch("/public/v2/users/2177")
		.then()
		.statusCode(200)
		.log().all();
	}
}
