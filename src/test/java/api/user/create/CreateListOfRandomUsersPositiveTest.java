package api.user.create;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.User;
import utils.Constants;
import utils.Generator;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateListOfRandomUsersPositiveTest {

    @Test
    public void createListOfRandomUsersPositiveTest() throws JsonProcessingException {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(Generator.getRandomUser());
        }
        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(users);
        given()
                .when().contentType(ContentType.JSON)
                .body(body)
                .post(Constants.baseUrl + "user/createWithList")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
