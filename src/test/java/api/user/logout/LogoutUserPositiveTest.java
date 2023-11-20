package api.user.logout;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.PetStoreAPIResponse;
import pojos.User;
import utils.Constants;
import utils.UserReader;

import static io.restassured.RestAssured.given;

public class LogoutUserPositiveTest {

    @Test
    public void LogoutUserPositiveTest() {
        PetStoreAPIResponse response = given()
                .when().contentType(ContentType.JSON)
                .get(Constants.baseUrl + "user/logout")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertEquals(response.message, "ok");
    }
}
