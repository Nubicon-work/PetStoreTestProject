package api.user.create;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.PetStoreAPIResponse;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class CreateUserWithoutBodyNegativeTest {

    @Test(groups = "user")
    public void createUserWithoutBodyNegativeTest() {
        PetStoreAPIResponse response = given()
                .when().contentType(ContentType.JSON)
                .post(Constants.baseUrl + "user")
                .then().log().all()
                .assertThat().statusCode(405)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertEquals(response.message, "no data");
    }
}
