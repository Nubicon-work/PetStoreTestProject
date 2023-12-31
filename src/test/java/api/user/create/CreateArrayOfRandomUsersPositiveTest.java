package api.user.create;

import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.User;
import utils.Constants;
import utils.user.UserGenerator;
import utils.user.IO.UserWriter;

import static io.restassured.RestAssured.given;

public class CreateArrayOfRandomUsersPositiveTest {

    @Test(groups = "user")
    public void createArrayOfRandomUsersPositiveTest() throws JsonProcessingException {
        User[] users = new User[10];
        for (int i = 0; i < users.length; i++) {
            users[i] = UserGenerator.getRandomUser();
        }
        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(users);
        given()
                .when().contentType(ContentType.JSON)
                .body(body)
                .post(Constants.baseUrl + "user/createWithArray")
                .then().log().all()
                .assertThat().statusCode(200);
        UserWriter.write(users);
    }
}
