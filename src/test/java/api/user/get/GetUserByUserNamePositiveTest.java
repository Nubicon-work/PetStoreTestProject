package api.user.get;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.User;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class GetUserByUserNamePositiveTest {

    @Test(groups = "user")
    public void getUserByUserNamePositiveTest() {
        User alex = given()
                .get(Constants.baseUrl + "user/" + Constants.defaultUsername)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(User.class);
        Assert.assertEquals(alex.username, Constants.defaultUsername);
    }
}
