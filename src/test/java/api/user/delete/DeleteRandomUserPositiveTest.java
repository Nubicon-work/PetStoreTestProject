package api.user.delete;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.PetStoreAPIResponse;
import pojos.User;
import utils.Constants;
import utils.Generator;
import utils.UserReader;
import utils.UserRemover;

import static io.restassured.RestAssured.given;

public class DeleteRandomUserPositiveTest {

    @Test
    public void deleteRandomUserPositiveTest() {
        User user = UserReader.readRandom();
        PetStoreAPIResponse response = given()
                .when().contentType(ContentType.JSON)
                .body(user)
                .post(Constants.baseUrl + "user")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(PetStoreAPIResponse.class);
        UserRemover.remove(user);
    }
}