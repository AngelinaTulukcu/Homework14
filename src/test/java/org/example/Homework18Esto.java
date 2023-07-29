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
    public void buttonLogiSisseActiveMobiilId(){

        Configuration.browser="chrome";
        open("https://profile.esto.ee/login/mobile-id");

        $(By.xpath("//*[@id='phone-field']/ ..//input[@class='esto-text-input-container__input']")).setValue("+3727345213");
        $(By.xpath("//*[@id='pin-field']/..//input[@class='esto-text-input-container__input']")).setValue("134563456");
//        $(By.xpath("//*[@id='pin-field']/ ..//input")).setValue("48812050267");

        $(By.xpath("//button[@estocypressdata='mobile-id-login-button']")).shouldBe(Condition.exist, Condition.visible);
    }

    // 2. Successful login Smart-ID
    @Test
    public void buttonLogiSisseActiveSmartId(){

        System.setProperty("selenide.browser","chrome");
        open ("https://profile.esto.ee/login/smart-id");

        $(By.xpath("//*[@id='login-field']/..//input[@class='esto-text-input-container__input']")).setValue("134563456");

        $(By.xpath("//button[@class='form-button esto-button esto-button__accent']")).shouldBe(Condition.exist,Condition.visible);
    }

    // 3. Successful login Parol
    @Test
    public void buttonLogiSisseActiveParool(){

        System.setProperty("selenide.browser","chrome");
        open("https://profile.esto.ee/login/password");

        $(By.xpath("//*[@id='login-field']/..//input[@class='esto-text-input-container__input']")).setValue("Angelina");
        $(By.xpath("//*[@id='password-field']/..//input[@class='esto-text-input-container__input']")).setValue("password");

        $(By.xpath("//button[@class='form-button esto-button esto-button__accent']")).shouldBe(Condition.exist, Condition.visible);
    }

    // 4. Unsuccessful login Smart-ID
    @Test
    public void errorForUnsuccessfulLoginSmartId (){

        System.setProperty("selenide.browser", "chrome");
        open("https://profile.esto.ee/login/smart-id");

        $(By.xpath("//*[@id='login-field']/..//input[@class='esto-text-input-container__input']")).setValue("111111111111");

        $(By.xpath("//button[@class='form-button esto-button esto-button__accent']")).click();

        $(By.xpath("//*[@class='error-text ng-star-inserted']")).shouldBe(Condition.exist, Condition.visible);
    }

    // 5. Unsuccessful login Parool
    @Test
    public void errorForUnsuccessfulLoginParool (){

        Configuration.browser="chrome";
        open("https://profile.esto.ee/login/password");

        $(By.xpath("//*[@id='login-field']/..//input[@class='esto-text-input-container__input']")).setValue("null");
        $(By.xpath("//*[@id='password-field']/..//input[@class='esto-text-input-container__input']")).setValue("null");

        $(By.xpath("//button[@class='form-button esto-button esto-button__accent']")).click();

        $(By.xpath("//span[@class='ng-star-inserted']")).shouldBe(Condition.exist,Condition.visible);
    }
}