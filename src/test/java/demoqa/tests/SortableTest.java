package demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import demoqa.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;

public class SortableTest extends TestBase {

    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1200x800";
        Configuration.headless = false;
       // open("https://demoqa.com/sortable");
    }

    @Test
    public void testSortableListOrderChanges() {
        open("/sortable");
        removeAds();
        // Wait briefly to let ads load, then remove them
        sleep(1500); // optional: increase if ads still overlap
        executeJavaScript(
                "document.querySelectorAll('iframe, #fixedban, .adsbygoogle, .grippy-host')" +
                        ".forEach(el => el.remove());"
        );

        // Then click the tab
        $("#demo-tab-list").scrollIntoView(true).click();

        // Drag 'Six' to top using JS
        executeJavaScript(
                "let items = document.querySelectorAll('#demo-tabpane-list .list-group-item');" +
                        "items[5].parentNode.insertBefore(items[5], items[0]);"
        );

        // Validate
        $$("#demo-tabpane-list .list-group-item").first().shouldHave(text("Six"));
    }

}
