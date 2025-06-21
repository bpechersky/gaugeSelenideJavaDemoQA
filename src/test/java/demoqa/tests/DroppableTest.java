package demoqa.tests;

import demoqa.TestBase;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DroppableTest extends TestBase {

    @Test
    public void testDragAndDrop() {
        open("/droppable");

        actions()
                .clickAndHold($("#draggable"))
                .moveToElement($("#droppable"))
                .release()
                .perform();

        $("#droppable p").shouldHave(text("Dropped!"));
    }
}
