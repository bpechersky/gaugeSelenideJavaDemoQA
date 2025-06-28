package demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import demoqa.TestBase;
import demoqa.pages.DroppablePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DroppableTest extends TestBase {

    DroppablePage droppablePage = new DroppablePage();

    @Test
    public void testDragAndDropWithOffsets() {
        Configuration.browserSize = "1920x1080";

        droppablePage.openPage();

        // Ensure elements are visible
        droppablePage.getDraggable().scrollIntoView(true).shouldBe(visible);
        droppablePage.getDroppable().scrollIntoView(true).shouldBe(visible);

        WebElement source = droppablePage.getDraggable().toWebElement();
        WebElement target = droppablePage.getDroppable().toWebElement();

        int xOffset = target.getLocation().getX() - source.getLocation().getX() + 10;
        int yOffset = target.getLocation().getY() - source.getLocation().getY() + 10;

        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(source)
                .clickAndHold()
                .moveByOffset(xOffset, yOffset)
                .pause(java.time.Duration.ofMillis(500))
                .release()
                .perform();

        droppablePage.getDropText().shouldHave(text("Dropped!"));
    }
}
