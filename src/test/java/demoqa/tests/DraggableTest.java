package demoqa.tests;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DraggableTest {

    public void removeAds() {
        try {
            sleep(1000); // wait for ads to load
            executeJavaScript(
                    "document.querySelectorAll('iframe, #fixedban, .adsbygoogle, .grippy-host')" +
                            ".forEach(el => el.remove());"
            );
        } catch (Exception e) {
            System.out.println("Ad removal failed: " + e.getMessage());
        }
    }

    @Test
    public void testBasicDraggable() {
        open("https://demoqa.com/dragabble");
        removeAds();

        // Ensure the page is scrolled to element
        SelenideElement draggable = $("#dragBox");
        draggable.shouldBe(visible);
        executeJavaScript("arguments[0].scrollIntoView(true);", draggable);

        // Perform drag by offset (x: 100, y: 100)
        actions().dragAndDropBy(draggable, 100, 100).perform();

        // Optionally verify element moved (if required)
        String styleAfter = draggable.getAttribute("style");
        System.out.println("Element style after drag: " + styleAfter);
    }
}
