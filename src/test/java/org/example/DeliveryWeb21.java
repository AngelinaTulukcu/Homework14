package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;

public class DeliveryWeb21 {
    static SetupFunctions setupFunctions;

    @BeforeAll
    public static void setupProperty(){
        setupFunctions = new SetupFunctions();
    }

    @BeforeEach
    public void setUp() {

        Selenide.open(setupFunctions.getBaseUrlWeb());
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    @Test
    public void insertBeforeAllIncorrectLoginPasswordAndCheckError(){

        LoginPage loginPage = new LoginPage();

        loginPage.locateUsernameAndInsertText("login");
        loginPage.locatePasswordAndInsertText("password");
        loginPage.clickSignIn();


        Selenide.$(By.xpath("//div[@data-name='authorizationError-popup']")).shouldBe(Condition.exist, Condition.visible);

    }

    @Test
    public void insertCorrectLoginPasswordAndCheckError(){

        LoginPage loginPage = new LoginPage();

        loginPage.locateUsernameAndInsertText(setupFunctions.getUsername());
        loginPage.locatePasswordAndInsertText(setupFunctions.getPassword());
        loginPage.clickSignIn();


        Selenide.$(By.xpath("//button[@data-name='createOrder-button']")).shouldBe(Condition.exist, Condition.visible);
        Selenide.$(By.xpath("//button[@data-name='openStatusPopup-button']")).shouldBe(Condition.exist, Condition.visible);
    }
}