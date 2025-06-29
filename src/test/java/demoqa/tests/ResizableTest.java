package demoqa.tests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ResizableTest {

    public void removeAds() {
        try {
            sleep(1500); // allow ads to load
            executeJavaScript("document.querySelectorAll('iframe, #fixedban, .adsbygoogle, .grippy-host, [id^=\"google_ads_iframe\"], div[id*=\"container__\"]').forEach(el => el.remove())");
        } catch (Exception e) {
            System.out.println("Ad removal failed: " + e.getMessage());
        }
    }

    @Test
    public void testResizableBox() {
        open("https://demoqa.com/resizable");
        removeAds();

        SelenideElement resizeHandle = $("#resizableBoxWithRestriction .react-resizable-handle");

        // Scroll the handle into view to avoid MoveTargetOutOfBoundsException
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", resizeHandle);
        sleep(500); // Let scroll complete

        Point handleLocation = resizeHandle.getLocation();
        System.out.println("Handle location: " + handleLocation);

        // Perform resize
        new Actions(WebDriverRunner.getWebDriver())
                .moveToElement(resizeHandle)
                .clickAndHold()
                .moveByOffset(100, 100) // Resize by 100px right and down
                .release()
                .perform();

        sleep(1000); // just for visual check
    }
}
