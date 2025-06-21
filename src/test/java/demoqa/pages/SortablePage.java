package demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SortablePage {

    public void openPage() {
        open("/sortable");
    }

    public void switchToListTab() {
        $("#demo-tab-list").click();
    }

    public SelenideElement getListItem(int index) {
        return $$("#demo-tabpane-list .list-group-item").get(index);
    }

    public void dragItemToPosition(int fromIndex, int toIndex) {
        SelenideElement source = getListItem(fromIndex);
        SelenideElement target = getListItem(toIndex);
        actions().dragAndDrop(source, target).perform();
    }
}
