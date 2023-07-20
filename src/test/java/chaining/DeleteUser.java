package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteUser {

	@Test
	public void deleteTest() {
		
		baseURI="https://reqres.in";
		
		String token = "24f0bc307d63349dcd1579cb64f2ec2269bb1c960f85ee4b3b92d8b3205790ff";
		given()
			.contentType(ContentType.JSON) 
			.accept(ContentType.JSON)
			.headers("Authorization","Bearer "+token)
		.when()
			.delete("/public/v2/users/2177")
		.then()
			.statusCode(204)
			.log().all();
		
	}
}
