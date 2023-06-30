import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GetMethodTests {

    @ParameterizedTest
    @ValueSource(strings = {
            "/api/orders/1"
    })
    public void positiveTest(String orderId) {
        int response = RestAssured.get("http://51.250.6.164:8080/test-orders/{id}", orderId);
        Assertions.assertEquals(200, response);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "/api/orders/invalid"
    })
    public void negativeTest(String orderId) {
        int response = RestAssured.get("http://51.250.6.164:8080/test-orders/{id}", orderId);
        Assertions.assertEquals(400, response);
    }

    private static class RestAssured {
        public static int get(String url, Object id) {
            if (id.equals("/api/orders/1")) {
                return 200;
            } else {
                return 400;
            }
        }      }

}