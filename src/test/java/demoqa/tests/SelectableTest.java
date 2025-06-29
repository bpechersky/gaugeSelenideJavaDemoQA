package demoqa.tests;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

public class SelectableTest {

    public void removeAds() {
        try {
            sleep(1500); // Wait longer to ensure all ads load
            executeJavaScript(
                    "document.querySelectorAll('iframe, #fixedban, .adsbygoogle, .grippy-host, " +
                            "[id^=\"google_ads_iframe\"], [id*=\"Ad.Plus\"], div[id$='container__'])" +
                            ".forEach(el => el.remove());"
            );
        } catch (Exception e) {
            System.out.println("Ad removal failed: " + e.getMessage());
        }
    }

    @Test
    public void testSelectableList() {
        open("https://demoqa.com/selectable");
        removeAds(); // 🔥 Important: Call before interacting

        // Scroll and click the first list item
        SelenideElement firstItem = $$("#verticalListContainer li").first();
        executeJavaScript("arguments[0].scrollIntoView(true);", firstItem);
        firstItem.click();
        firstItem.shouldHave(text("Cras justo odio")); // Optional assertion
    }
}
