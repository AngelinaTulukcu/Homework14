import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class NegativePostMethodTests {

    @Test
    public void unsupportedMediaTypeTest() {
        String requestBody415 = "{\n" +
                "  \"status\": \"DELIVERED\",\n" +
                "  \"courierId\": 16,\n" +
                "  \"customerName\": \"string\",\n" +
                "  \"customerPhone\": \"string\",\n" +
                "  \"comment\": \"string\",\n" +
                "  \"id\": 0\n" +
                "}";

        given()
                .when()
                .body(requestBody415)
                .log().all()
                .post("http://51.250.6.164:8080/test-orders")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE);
    }
}

