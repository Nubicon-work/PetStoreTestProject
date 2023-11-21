package api.pet.get;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class GetPetByIdPositiveTest {

    private final long id = 5;

    @Test
    public void getPetByIdPositiveTest() {
        Pet pet = given()
                .get(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet.class);
        Assert.assertEquals(pet.id, id);
    }
}
