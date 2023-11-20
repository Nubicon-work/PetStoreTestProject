package api.pet.create;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateRandomPetPositiveTest {

    @Test
    public void createRandomPetPositiveTest() {
        given()
                .when()
                .post()
                .then()
                .extract()
    }
}
