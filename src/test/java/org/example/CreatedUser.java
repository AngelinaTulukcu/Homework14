package org.example;

import com.google.gson.Gson;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatedUser {
    @Test
    public void toCreateUser() {
        RandomUser randomUser = new RandomUser(25, "test", "Angelina", "Tul", "test@gmail.com", "1234567", "+37599999", 12);
        RandomUser randomUserEmpty = new RandomUser();
        randomUser.setId(25);
        randomUser.setUsername("test");
        randomUser.setFirstName("Angelina");
        randomUser.setLastName("Tul");
        randomUser.setEmail("test@gmail.com");
        randomUser.setPassword("12345678");
        randomUser.setPhone("+37599999");
        randomUser.setUserStatus(12);
        randomUserEmpty.setId(25);
        randomUserEmpty.setUsername("test");
        randomUserEmpty.setFirstName(generatedRandomFirstName());
        randomUserEmpty.setLastName("Tul");
        randomUserEmpty.setEmail("test@gmail.com");
        randomUserEmpty.setPassword("12345678");
        randomUserEmpty.setPhone(generatedRandomFirstName());
        randomUserEmpty.setUserStatus(12);

        Gson gson = new Gson();
        given()
                .when()
                .header("Content-Type", "application/json")
                .body(gson.toJson(randomUserEmpty))
                .log()
                .all()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);

        assertAll("Grouped Assertions of User",
                () -> assertEquals(25, randomUser.getId(), "Verify ID"),
                () -> assertEquals("test", randomUser.getUsername(), "Verify Username"),
                () -> assertEquals("Angelina", randomUser.getFirstName(), "Verify First Name"),
                () -> assertEquals("Tul", randomUser.getLastName(), "Verify Last Name"),
                () -> assertEquals("test@gmail.com", randomUser.getEmail(), "Verify Email"),
                () -> assertEquals("12345678", randomUser.getPassword(), "Verify Password"),
                () -> assertEquals("+37599999", randomUser.getPhone(), "Verify Phone"),
                () -> assertEquals(12, randomUser.getUserStatus(), "Verify User Status")
        );
    }

    public String generatedRandomFirstName() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        int lengthFirstName = 15;
        boolean useLettersFirstName = false;
        boolean useSymbolsFirstName = true;
        String generatedStringFirstName = RandomStringUtils.random(lengthFirstName, useLettersFirstName, useSymbolsFirstName);

        return generatedStringFirstName;
    }

    public String generatedRandomPhone() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        int lengthFirstName = 15;
        boolean useLettersPhone = false;
        boolean useNumbersPhone = true;
        String generatedStringPhone = RandomStringUtils.random(lengthFirstName, useLettersPhone, useNumbersPhone);

        return generatedStringPhone;
    }

    private class RandomUser {
        private int id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String phone;
        private int userStatus;

        public RandomUser(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
            this.id = id;
            this.username = username;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.phone = phone;
            this.userStatus = userStatus;
        }

        public RandomUser() {

        }

        public void setId(int id) {
            this.id = id;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setUserStatus(int userStatus) {
            this.userStatus = userStatus;
        }

        public String getUsername() {
            return username;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getPhone() {
            return phone;
        }

        public int getUserStatus() {
            return userStatus;
        }
    }
}

