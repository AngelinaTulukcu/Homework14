import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostMethodTests {

    @Test
    public void positiveTest() {
        String requestBody = "{\n" +
                "  \"status\": \"OPEN\",\n" +
                "  \"courierId\": 0,\n" +
                "  \"customerName\": \"string\",\n" +
                "  \"customerPhone\": \"string\",\n" +
                "  \"comment\": \"string\",\n" +
                "  \"id\": 0\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://51.250.6.164:8080/test-orders")
                .then()
                .statusCode(200);
    }
}
