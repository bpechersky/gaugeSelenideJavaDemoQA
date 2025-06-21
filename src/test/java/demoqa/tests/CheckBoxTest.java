package demoqa.tests;

import demoqa.TestBase;
import demoqa.pages.CheckBoxPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class CheckBoxTest extends TestBase {

    CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void openCheckBoxPage() {
        checkBoxPage = new CheckBoxPage();
        checkBoxPage.openPage();
    }

    @Epic("DemoQA")
    @Feature("Checkbox")
    @Story("Expand All and Validate Elements")
    @Test
    public void testExpandAllAndVerifyVisibleOptions() {
        checkBoxPage.expandAll();
        // Just as an example - make sure some checkbox is visible
        checkBoxPage.getCheckbox("Desktop").shouldBe(visible);
        checkBoxPage.getCheckbox("Documents").shouldBe(visible);
    }

    @Test
    public void testSelectHomeCheckbox() {
        checkBoxPage.expandAll();
        checkBoxPage.getCheckbox("Home").click();
        checkBoxPage.getResult().shouldHave(text("home"));
    }

    @Test
    public void testSelectDesktopCheckbox() {
        checkBoxPage.expandAll();
        checkBoxPage.getCheckbox("Desktop").click();
        checkBoxPage.getResult().shouldHave(text("desktop"));
    }

    @Test
    public void testSelectDocumentsCheckbox() {
        checkBoxPage.expandAll();
        checkBoxPage.getCheckbox("Documents").click();
        checkBoxPage.getResult().shouldHave(text("documents"));
    }

    @Test
    public void testSelectMultipleCheckboxes() {
        checkBoxPage.expandAll();
        checkBoxPage.getCheckbox("Desktop").click();
        checkBoxPage.getCheckbox("Downloads").click();
        checkBoxPage.getResult().shouldHave(text("desktop")).shouldHave(text("downloads"));
    }




    @Test
    public void testCheckNotesBox() {
        checkBoxPage.openPage();
        checkBoxPage.expandAll();
        checkBoxPage.selectNotes();
        checkBoxPage.verifyResult("notes");
    }
}
