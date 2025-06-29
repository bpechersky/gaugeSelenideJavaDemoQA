package demoqa.tests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Listeners({AllureTestNg.class})
public class DroppableTest {

    public void removeAds() {
        try {
            sleep(1500); // Allow ads to load
            executeJavaScript(
                    "document.querySelectorAll(" +
                            "'iframe, #fixedban, .adsbygoogle, .grippy-host, " +
                            "[id^=\"google_ads_iframe\"], [id*=\"Ad.Plus\"], div[id$=\"container__\"]')" +
                            ".forEach(el => el.remove());"
            );
        } catch (Exception e) {
            System.out.println("Ad removal failed: " + e.getMessage());
        }
    }

    @Test
    public void testDragAndDropWorks() {
        open("https://demoqa.com/droppable");
        removeAds();

        SelenideElement source = $("#draggable");
        SelenideElement target = $("#droppable");

        // Use native Selenium Actions as fallback
        new Actions(WebDriverRunner.getWebDriver())
                .dragAndDrop(source, target)
                .perform();

        // Assertion
        target.shouldHave(text("Dropped!"));
    }
}
