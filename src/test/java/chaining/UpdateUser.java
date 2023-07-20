package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import com.github.javafaker.Faker;

public class UpdateUser {

	@Test
	public void updateUser(ITestContext context) {
		
		Faker faker = new Faker();
		JSONObject jo = new JSONObject();
		jo.put("name",faker.name().fullName());
		jo.put("email",faker.internet().emailAddress());
		jo.put("status","active");
		
		int id= (int)context.getSuite().getAttribute("user_id");
		baseURI="https://gorest.co.in";
		String token = "5043973439f36f4aa12d28148817ed79d7f54f2c1ff33372b7c4ecc4fd519275";
		given()
			.contentType(ContentType.JSON) 
			.accept(ContentType.JSON)
			.headers("Authorization","Bearer "+token)
			.pathParam("id", id)
		.when()
			.patch("/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
	}
}
