package api.pet.get;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import pojos.PetStoreAPIResponse;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class GetPetByIdNegativeTest {

    private final long id = 0;

    @Test
    public void getPetByIdNegativeTest() {
        PetStoreAPIResponse response = given()
                .get(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(404)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertEquals(response.message, "Pet not found");
    }
}
