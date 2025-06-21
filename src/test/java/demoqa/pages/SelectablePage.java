package demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SelectablePage {

    public void openPage() {
        open("/selectable");
    }

    public void switchToListTab() {
        $("#demo-tab-list").click();
    }

    public SelenideElement getListItem(int index) {
        return $$("#verticalListContainer li").get(index);
    }

    public void selectItem(int index) {
        getListItem(index).click();
    }
}
