package api.user.update;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.User;
import utils.Constants;
import utils.Generator;
import utils.UserReader;
import utils.UserWriter;

import java.util.Locale;

import static io.restassured.RestAssured.given;

public class UpdateRandomUserPositiveTest {

    @Test
    public void createRandomUserPositiveTest() {
        User user = given()
                .when().contentType(ContentType.JSON)
                .get(Constants.baseUrl + "user/" + Constants.defaultUsername)
                .then().log().all()
                .extract().as(User.class);
        String newUsername = Constants.defaultUsername.toUpperCase() + "1234";
        given()
                .when().contentType(ContentType.JSON)
                .body(user)
                .put(Constants.baseUrl + "user/" + newUsername)
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
