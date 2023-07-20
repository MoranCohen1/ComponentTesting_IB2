package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class CreateUser {

	@Test
	public void createUser(ITestContext context) {
		
		Faker faker = new Faker();
		JSONObject jo = new JSONObject();
		jo.put("name",faker.name().fullName());
		jo.put("gender","male");
		jo.put("email",faker.internet().emailAddress());
		jo.put("status","inactive");
		
		baseURI="https://gorest.co.in";
		String token = "5043973439f36f4aa12d28148817ed79d7f54f2c1ff33372b7c4ecc4fd519275";
		int id =given()
			.contentType(ContentType.JSON) 
			.accept(ContentType.JSON)
			.headers("Authorization","Bearer "+token)
			.body(jo.toJSONString())
		.when()
			.post("/public/v2/users")
		.then()
		.statusCode(201)
		.log().all()
		.extract().jsonPath().getInt("id");
		
		System.out.println("Created user id is :"+ id);
		//context.setAttribute("user_id",id); // This variable is set at TEST level
		context.getSuite().setAttribute("user_id", id); // This variable is set at SUITE level
		
	}
}
