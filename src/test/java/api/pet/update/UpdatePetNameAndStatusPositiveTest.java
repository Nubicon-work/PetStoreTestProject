package api.pet.update;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import pojos.PetStoreAPIResponse;
import utils.Constants;
import utils.pet.IO.PetWriter;
import utils.pet.PetGenerator;

import static io.restassured.RestAssured.given;

public class UpdatePetNameAndStatusPositiveTest {

    private final Long id = 5L;

    @Test(groups = "pet")
    public void updatePetNameAndStatusPositiveTest() {
        Pet pet = given()
                .get(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet.class);
        pet.name = PetGenerator.getRandomPetName();
        pet.status = PetGenerator.getOtherPetStatus(pet.status);
        PetStoreAPIResponse response = given()
                .queryParam("name", pet.name)
                .when()
                .post(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertEquals(response.message, id.toString());
        PetWriter.write(pet);
    }
}
