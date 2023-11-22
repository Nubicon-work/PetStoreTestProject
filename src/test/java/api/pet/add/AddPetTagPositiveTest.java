package api.pet.add;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import pojos.PetStoreAPIResponse;
import pojos.Tag;
import utils.Constants;
import utils.pet.IO.PetPhotoReader;
import utils.pet.IO.PetReader;
import utils.pet.IO.PetWriter;
import utils.pet.PetGenerator;

import java.io.File;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class AddPetTagPositiveTest {

    private final long id = 5l;

    @Test(groups = "pet")
    public void addPetTagPositiveTest() {
        Tag tag = PetGenerator.getPetTag();
        Pet pet = given()
                .get(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet.class);
        long oldTagsCount = pet.tags.size();
        pet.tags.add(tag);
        PetWriter.write(pet);
        given()
                .when().contentType(ContentType.JSON)
                .body(pet)
                .put(Constants.baseUrl + "pet")
                .then().log().all()
                .assertThat().statusCode(200);
        long newTagsCount = given()
                .get(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet.class).tags.size();
        Assert.assertEquals(newTagsCount - oldTagsCount, 1);
    }
}
