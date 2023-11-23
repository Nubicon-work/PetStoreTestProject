package api.store.get;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojos.Order;
import pojos.Pet;
import utils.Constants;
import utils.order.OrderGenerator;
import utils.pet.PetGenerator;

import static io.restassured.RestAssured.given;

public class GetOrderByIdPositiveTest {

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
        given()
                .when().contentType(ContentType.JSON)
                .body(order)
                .post(Constants.baseUrl + "store/order")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test(groups = "store")
    public void getOrderByIdPositiveTest() {
        Order order = given()
                .get(Constants.baseUrl + "store/order/" + this.order.id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Order.class);
        Assert.assertEquals(order.id, this.order.id);
    }
}
