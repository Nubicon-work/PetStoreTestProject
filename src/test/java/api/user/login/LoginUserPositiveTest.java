package api.user.login;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.PetStoreAPIResponse;
import pojos.User;
import utils.Constants;
import utils.user.IO.UserReader;

import static io.restassured.RestAssured.given;

public class LoginUserPositiveTest {

    @Test
    public void loginUserPositiveTest() {
        User user = UserReader.readRandom();
        StringBuilder uri = new StringBuilder(Constants.baseUrl).append("user/login?username=").append(user.username).append("&password=").append(user.password);
        PetStoreAPIResponse response = given()
                .when().contentType(ContentType.JSON)
                .get(uri.toString())
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertTrue(response.message.contains("logged in user session"));
    }
}
