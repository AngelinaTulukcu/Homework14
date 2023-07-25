package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryWeb {
    //1.1 Login with incorrect data and error checking
    public static void main(String[] args) {
        open("http://51.250.6.164:3000/signin");
        $(By.id("username")).setValue("hello");
        $(By.id("password")).setValue("12345678");
        $(By.xpath("//*[@data-name = 'signIn-button']")).click();
        $(By.xpath("//*[@data-name = 'authorizationError-popup-close-button']")).shouldBe(Condition.exist);
        $(By.xpath("//*[@data-name = 'authorizationError-popup-close-button']")).shouldBe(Condition.visible);

        //1.2: Correct login and password, check the order page
        open("http://51.250.6.164:3000/signin");
        $(Selectors.byId("username")).setValue("angelina");
        $(Selectors.byId("password")).setValue("p14astwd63");
        $(byXpath("//*[@data-name = 'signIn-button']")).click();

        // 1.3: Incorrect login and password with error check and successful retry
        open("http://51.250.6.164:3000/signin");
        $(Selectors.byId("username")).setValue("invalid_username");
        $(Selectors.byId("password")).setValue("invalid_password");
        $(byXpath("//*[@data-name = 'signIn-button']")).click();
        $(byXpath("//*[@data-name = 'authorizationError-popup-close-button']"))
                .shouldBe(Condition.exist)
                .shouldBe(Condition.visible);

        // Retry with correct credentials
        $(Selectors.byId("username")).setValue("angelina");
        $(Selectors.byId("password")).setValue("p14astwd63");
        $(byXpath("//*[@data-name = 'signIn-button']")).click();

        // 1.4 Checking errors for minimum character count (2-3 scenarios)
        open("http://51.250.6.164:3000/signin");
        $(Selectors.byId("username")).setValue("a");
        $(Selectors.byId("password")).setValue("1");
        $(byXpath("//*[@data-name = 'signIn-button']")).click();
        $(byXpath("//*[@data-name = 'authorizationError-popup-close-button']"))
                .shouldBe(Condition.exist)
                .shouldBe(Condition.visible);

        // Test case 2: Invalid login and password with 2 characters
        open("http://51.250.6.164:3000/signin");
        $(Selectors.byId("username")).setValue("ab");
        $(Selectors.byId("password")).setValue("12");
        $(byXpath("//*[@data-name = 'signIn-button']")).click();
        $(byXpath("//*[@data-name = 'authorizationError-popup-close-button']"))
                .shouldBe(Condition.exist)
                .shouldBe(Condition.visible);

        // Test case 3: Invalid login and password with 3 characters
        open("http://51.250.6.164:3000/signin");
        $(Selectors.byId("username")).setValue("abc");
        $(Selectors.byId("password")).setValue("123");
        $(byXpath("//*[@data-name = 'signIn-button']")).click();
        $(byXpath("//*[@data-name = 'authorizationError-popup-close-button']"))
                .shouldBe(Condition.exist);
}
}
