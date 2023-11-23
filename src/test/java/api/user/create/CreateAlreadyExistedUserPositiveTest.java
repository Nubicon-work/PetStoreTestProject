package api.user.create;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.User;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class CreateAlreadyExistedUserPositiveTest {

    @Test(groups = "user", suiteName = "user")
    public void createAlreadyExistedUserPositiveTest() {
        User user = given()
                .get(Constants.baseUrl + "user/" + Constants.defaultUsername)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(User.class);
        given()
                .when().contentType(ContentType.JSON)
                .body(user)
                .post(Constants.baseUrl + "user")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
