package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuthAuthentication {
	@Test
	public void auth2() {
		Response response = given()
			.formParam("client_id", "sdet25&26")
			.formParam("client_secret", "bf8915f7c16293378adc24b31df6f1b3")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		String token = response.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", "1951")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
		.then()
			.log().all();
	}

}
