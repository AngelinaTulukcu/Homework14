import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class PositiveGetMethodTests {

    @Test
    public void responseBodyStatusOpenTest() {

        String status = given()
                .when()
                .log().all()
                .get("http://51.250.6.164:8080/test-orders/7")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .path("status");

        Assertions.assertEquals("OPEN", status);
    }
}
