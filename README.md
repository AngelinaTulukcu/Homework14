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
