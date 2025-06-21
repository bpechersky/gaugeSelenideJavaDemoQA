package demoqa.tests;

import demoqa.TestBase;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;


public class SortableTest extends TestBase {

    @Test
    public void testSortableListOrderChanges() {
        open("/sortable");

        // Switch to List tab if needed
        $("#demo-tab-list").click();

        // Drag and drop example: swap first and last
        var items = $$("#demo-tabpane-list .list-group-item");
        SelenideElement firstItem = items.first();
        SelenideElement lastItem = items.last();

        actions().dragAndDrop(firstItem, lastItem).perform();

        // Validate order changed
        $$("#demo-tabpane-list .list-group-item").last().shouldHave(text("One"));
    }
}
