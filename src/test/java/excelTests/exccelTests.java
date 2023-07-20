package excelTests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class exccelTests {
	@Test
	public void test1() {
		
		JSONObject jo = new  JSONObject();
		jo.put("name", "morpheus");
		jo.put("job", "leader");
		
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
	public void test2() {
		
		JSONObject jo = new  JSONObject();
		
		jo.put("job", "leader");
		
		System.out.println(jo.toJSONString());
		
		baseURI="https://reqres.in";
		given()
			.contentType(ContentType.JSON) //OR .accept(ContentType.JSON)
			.body(jo.toJSONString())
		.when()
			.post("/api/users")
		.then()
		.statusCode(403)
		.log().all();
	}
	
	@Test
	public void test3() {
		
		JSONObject jo = new  JSONObject();
		jo.put("name", "mmmmmmmmmmkkkkkkkkkkffffffffffttt");
		jo.put("job", "leader");
		
		System.out.println(jo.toJSONString());
		
		baseURI="https://reqres.in";
		given()
			.contentType(ContentType.JSON) //OR .accept(ContentType.JSON)
			.body(jo.toJSONString())
		.when()
			.post("/api/users")
		.then()
		.statusCode(403)
		.log().all();
	}
	
	@Test
	public void test4() {
		
		JSONObject jo = new  JSONObject();
		jo.put("name", "mmmmmmmmmmkkkkkkkkkkfffffffffftt");
		jo.put("job", "leader");
		
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
	public void test5() {
		
		JSONObject jo = new  JSONObject();
		jo.put("name", "mmm");
		jo.put("job", "leader");
		
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
}
