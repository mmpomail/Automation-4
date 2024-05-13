package ru.netology.auto4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ElementsInteraction {

    DateSetting set = new DateSetting();

    @Test
    void testDeliveryCardWithExtendedData() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Са");
        $x("//*[text()='Санкт-Петербург']").click();
        $$("[type='tel']").first().doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(set.Generate(0));
        $("[role='grid']").sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        $("[name='name']").setValue("Петр Румянцев-Задунайский");
        $("[name='phone']").setValue("+79211234567");
        $("[data-test-id='agreement']").click();
        $(".button").click();
        $(withText("Встреча успешно забронирована")).shouldBe(visible, Duration.ofSeconds(15));

    }

}
