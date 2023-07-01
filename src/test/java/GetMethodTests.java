import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

class GetMethodTests {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    public void simpleParamPositiveTestGet(int id) {
        given()
                .when()
                .log()
                .all()
                .get("http://51.250.6.164:8080/test-orders/{id}", id)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }
    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    public void simpleParamNegativeTestGet(int id) {
        given()
                .when()
                .log()
                .all()
                .get("http://51.250.6.164:8080/test-orders/{id}", id)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}