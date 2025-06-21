package demoqa.tests;

import demoqa.TestBase;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SelectableTest extends TestBase {

    @Test
    public void testSelectableList() {
        open("/selectable");

        // Switch to List tab
        $("#demo-tab-list").click();

        // Click Item 1 and validate selection
        $$("#verticalListContainer li").get(0).click();
        $$("#verticalListContainer li").get(0).shouldHave(cssClass("active"));
    }
}
