package api.user.logout;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.PetStoreAPIResponse;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class LogoutUserPositiveTest {

    @Test(groups = "user")
    public void logoutUserPositiveTest() {
        PetStoreAPIResponse response = given()
                .when().contentType(ContentType.JSON)
                .get(Constants.baseUrl + "user/logout")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertEquals(response.message, "ok");
    }
}
