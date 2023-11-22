package api.pet.update;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.Pet;
import utils.Constants;
import utils.pet.IO.PetWriter;
import utils.pet.PetGenerator;

import static io.restassured.RestAssured.given;

public class UpdateWholePetPositiveTest {

    @Test(groups = "pet")
    public void updateWholePetPositiveTest() {
        Pet pet = PetGenerator.getRandomPet();
        pet.id = 5;
        given()
                .when().contentType(ContentType.JSON)
                .body(pet)
                .put(Constants.baseUrl + "pet")
                .then().log().all()
                .assertThat().statusCode(200);
        PetWriter.write(pet);
    }
}
