package api.user.create;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.User;
import utils.Constants;
import utils.user.UserGenerator;
import utils.user.IO.UserWriter;

import static io.restassured.RestAssured.given;

public class CreateTemplateUserPositiveTest {

    @Test(groups = "user")
    public void createTemplateUserPositiveTest() {
        User user = UserGenerator.getTemplateUser();
        int code = given()
                .when().contentType(ContentType.JSON)
                .body(user)
                .post(Constants.baseUrl + "user")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().statusCode();
        UserWriter.write(user);
    }
}
