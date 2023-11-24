package api.pet.add;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojos.Pet;
import pojos.PetStoreAPIResponse;
import utils.Constants;
import utils.pet.IO.PetReader;

import java.io.File;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class AddPetNullPhotoTest {

    private final long id = 5;
    private Pet pet;

    @BeforeTest
    public void getPetById() {
        this.pet = given()
                .get(Constants.baseUrl + "pet/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet.class);
    }

    @Test(groups = "pet")
    public void addPetNullPhotoTest() {
        File photo = new File(Constants.txtDirectory + "photo.txt");
        PetStoreAPIResponse response = given()
                .multiPart(photo)
                .when().contentType(ContentType.MULTIPART)
                .post(Constants.baseUrl + "pet/" + Objects.requireNonNull(this.pet).id + "/uploadImage")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertTrue(response.message.contains("File uploaded"));
    }
}
