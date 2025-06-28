package demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DroppableTest {

    @Test
    public void testDragAndDropWithOffsets() {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/droppable");

        // Ensure elements are visible
        $("#draggable").scrollIntoView(true).shouldBe(visible);
        $("#droppable").scrollIntoView(true).shouldBe(visible);

        WebElement source = $("#draggable").toWebElement();
        WebElement target = $("#droppable").toWebElement();

        // Get target location and use pixel offset
        int xOffset = target.getLocation().getX() - source.getLocation().getX() + 10;
        int yOffset = target.getLocation().getY() - source.getLocation().getY() + 10;

        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions
                .moveToElement(source)
                .clickAndHold()
                .moveByOffset(xOffset, yOffset)
                .pause(java.time.Duration.ofMillis(500))
                .release()
                .perform();

        sleep(1000); // Allow DOM update

        // Final assertion
        $("#droppable p").shouldHave(text("Dropped!"));
    }
}

