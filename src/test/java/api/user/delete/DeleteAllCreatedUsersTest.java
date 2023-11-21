package api.user.delete;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.User;
import utils.Constants;
import utils.user.IO.UserReader;
import utils.user.IO.UserRemover;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DeleteAllCreatedUsersTest {

    @Test
    public void deleteAllCreatedUsersTest() {
        File[] directory = new File(Constants.createdUsersDirectory).listFiles();
        for (int i = 0; i < directory.length; i++) {
            User user = UserReader.read(directory[i]);
            if (user != null) {
                given()
                        .when().contentType(ContentType.JSON)
                        .body(user)
                        .post(Constants.baseUrl + "user")
                        .then().log().all()
                        .assertThat().statusCode(200);
            }
            UserRemover.remove(user);
        }
    }
}
