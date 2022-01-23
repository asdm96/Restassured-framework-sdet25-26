package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BarierToken {
	@Test
	public void tokens() {
		//barier token
		//method==> auth() and Oauth2
		given()
			.auth().oauth2("ghp_EF2hXTqxQIulsvPky1yTWqpoLDYv3lM94Y")
		.when()
			.get("https://api.github.com/user/repos")
		.then().assertThat().statusCode(200)
		.log().all();
	}

}
