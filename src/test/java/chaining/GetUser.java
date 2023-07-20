package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetUser {
	@Test
	public void getUser(ITestContext context) {
		
		//int id= (int)context.getAttribute("user_id");  // getting value at TEST level
		int id= (int)context.getSuite().getAttribute("user_id");
		baseURI="https://gorest.co.in";
		String token = "5043973439f36f4aa12d28148817ed79d7f54f2c1ff33372b7c4ecc4fd519275";
		given()
			.contentType(ContentType.JSON) 
			.accept(ContentType.JSON)
			.headers("Authorization","Bearer "+token)
			.pathParam("id", id)
		.when()
			.get("/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all()
		.extract().jsonPath().getInt("id");
		
		
	}
}
