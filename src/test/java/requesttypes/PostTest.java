package requesttypes;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostTest {
	@Test
	public void postTest() {
		
		JSONObject jo = new  JSONObject();
		jo.put("name", "John");
		jo.put("job", "Dev");
		
		System.out.println(jo.toJSONString());
		
		baseURI="https://reqres.in";
		given()
			.contentType(ContentType.JSON) //OR .accept(ContentType.JSON)
			.body(jo.toJSONString())
		.when()
			.post("/api/users")
		.then()
		.statusCode(201)
		.log().all();
	}

	@Test
	public void postTestBDD() {
		JSONObject jo = new  JSONObject();
		jo.put("name", "John");
		
		baseURI="https://reqres.in";
		given()
			.contentType(ContentType.JSON) //OR .accept(ContentType.JSON)
			.body(jo.toJSONString())
		.when()
			.get("/api/users")
		.then()
		.statusCode(201)
		.body("name", equalTo("John")) 
		//.body("data.first_name", hasItems("Rachel","Tobias"))  //validate multipule data that we don't know the specific path
		
		.log().all();
	}
	

}
