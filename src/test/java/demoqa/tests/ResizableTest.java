package demoqa.tests;

import demoqa.TestBase;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;

public class ResizableTest extends TestBase {

    @Test
    public void testResizableBox() {
        open("/resizable");

        SelenideElement resizeHandle = $("#resizableBoxWithRestriction .react-resizable-handle");

        actions()
                .clickAndHold(resizeHandle)
                .moveByOffset(100, 50)  // Resize by 100px right, 50px down
                .release()
                .perform();
    }
}
