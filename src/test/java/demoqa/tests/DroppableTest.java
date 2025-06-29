package demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import demoqa.TestBase;
import demoqa.pages.DroppablePage;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.qameta.allure.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class DroppableTest extends TestBase {

    DroppablePage droppablePage = new DroppablePage();

    @Epic("DemoQA")
    @Feature("Droppable")
    @Story("Drag and Drop validation")
    @Owner("Branch")
    @Test
    public void testDragAndDropWorks() {
        droppablePage.openPage();

        droppablePage.getDraggable().shouldBe(visible);
        droppablePage.getDroppable().shouldBe(visible);

        droppablePage.performDragAndDropWithOffset();

        sleep(1000); // allow DOM to update
        droppablePage.getDropText().shouldHave(text("Dropped!"));
    }

}
