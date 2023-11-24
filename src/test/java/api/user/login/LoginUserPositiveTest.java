package api.user.login;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojos.PetStoreAPIResponse;
import pojos.User;
import utils.Constants;
import utils.user.IO.UserReader;

import static io.restassured.RestAssured.given;

public class LoginUserPositiveTest {

    private User user;

    @BeforeTest
    private void setUser() {
        this.user = given()
                .get(Constants.baseUrl + "user/" + Constants.defaultUsername)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(User.class);
    }

    @Test(groups = "user")
    public void loginUserPositiveTest() {
        PetStoreAPIResponse response = given()
                .queryParam("username", user.username)
                .queryParam("password", user.password)
                .when().contentType(ContentType.JSON)
                .get(Constants.baseUrl + "user/login")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertTrue(response.message.contains("logged in user session"));
    }
}
