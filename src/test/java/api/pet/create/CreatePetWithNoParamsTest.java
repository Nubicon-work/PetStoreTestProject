package api.pet.create;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.Pet;
import utils.Constants;
import utils.pet.IO.PetWriter;

import static io.restassured.RestAssured.given;

public class CreatePetWithNoParamsTest {

    @Test(groups = "pet")
    public void createPetWithNoParamsTest() {
        Pet pet = new Pet();
        given()
                .when().contentType(ContentType.JSON)
                .body(pet)
                .post(Constants.baseUrl + "pet")
                .then().log().all()
                .assertThat().statusCode(200);
        PetWriter.write(pet);
    }
}
