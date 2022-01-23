package TestScript;

import org.testng.annotations.Test;

import com.genericUtils.BaseApiClass;
import com.genericUtils.EndPoints;
import com.genericUtils.JavaUtility;
import com.pojoLibrary.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class CreateAResource extends BaseApiClass{
	@Test
	public void create() throws Throwable {
		//create a random number
	    int ranNumber = jUtil.getRandomNumber();
	    String expectedProjectName="Wipro project"+ranNumber;
	    //pass the request body using pojo lobrary
		PojoLibrary pojo = new PojoLibrary("Adarsh", expectedProjectName, "completed", 300);
		Response response = given()
			.contentType(ContentType.JSON)
			.body(pojo)
		.when()
			.post(EndPoints.ADD_PROJECT);
		//data from reposne body
		String responseActualProjectName=jsonUtil.getJsonValueData(response, "projectName");
		response.then()
			.assertThat().contentType(ContentType.JSON)
			
			.statusCode(201)
			.log().all();
		
		//GUI verification
		
		//data base value verification
		String querry="select * from project";
		String dbActualProjectName = dbUtil.getAndVerifyTheData(querry, 4, expectedProjectName);
		//verifications
		Assert.assertEquals(responseActualProjectName, expectedProjectName);
		Assert.assertEquals(dbActualProjectName, expectedProjectName);
	}

}
