package authtechniques;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class OAuth {
	@Test
	public void oAuth() {
		baseURI = "https://api.github.com";
		String token = " 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";
		
		given()
			.auth().oauth2(token)
		.when()
			.get("/user/repos")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
