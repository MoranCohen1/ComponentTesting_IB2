package authtechniques;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class DigestAuth {
	
	@Test
	public void digestAuth() {
		baseURI = "https://postman-echo.com";
		
		given()
			.auth().digest("postman", "password")
		.when()
			.get("/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}

}
