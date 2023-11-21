package api.pet.get;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class FindPetByStatusNegativeTest {

    @Test
    public void findPetByStatusNegativeTest() {
        Pet[] pets = given()
                .when().contentType(ContentType.JSON)
                .get(Constants.baseUrl + "pet/findByStatus?status=aaaaa")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet[].class);
        Assert.assertEquals(pets.length, 0);
    }
}
