package api.store.get;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Order;
import pojos.Pet;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class GetOrderByIdPositiveTest {

    private final long id = 2;

    @Test(groups = "store")
    public void getOrderByIdPositiveTest() {
        Order order = given()
                .get(Constants.baseUrl + "store/order/" + id)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Order.class);
        Assert.assertEquals(order.id, id);
    }
}
