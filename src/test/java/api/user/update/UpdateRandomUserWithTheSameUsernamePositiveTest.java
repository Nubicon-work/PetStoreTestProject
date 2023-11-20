package api.user.update;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.User;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class UpdateRandomUserWithTheSameUsernamePositiveTest {

    @Test
    public void updateRandomUserWithTheSameUsernamePositiveTest() {
        User user = given()
                .when().contentType(ContentType.JSON)
                .get(Constants.baseUrl + "user/" + Constants.defaultUsername)
                .then().log().all()
                .extract().as(User.class);
        given()
                .when().contentType(ContentType.JSON)
                .body(user)
                .put(Constants.baseUrl + "user/" + Constants.defaultUsername)
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
