package api.user.create;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojos.PetStoreAPIResponse;
import pojos.User;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class CreateAlreadyExistedUserPositiveTest {

    private User user;

    @BeforeTest
    public void setup() {
        setUser();
        loginUser();
    }

    private void setUser() {
        this.user = given()
                .get(Constants.baseUrl + "user/" + Constants.defaultUsername)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(User.class);
    }

    private void loginUser() {
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

    @Test(groups = "user", suiteName = "user")
    public void createAlreadyExistedUserPositiveTest() {
        given()
                .when().contentType(ContentType.JSON)
                .body(this.user)
                .post(Constants.baseUrl + "user")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
