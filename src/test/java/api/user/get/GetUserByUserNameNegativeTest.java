package api.user.get;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.PetStoreAPIResponse;
import utils.Constants;

import java.util.Timer;

import static io.restassured.RestAssured.given;

public class GetUserByUserNameNegativeTest {

    private String expectedMessage = "User not found";

    @Test
    public void getUserByUserNameNegativeTest() {
        String wrongUsername = String.valueOf(new java.util.Date());;
        PetStoreAPIResponse petStoreAPIResponse = given()
                .get(Constants.baseUrl + "user/" + wrongUsername)
                .then().log().all()
                .assertThat().statusCode(404)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertEquals(petStoreAPIResponse.message, expectedMessage);
    }
}
