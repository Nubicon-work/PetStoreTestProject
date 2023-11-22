package api.store.get;

import org.testng.annotations.Test;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class GetStoreInventoryTest {

    @Test(groups = "store")
    public void getStoreInventoryTest() {
        given()
                .get(Constants.baseUrl + "store/inventory")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
