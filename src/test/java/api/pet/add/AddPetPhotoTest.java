package api.pet.add;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import pojos.PetStoreAPIResponse;
import utils.Constants;
import utils.pet.IO.PetPhotoReader;
import utils.pet.IO.PetReader;

import java.io.File;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class AddPetPhotoTest {

    @Test(groups = "pet")
    public void addPetPhotoTest() {
        Pet pet = PetReader.readRandom();
        File photo = PetPhotoReader.readRandom();
        PetStoreAPIResponse response = given()
                .multiPart(photo)
                .when().contentType(ContentType.MULTIPART)
                .post(Constants.baseUrl + "pet/" + Objects.requireNonNull(pet).id + "/uploadImage")
                .then().log().all()
                .assertThat().statusCode(200)
                        .extract().as(PetStoreAPIResponse.class);
        Assert.assertTrue(response.message.contains("File uploaded"));
    }
}
