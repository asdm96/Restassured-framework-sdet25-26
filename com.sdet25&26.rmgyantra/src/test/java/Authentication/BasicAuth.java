package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuth {
	@Test
	public void basic() {
		//basic auth
		//method==> auth() and basic()
		given()
			.auth().basic("rmgyantra", "rmgy@9999")
		.when()
		 .get("http://localhost:8084")
		.then()
		.assertThat().statusCode(202)
		.log().all();
	}

}
