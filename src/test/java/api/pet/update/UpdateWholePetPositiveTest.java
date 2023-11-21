package api.pet.update;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.Pet;
import utils.Constants;
import utils.pet.IO.PetWriter;

import static io.restassured.RestAssured.given;

public class UpdateWholePetPositiveTest {

    private final Long id = 1L;

    @Test
    public void updateWholePetPositiveTest() {
        Pet pet = given()
                .get(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet.class);
        given()
                .when().contentType(ContentType.JSON)
                .body(pet)
                .post(Constants.baseUrl + "pet")
                .then().log().all()
                .assertThat().statusCode(200);
        PetWriter.write(pet);
    }
}
