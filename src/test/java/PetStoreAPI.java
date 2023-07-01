import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class PetStoreAPI {

    private Gson gson;
    private RandomDataGenerator dataGenerator;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";
        gson = new Gson();
        dataGenerator = new RandomDataGenerator();
    }

    @Test
    public void testGetOrderById() {
        int orderId = 2;

        given()
                .pathParam("orderId", orderId)
                .when()
                .get("/order/{orderId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(orderId))
                .body("status", equalTo("placed"));
    }

    @Test
    public void testGetOrderByIdPositive() {
        int orderId = 2;

        Response response = given()
                .pathParam("orderId", orderId)
                .when()
                .get("/order/{orderId}");

        assertNotNull(response);
        int statusCode = response.getStatusCode();

        assertNotNull(response.getBody());
        OrderDto orderDto = response.getBody().as(OrderDto.class);

        assertAll("Grouped Assertions of OrderDto",
                () -> assertEquals(orderId, orderDto.getId(), "Verify Order ID"),
                () -> assertEquals(2, orderDto.getPetId(), "Verify Pet ID"),
                () -> assertEquals(1, orderDto.getQuantity(), "Verify Quantity"),
                () -> assertEquals("placed", orderDto.getStatus(), "Verify Status"),
                () -> assertTrue(orderDto.isComplete(), "Verify Completion")
        );
    }

    @Test
    public void testGetOrderByIdNotFound() {
        int orderId = 999;

        given()
                .pathParam("orderId", orderId)
                .when()
                .get("/order/{orderId}")
                .then()
                .statusCode(200);
    }

    private static class Gson {
        private com.google.gson.Gson gson;

        private Gson() {
            gson = new com.google.gson.Gson();
        }

        public String toJson(Object obj) {
            return gson.toJson(obj);
        }
    }

    private static class RandomDataGenerator {
        public String generateRandomName() {
            return "Angelina";
        }

        public String generateRandomPhone() {
            return "1234567890";
        }

        public String generateRandomComment() {
            return "Random comment";
        }
    }

    private class OrderDto {
        private int id;
        private int petId;
        private int quantity;
        private String status;
        private boolean complete;

        public int getId() {
            return id;
        }

        public int getPetId() {
            return petId;
        }

        public int getQuantity() {
            return quantity;
        }

        public String getStatus() {
            return status;
        }

        public boolean isComplete() {
            return complete;
        }
    }
}
