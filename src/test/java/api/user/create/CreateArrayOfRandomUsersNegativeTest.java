package api.user.create;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.User;
import utils.Constants;
import utils.Generator;
import utils.UserWriter;

import static io.restassured.RestAssured.given;

public class CreateArrayOfRandomUsersNegativeTest {

    @Test
    public void createArrayOfRandomUsersPositiveTest() {
        User[] users = new User[10];
        given()
                .when().contentType(ContentType.JSON)
                .body(users)
                .post(Constants.baseUrl + "user/createWithArray")
                .then().log().all()
                .assertThat().statusCode(500);
    }
}
