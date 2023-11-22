package api.user.delete;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.PetStoreAPIResponse;
import pojos.User;
import utils.Constants;
import utils.user.IO.UserReader;
import utils.user.IO.UserRemover;
import utils.user.UserGenerator;

import static io.restassured.RestAssured.given;

public class DeleteRandomUserPositiveTest {

    @Test(groups = "user")
    public void deleteRandomUserPositiveTest() {
        User user = UserGenerator.getRandomUser();
        given()
                .when().contentType(ContentType.JSON)
                .body(user)
                .post(Constants.baseUrl + "user")
                .then().log().all()
                .assertThat().statusCode(200);
        PetStoreAPIResponse response = given()
                .when().contentType(ContentType.JSON)
                .body(user)
                .post(Constants.baseUrl + "user")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertEquals(response.message, String.valueOf(user.id));
    }
}
