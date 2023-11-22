package api.store.get;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Order;
import pojos.PetStoreAPIResponse;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class GetOrderByIdNegativeTest {

    private final long id = 0;

    @Test(groups = "store")
    public void getOrderByIdNegativeTest() {
        PetStoreAPIResponse response = given()
                .get(Constants.baseUrl + "store/order/" + id)
                .then().log().all()
                .assertThat().statusCode(404)
                .extract().as(PetStoreAPIResponse.class);
        Assert.assertEquals(response.message, "Order not found");
    }
}
