package org.example;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class DeliveryWebHomework18 {

    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }

    // 1.1
    @Test
    public void insertIncorrectLoginPasswordAndCheckError(){

        open("http://51.250.6.164:3000/signin");

        $(By.xpath("//input[@data-name='username-input']")).setValue("1111");
        $(By.xpath("//input[@data-name='password-input']")).setValue ("1111");

        $(By.xpath("//button[@data-name='signIn-button']")).click();

        $(By.xpath("//div[@data-name='authorizationError-popup']")).shouldBe(Condition.exist, Condition.visible);
    }

    // 1.2
    @Test
    public void insertCorrectLoginPasswordAndCheckError(){
         
        SetupFunctions setupFunctions = new SetupFunctions();

        open("http://51.250.6.164:3000/signin");

        $(By.xpath("//input[@data-name='username-input']")).setValue(setupFunctions.getUsername());
        $(By.xpath("//input[@data-name='password-input']")).setValue (setupFunctions.getPassword());

        $(By.xpath("//button[@data-name='signIn-button']")).click();

        $(By.xpath("//button[@data-name='createOrder-button']")).shouldBe(Condition.exist, Condition.visible);
        $(By.xpath("//button[@data-name='openStatusPopup-button']")).shouldBe(Condition.exist, Condition.visible);
    }

    //1.3
    @Test
    public void insertIncorrectLoginPasswordAndCheckErrorAndRepeatSuccessfulLogin(){

            SetupFunctions setupFunctions = new SetupFunctions();
        open("http://51.250.6.164:3000/signin");
        $(By.xpath("//input[@data-name='username-input']")).setValue("Angelina");
        $(By.xpath("//input[@data-name='password-input']")).setValue("test");

        $(By.xpath("//button[@data-name='signIn-button']")).click();

        $(By.xpath("//button[@data-name='authorizationError-popup-close-button']")).shouldBe(Condition.exist, Condition.visible);

        $(By.xpath("//button[@data-name='authorizationError-popup-close-button']")).click();

        $(By.xpath("//input[@data-name='username-input']")).setValue(setupFunctions.getUsername());
        $(By.xpath("//input[@data-name='password-input']")).setValue(setupFunctions.getPassword());

        $(By.xpath("//button[@data-name='signIn-button']")).click();

        $(By.xpath("//input[@data-name='phone-input']")).shouldBe(Condition.exist, Condition.visible);

    }

    // 1.4
    @Test
    public void buttonSignInInactiveLogin1SymbolPassword8Symbols(){

        open("http://51.250.6.164:3000/signin");

        $(By.xpath("//input[@data-name='username-input']")).setValue("1");
        $(By.xpath("//input[@data-name='password-input']")).setValue("password");

        $(By.xpath("//button[@data-name='signIn-button']")).shouldBe(Condition.disabled);
        $(By.xpath("//*[@data-name='username-input']/..//span[@data-name='username-input-error']")).shouldBe(Condition.exist, Condition.visible);

    }

    // 1.4.1
    @Test
    public void buttonSignInInactiveLogin2SymbolsPassword1Symbol(){

        open("http://51.250.6.164:3000/signin");

        $(By.xpath("//input[@data-name='username-input']")).setValue("An");
        $(By.xpath("//input[@data-name='password-input']")).setValue("K");

        $(By.xpath("//button[@data-name='signIn-button']")).shouldBe(Condition.disabled);
        $(By.xpath("//*[@data-name='password-input']/..//span[@data-name='username-input-error']")).shouldBe(Condition.exist,Condition.visible);

    }

    // 1.4.2
    @Test
    public void buttonSignInInactiveLoginSpacePasswordSpace() {

        open("http://51.250.6.164:3000/signin");

        $(By.xpath("//input[@data-name='username-input']")).setValue("null");
        $(By.xpath("//input[@data-name='password-input']")).setValue("null");

        $(By.xpath("//button[@data-name='signIn-button']")).shouldBe(Condition.disabled);
        $(By.xpath("//*[@data-name='password-input']/..//span[@data-name='username-input-error']")).shouldBe(Condition.exist,Condition.visible);
    }
}
