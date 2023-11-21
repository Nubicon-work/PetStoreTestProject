package api.pet.update;

import enums.PetStatus;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import utils.Constants;
import utils.pet.IO.PetWriter;

import static io.restassured.RestAssured.given;

public class UpdatePetStatusPositiveTest {

    private final Long id = 111L;

    @Test
    public void updatePetStatusPositiveTest() {
        Pet[] pets = given()
                .when().contentType(ContentType.JSON)
                .get(Constants.baseUrl + "pet/findByStatus?status=" + PetStatus.AVAILABLE.getStatus())
                .then()//.log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet[].class);
        Assert.assertTrue(pets.length > 0);
        Pet pet = pets[0];
        pet.status = PetStatus.PENDING.getStatus();
        given()
                .pathParam("status", pet.status)
                .when().contentType(ContentType.JSON)
                .post(Constants.baseUrl + "pet/" + pet.id)
                .then().log().all()
                .assertThat().statusCode(200);
        PetWriter.write(pet);
    }
}
