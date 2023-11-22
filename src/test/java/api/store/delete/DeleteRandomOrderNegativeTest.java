package api.store.delete;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojos.Order;
import pojos.Pet;
import pojos.PetStoreAPIResponse;
import utils.Constants;
import utils.order.OrderGenerator;
import utils.pet.PetGenerator;

import static io.restassured.RestAssured.given;

public class DeleteRandomOrderNegativeTest {

    private Pet pet;
    private Order order;

    @BeforeTest
    public void setup() {
        createPet();
        createOrder();
    }

    private void createPet() {
        this.pet = PetGenerator.getRandomPet();
        given()
                .when().contentType(ContentType.JSON)
                .body(pet)
                .post(Constants.baseUrl + "pet")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    private void createOrder() {
        this.order = OrderGenerator.getRandomOrder(this.pet);
        this.order.id = 0;
        given()
                .when().contentType(ContentType.JSON)
                .body(order)
                .post(Constants.baseUrl + "store/order")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test(groups = "store")
    public void deleteRandomOrderNegativeTest() {
        PetStoreAPIResponse response = given()
                .when().contentType(ContentType.JSON)
                .delete(Constants.baseUrl + "store/order/" + order.id)
                .then().log().all()
                .assertThat().statusCode(404)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertEquals(response.message, "Order Not Found");
    }


}
