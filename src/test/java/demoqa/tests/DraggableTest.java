package demoqa.tests;

import demoqa.TestBase;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class DraggableTest extends TestBase {

    @Test
    public void testBasicDraggable() {
        open("/dragabble");


        actions()
                .clickAndHold($("#dragBox"))
                .moveByOffset(150, 80)
                .release()
                .perform();
    }
    }

