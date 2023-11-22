package api.store.create;

import api.pet.create.CreateRandomPetPositiveTest;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojos.Order;
import pojos.Pet;
import pojos.PetStoreAPIResponse;
import utils.Constants;
import utils.order.OrderGenerator;
import utils.pet.PetGenerator;

import static io.restassured.RestAssured.given;

public class CreateRandomOrderPositiveTest {

    private Pet pet;
    private Order order;

    @BeforeTest
    public void createTestPet() {
        this.pet = PetGenerator.getRandomPet();
        given()
                .when().contentType(ContentType.JSON)
                .body(pet)
                .post(Constants.baseUrl + "pet")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test(groups = "store")
    public void createRandomOrderPositiveTest() {
        this.order = OrderGenerator.getRandomOrder(this.pet);
        given()
                .when().contentType(ContentType.JSON)
                .body(order)
                .post(Constants.baseUrl + "store/order")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
