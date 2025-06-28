package demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.codeborne.selenide.WebDriverRunner;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;


public class DroppablePage {

    public void openPage() {
        open("/droppable");
    }

    public SelenideElement getDraggable() {
        return $("#draggable");
    }

    public SelenideElement getDroppable() {
        return $("#droppable");
    }

    public SelenideElement getDropText() {
        return $("#droppable p");
    }



    public void performDragAndDrop() {
        getDraggable().scrollIntoView(true).shouldBe(visible);
        getDroppable().scrollIntoView(true).shouldBe(visible);

        WebElement source = getDraggable().toWebElement();
        WebElement target = getDroppable().toWebElement();

        int xOffset = target.getLocation().getX() - source.getLocation().getX() + 10;
        int yOffset = target.getLocation().getY() - source.getLocation().getY() + 10;

        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(source)
                .clickAndHold()
                .moveByOffset(xOffset, yOffset)
                .pause(Duration.ofMillis(500))
                .release()
                .perform();
    }


}
