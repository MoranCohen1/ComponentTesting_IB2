package authtechniques;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Bearertoken {
	@Test
	public void BearToken() {
		baseURI="https://api.github.com";
		String token = " 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";
		
		given()
			.headers("Authorization","Bearer "+token)
		.when()
		.get("/user/repos")
	
	.then()
		.statusCode(200)
		.log().all();
			
	}

}
