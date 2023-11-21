package api.pet.get;

import enums.PetStatus;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Pet;
import utils.Constants;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class FindPetByStatusPositiveTest {

    @Test
    public void findPetBySoldStatusPositiveTest() {
        Pet[] pets = given()
                .when().contentType(ContentType.JSON)
                .get(Constants.baseUrl + "pet/findByStatus?status=" + PetStatus.SOLD.getStatus())
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet[].class);
        Assert.assertTrue(pets.length > 0);
        Arrays.stream(pets).forEach(x -> Assert.assertEquals(x.status, PetStatus.SOLD.getStatus()));
    }

    @Test
    public void findPetByAvailableStatusPositiveTest() {
        Pet[] pets = given()
                .when().contentType(ContentType.JSON)
                .get(Constants.baseUrl + "pet/findByStatus?status=" + PetStatus.AVAILABLE.getStatus())
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet[].class);
        Assert.assertTrue(pets.length > 0);
        Arrays.stream(pets).forEach(x -> Assert.assertEquals(x.status, PetStatus.AVAILABLE.getStatus()));
    }

    @Test
    public void findPetByPendingStatusPositiveTest() {
        Pet[] pets = given()
                .when().contentType(ContentType.JSON)
                .get(Constants.baseUrl + "pet/findByStatus?status=" + PetStatus.PENDING.getStatus())
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet[].class);
        Assert.assertTrue(pets.length > 0);
        Arrays.stream(pets).forEach(x -> Assert.assertEquals(x.status, PetStatus.PENDING.getStatus()));
    }
}
