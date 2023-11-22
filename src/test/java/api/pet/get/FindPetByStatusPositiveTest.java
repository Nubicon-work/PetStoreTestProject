package api.pet.get;

import enums.PetStatus;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojos.Pet;
import utils.Constants;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class FindPetByStatusPositiveTest {

    @DataProvider(name = "pet_statuses")
    public Object[][] getPetStatuses() {
        return new Object[][] {
                {PetStatus.AVAILABLE},
                {PetStatus.PENDING},
                {PetStatus.SOLD}
        };
    }

    @Test(groups = "pet", dataProvider = "pet_statuses")
    public void findPetBySoldStatusPositiveTest(PetStatus petStatus) {
        Pet[] pets = given()
                .when().contentType(ContentType.JSON)
                .get(Constants.baseUrl + "pet/findByStatus?status=" + petStatus.getStatus())
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Pet[].class);
        Assert.assertTrue(pets.length > 0);
        Arrays.stream(pets).forEach(x -> Assert.assertEquals(x.status, petStatus.getStatus()));
    }
}

