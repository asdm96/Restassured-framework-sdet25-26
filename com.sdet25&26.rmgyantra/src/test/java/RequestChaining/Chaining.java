package RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Chaining {
	@Test
	public void chain() {
		//get all the project and delete 
		//post and delete==>assignment
		
	Response response = when()
			.get("http://localhost:8084/projects");
	String proID=response.jsonPath().get("[0].projectId");
	
	given()
		.pathParam("projectId", proID)
	.when()
	 .delete("http://localhost:8084/projects/{projectId}")
	 .then()
	 .assertThat().statusCode(204)
	 .log().all();
	}

}
