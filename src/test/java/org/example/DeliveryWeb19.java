package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


// 3.2
public class DeliveryWeb19 {

    static SetupFunctions setupFunctions;
    LoginPage loginPage;
    OrderPage orderPage;

    @BeforeAll
    public static void setUpProperty(){
        setupFunctions = new SetupFunctions();
    }

    @BeforeEach
    public void setUp(){
        open(setupFunctions.getBaseUrl());
    }

    @BeforeEach
    public void setupLoginPage(){
        loginPage = new LoginPage();
    }

    @BeforeEach
    public void setupOrderPage(){
        orderPage = new OrderPage();
    }

    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }

    // 3.1. Creating an order
    @Test
    public void createOrder(){

        loginPage.locateUsernameAndInsertText(setupFunctions.getUsername());
        loginPage.locatePasswordAndInsertText(setupFunctions.getPassword());

        orderPage.clickButtonSignInAndGoToOrder();

        orderPage.usernameInsertText("New order");
        orderPage.phoneInsertNumbers("+37529872333");
        orderPage.commentInsertNumbers("Done");

        orderPage.buttonCreateOrder();

        orderPage.buttonOkWithCreatedOrderVisible();
    }

    // 3.2 Searching an order
    @Test
    public void searchOrderWithOrderNumber(){

        loginPage.locateUsernameAndInsertText(setupFunctions.getUsername());
        loginPage.locatePasswordAndInsertText(setupFunctions.getPassword());

        orderPage.clickButtonSignInAndGoToOrder();

        orderPage.usernameInsertText("New order");
        orderPage.phoneInsertNumbers("+37529872333");
        orderPage.commentInsertNumbers("Done");

        orderPage.buttonCreateOrder();

        orderPage.buttonOkWithCreatedOrderVisible();
        orderPage.clickButtonOkWithCreatedOrderVisible();

        orderPage.clickButtonStatusToSearchOrder();

        orderPage.fieldSearchOrder("4105");
        orderPage.clickButtonSearchOrder();
        orderPage.checkThatOrderCreated();
    }

    private class OrderPage {
        public void clickButtonSignInAndGoToOrder() {
            
        }

        public void phoneInsertNumbers(String s) {
            
        }

        public void commentInsertNumbers(String created) {
            
        }

        public void usernameInsertText(String newOrder) {
            
        }

        public void buttonCreateOrder() {
            
        }

        public void buttonOkWithCreatedOrderVisible() {
            
        }

        public void clickButtonOkWithCreatedOrderVisible() {
            
        }

        public void clickButtonStatusToSearchOrder() {
            
        }

        public void checkThatOrderCreated() {
            
        }

        public void fieldSearchOrder(String number) {
            
        }

        public void clickButtonSearchOrder() {
        }
    }

    private class LoginPage {
        public void locateUsernameAndInsertText(String username) {
            
        }

        public void locatePasswordAndInsertText(String password) {
            
        }
    }
}