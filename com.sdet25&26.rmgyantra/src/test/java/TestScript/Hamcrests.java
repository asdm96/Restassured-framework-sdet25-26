package TestScript;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;



public class Hamcrests {
	@Test
	public void testing() {
		when()
		 .get("http://localhost:8084/projects")
		.then()
			.assertThat().statusCode(200)
			.assertThat().time(Matchers.lessThan(1000L),TimeUnit.MILLISECONDS)
			.assertThat().body("[0].projectName", Matchers.equalTo("Tyss bangalore branch1675"))
			.log().all();
		
	}

}
