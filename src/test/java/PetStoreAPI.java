import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreAPI {

    @Test
    public void testGetOrderById() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";
        int orderId = 1;

        given()
                .pathParam("orderId", orderId)
                .when()
                .get("/order/{orderId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(orderId));
    }

    @Test
    public void testGetOrderByIdPositive() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";
        int orderId = 2;

        given()
                .pathParam("orderId", orderId)
                .when()
                .get("/order/{orderId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(orderId))
                .body("petId", equalTo(3))
                .body("quantity", equalTo(8))
                .body("status", equalTo("placed"))
                .body("complete", equalTo(true));
    }

    @Test
    public void testGetOrderByIdNotFound() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";
        int orderId = 999;

        given()
                .pathParam("orderId", orderId)
                .when()
                .get("/order/{orderId}")
                .then()
                .statusCode(404);
    }
}