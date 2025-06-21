package demoqa.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;

public class CheckBoxPage {

    public void openPage() {
        open("/checkbox");
        removeAds();
    }

    public void expandAll() {
        SelenideElement expandButton = $(".rct-option-expand-all");
        expandButton.shouldBe(visible).scrollIntoView(true);
        executeJavaScript("arguments[0].click();", expandButton);
    }

    public SelenideElement getCheckbox(String name) {
        return $$("label").findBy(text(name));
    }

    public SelenideElement getResult() {
        return $("#result");
    }

    private void removeAds() {
        sleep(1000);
        executeJavaScript(
                "document.querySelectorAll('iframe, #fixedban, .adsbygoogle, .grippy-host')" +
                        ".forEach(el => el.remove());"
        );
    }

    public void selectNotes() {
        $x("//span[text()='Notes']/preceding-sibling::span[@class='rct-checkbox']").click();
    }

    public void verifyResult(String expectedText) {
        $("#result").shouldHave(text(expectedText));
    }
}
