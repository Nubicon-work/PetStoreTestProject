package api.pet.delete;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import pojos.PetStoreAPIResponse;
import utils.Constants;
import utils.pet.IO.PetRemover;
import utils.pet.PetGenerator;

import static io.restassured.RestAssured.given;

public class DeleteRandomPetPositiveTest {

    @Test(groups = "pet")
    public void deleteRandomPetPositiveTest() {
        Pet pet = PetGenerator.getRandomPet();
        given()
                .when().contentType(ContentType.JSON)
                .body(pet)
                .post(Constants.baseUrl + "pet")
                .then().log().all()
                .assertThat().statusCode(200);
        PetStoreAPIResponse response = given()
                .when().contentType(ContentType.JSON)
                .body(pet)
                .delete(Constants.baseUrl + "pet/" + pet.id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertEquals(response.message, String.valueOf(pet.id));
    }
}
