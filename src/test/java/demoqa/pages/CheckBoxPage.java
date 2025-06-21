package demoqa.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CheckBoxPage {
    public void openPage() {
        open("/checkbox");
    }

    public void expandAll() {
        $(".rct-option-expand-all").click();
    }

    public void selectNotes() {
        $x("//span[text()='Notes']/preceding-sibling::span[@class='rct-checkbox']").click();
    }

    public void verifyResult(String expectedText) {
        $("#result").shouldHave(text(expectedText));
    }
}
