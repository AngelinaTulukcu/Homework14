#Homework18 task 2.1

### Test Descriptions and Results

| №  | Test Name                        | Description                                                                                                                                                      | Status   |
|----|----------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|
|    | Positive Tests                   |                                                                                                                                                                  |          |
|    | Mobiil-ID                        |                                                                                                                                                                  |          |
| 1  | Successful login                | Enter an existing Estonian phone number with connected Mobiil-ID (+37258066606) in the "Mobiili nr" field and an existing Estonian isikukood (48812050267) in the "Isikukood" field. The "Logi sisse" button should be active. | Passed   |
|    | Smart-ID                         |                                                                                                                                                                  |          |
| 2  | Successful login                | Enter an existing Estonian isikukood (48812050267) in the "Isikukood" field. The "Logi sisse" button should be active.                                           | Passed   |
|    | Parool                           |                                                                                                                                                                  |          |
| 3  | Successful login                | Enter a valid kasutajanimi ("Login-test") and a valid parool ("Parool-test") in the respective fields. The "Logi sisse" button should be active.                | Passed   |
|    | Negative Tests                   |                                                                                                                                                                  |          |
|    | Smart-ID                         |                                                                                                                                                                  |          |
| 4  | Unsuccessful login              | Enter an isikukood longer than the standard isikukood by 1 digit (488120502677) in the "Isikukood" field. An error message should be displayed.                    | Passed   |
|    | Parool                           |                                                                                                                                                                  |          |
| 5  | Unsuccessful login              | Leave the Kasutajanimi field empty (without values) and enter a space in the Parool field. An error message should be displayed.                                 | Failed   |

---


# Checklist for Functional UI Testing - Tallinn Delivery App (Login)
## Homework17

1. Form Validation:
   - 1. Verify that all input fields (username and password) are present and displayed correctly.
   - 2. Check the presence and functionality of the "Login" button when entering data.

2. Incorrect Data Validation:
   - 1. Validate error messages for attempting login without filling in the required fields.
   - 2. Verify error messages for entering invalid login credentials.
   - 3. Check for error messages when using unauthorized characters.

3. Login Functionality:
   - 1. Test successful login with valid credentials.
   - 2. Verify that the user is redirected to the correct page after login.

4. Logout Functionality:
   - 1. Test the correct logout process and redirection to the login page.

### Table 1: Web Elements for Authentication Form

| No | Web Element Description   | Xpath                        |
|----|---------------------------|------------------------------|
| 1  | Username Input Field      | //input[@data-name="username"]    |
| 2  | Password Input Field      | //input[@data-name="password"]    |
| 3  | Login Button              |//input[@data-name='signIn-button']    |
| 4  | Error Message Display     | //div[@data-name="error-password"]|     


### Table 2: XPaths for Table Elements

| No   | Description                                    | Xpath                                              |
|------|-----------------------------------------------|----------------------------------------------------|
| 4.1  | Select all `<td>` elements containing names (Name)       | `//td[@class='td3']`                                |
| 4.2  | Select all `<tr>` elements with "data-qa" starting "amount-" | `//tr[starts-with(@data-qa, 'amount-')]`           |
| 4.3  | Select all `<tr>` elements containing `<td>` with "John Doe" | `//tr[.//td[contains(., 'John Doe')]]`             |


### XPath Table - Usage for Element Selection

For automating tests and verifying specific elements in the HTML document, the following XPaths have been identified:

#### 4.1 - Select all <td> elements containing names (Name)

XPath: `//td[@class='td3']`


#### 4.2 - Select all <tr> elements with "data-qa" starting "amount-"

XPath: `//tr[starts-with(@data-qa, 'amount-')]`


#### 4.3 - Select all <tr> elements containing <td> with "John Doe"

XPath: `//tr[.//td[contains(., 'John Doe')]]`

# Homework10

## Project Description
This project is a collection of automated API tests that verify the functionality and reliability of an API interface. The tests are written in Java using the RestAssured framework.

## Tested Functionality
The following table provides an overview of the tested functionality and their status:

| Number | Check Name                                 | Check Description                                       | Status  |
|--------|--------------------------------------------|---------------------------------------------------------|---------|
| 1      | simplePositiveTestGet                 | Integer IDs with values {1, 5, 10} to get response 200 OK | Passed  |
| 2      | simpleNegativeTestGet                 | Integer IDs with values {0, 11} to get response 400 Bad Request | Passed  |
| 3      | simplePositiveTestPost                     | Create an order with random generated data (ID) to get response 200 OK | Passed  |
| 4      | simpleNegativeTestPost                     | Create an order with random generated data (ID) to get response 415 Unsupported Media Type | Passed  |
| 5      | simplePositiveTestResponseBodyStatusOpenGet| Check the response body for status "OPEN" to get response 200 OK | Passed  |
| 6      | simpleGetOrderById	                        | Check the Verifies the successful retrieval of an order by its ID from the Pet Store API. to get response 200 OK| Passed  |
| 7      | simpleGetOrderById	                        | Check the Verifies the successful retrieval of an order by its ID from the Pet Store API. to get response 404| Passed  |
## Tools Used
- Programming Language: Java
- API Testing Framework: RestAssured
- Build System: Maven
- Integrated Development Environment (IDE): IntelliJ IDEA
