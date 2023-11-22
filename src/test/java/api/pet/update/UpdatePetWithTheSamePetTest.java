package api.pet.update;

import enums.PetStatus;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import pojos.PetStoreAPIResponse;
import utils.Constants;
import utils.pet.IO.PetWriter;

import static io.restassured.RestAssured.given;

public class UpdatePetWithTheSamePetTest {

    private final Long id = 5L;

    @Test(groups = "pet")
    public void updatePetStatusPositiveTest() {
        Pet pet = given()
                .get(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet.class);
        given()
                .when().contentType(ContentType.JSON)
                .body(pet)
                .put(Constants.baseUrl + "pet")
                .then().log().all()
                .assertThat().statusCode(200);
        PetWriter.write(pet);
    }
}
