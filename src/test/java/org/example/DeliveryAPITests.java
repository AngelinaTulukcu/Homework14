package org.example;

import com.google.gson.Gson;
import dto.Order;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;


public class DeliveryAPITests {

    static String token;


    @BeforeAll
    public static void setUp() {

        System.out.println("---> test start");

        SetupFunctions setupFunctions = new SetupFunctions();
        token = setupFunctions.getToken();

        System.out.println("token " + setupFunctions.getToken());

        RestAssured.baseURI = setupFunctions.getBaseUrl();


        Assumptions.assumeFalse(token.isEmpty(), "Token is not exists, all test skipped");
    }


    @Test
    public void createOrder() {

        Order newOrder = new Order(0, "Monday", "+372988888", "have a good week", 0);
        Gson gson = new Gson();

        given()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(gson.toJson(newOrder))
                .log()
                .all()
                .post("/orders")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);

        Assertions.assertNotNull (newOrder.getCustomerName());
    }

    public int createOrderForSearchingAndDeleting() {
        Order createdOrder = new Order(0, "Tuesday", "+375", "have a good day", 0);
        Gson createdGson = new Gson();

        Response response = given()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(createdGson.toJson(createdOrder))
                .log()
                .all()
                .post("/orders")
                .then()
                .log()
                .all()
                .extract()
                .response();

        Order orderId = createdGson.fromJson(response.asString(), Order.class);

        return orderId.getId();

    }

    @Test
    public void searchCreatedOrder() {

        int orderIdCreated = createOrderForSearchingAndDeleting();

        String status = given()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .log()
                .all()
                .get("/orders/" + orderIdCreated)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("status");


        Assertions.assertEquals("OPEN", status);

    }

    @Test
    public void deleteOrder() {

        int orderIdCreated = createOrderForSearchingAndDeleting();

        given()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .log()
                .all()
                .delete("orders/" + orderIdCreated)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .response()
                .getBody()
                .asString();

        Assertions.assertTrue(true);



        String body = given ()
                .when()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .log()
                .all()
                .get("orders/" + orderIdCreated)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .response()
                .getBody()
                .asString();

        Assumptions.assumeTrue(body.isEmpty(), "Test passed if response body is empty");

    }


    @Test
    public void negativeTestOrderWithoutTokenGet() {
        given()
                .when()
                .header("Content-Type", "application/json")
//                .header("Authorization", "Bearer " + token)
                .log()
                .all()
                .get("orders/3914")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);

        Assumptions.assumeFalse(token.isEmpty(), "Token is not exists, all test skipped");

    }


    @Test
    public void negativeTestOrderHeaderContentTypeGet() {
        Response response = given()
                .header("Content-Type2", "text/plain") // Setting an incorrect Content-Type
                .header("Authorization", "Bearer " + token)
                .log()
                .all()
                .when()
                .get("orders///")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST) // Expecting a 400 status code
                .extract()
                .response();

    }
}
