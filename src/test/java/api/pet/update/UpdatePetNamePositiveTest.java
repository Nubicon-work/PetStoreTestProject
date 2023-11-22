package api.pet.update;

import enums.PetStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import pojos.PetStoreAPIResponse;
import utils.Constants;
import utils.pet.IO.PetWriter;
import utils.pet.PetGenerator;

import static io.restassured.RestAssured.given;

public class UpdatePetNamePositiveTest {

    private final Long id = 5L;

    @Test(groups = "pet")
    public void updatePetNamePositiveTest() {
        Pet pet = given()
                .get(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet.class);
        pet.name = PetGenerator.getRandomPetName();
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
