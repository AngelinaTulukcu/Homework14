package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Homework18Esto {

    // Task 2.2.
    // 1. Successful login Mobiil-ID
    @Test
    public void buttonLoginActiveMobilId(){

        Configuration.browser="chrome";
        open("https://profile.esto.ee/login/mobile-id");

        $(By.xpath("//*[@id='phone-field']/ ..//input[@class='esto-text-input-container__input']")).setValue("+375298888");
        $(By.xpath("//*[@id='pin-field']/..//input[@class='esto-text-input-container__input']")).setValue("1111");
//        $(By.xpath("//*[@id='pin-field']/ ..//input")).setValue("48812050267");

        $(By.xpath("//button[@estocypressdata='mobile-id-login-button']")).shouldBe(Condition.exist, Condition.visible);
    }

    // 2. Successful login Smart-ID
    @Test
    public void buttonLoginActiveSmartId(){

        System.setProperty("selenide.browser","chrome");
        open ("https://profile.esto.ee/login/smart-id");

        $(By.xpath("//*[@id='login-field']/..//input[@class='esto-text-input-container__input']")).setValue("88888888");

        $(By.xpath("//button[@class='form-button esto-button esto-button__accent']")).shouldBe(Condition.exist,Condition.visible);
    }

    // 3. Successful login Password
    @Test
    public void buttonLoginActivePassword(){

        System.setProperty("selenide.browser","chrome");
        open("https://profile.esto.ee/login/password");

        $(By.xpath("//*[@id='login-field']/..//input[@class='esto-text-input-container__input']")).setValue("Angelina");
        $(By.xpath("//*[@id='password-field']/..//input[@class='esto-text-input-container__input']")).setValue("test-password");

        $(By.xpath("//button[@class='form-button esto-button esto-button__accent']")).shouldBe(Condition.exist, Condition.visible);
    }

    // 4. Unsuccessful login Smart-ID
    @Test
    public void errorForUnsuccessfulLoginSmartId (){

        System.setProperty("selenide.browser", "chrome");
        open("https://profile.esto.ee/login/smart-id");

        $(By.xpath("//*[@id='login-field']/..//input[@class='esto-text-input-container__input']")).setValue("88888888");

        $(By.xpath("//button[@class='form-button esto-button esto-button__accent']")).click();

        $(By.xpath("//*[@class='error-text ng-star-inserted']")).shouldBe(Condition.exist, Condition.visible);
    }

    // 5. Unsuccessful login Password
    @Test
    public void errorForUnsuccessfulLoginPassword (){

        Configuration.browser="chrome";
        open("https://profile.esto.ee/login/password");

        $(By.xpath("//*[@id='login-field']/..//input[@class='esto-text-input-container__input']")).setValue("null");
        $(By.xpath("//*[@id='password-field']/..//input[@class='esto-text-input-container__input']")).setValue("null");

        $(By.xpath("//button[@class='form-button esto-button esto-button__accent']")).click();

        $(By.xpath("//span[@class='ng-star-inserted']")).shouldBe(Condition.exist,Condition.visible);
    }
}
