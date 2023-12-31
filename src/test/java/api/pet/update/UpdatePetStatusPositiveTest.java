package api.pet.update;

import enums.PetStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import pojos.PetStoreAPIResponse;
import utils.Constants;
import utils.pet.IO.PetWriter;

import static io.restassured.RestAssured.given;

public class UpdatePetStatusPositiveTest {

    private final Long id = 5L;

    @Test(groups = "pet")
    public void updatePetStatusPositiveTest() {
        Pet pet = given()
                .get(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet.class);
        pet.status = PetStatus.PENDING.getStatus();
        PetStoreAPIResponse response = given()
                .queryParam("status", pet.status)
                .when()
                .post(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertEquals(response.message, id.toString());
        PetWriter.write(pet);
    }
}
