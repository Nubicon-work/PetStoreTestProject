package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePetTest {

    private final String baseUrl = "https://petstore.swagger.io/#/";
    @Test
    public void deletePetTest() {

        int code = given()
                .when()
                .contentType(ContentType.JSON)
                .get(baseUrl + "pet/deletePet/1")
                .then().log().all()
                .extract().statusCode();
        System.out.println("\n\n\ncode: " + code);
    }
}
