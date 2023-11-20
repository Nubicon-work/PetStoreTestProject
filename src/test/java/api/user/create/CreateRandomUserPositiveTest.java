package api.user.create;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.User;
import utils.Constants;
import utils.Generator;
import utils.UserWriter;

import static io.restassured.RestAssured.given;

public class CreateRandomUserPositiveTest {

    @Test
    public void createRandomUserPositiveTest() {
        User user = Generator.getRandomUser();
        given()
                .when().contentType(ContentType.JSON)
                .body(user)
                .post(Constants.baseUrl + "user")
                .then().log().all()
                .assertThat().statusCode(200);
        UserWriter.write(user);
    }
}
