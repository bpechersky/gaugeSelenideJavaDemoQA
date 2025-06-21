package demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DroppablePage {

    public void openPage() {
        open("/droppable");
    }

    public SelenideElement getDraggable() {
        return $("#draggable");
    }

    public SelenideElement getDroppable() {
        return $("#droppable");
    }

    public SelenideElement getDropText() {
        return $("#droppable p");
    }



    public void performDragAndDrop() {
        actions()
                .clickAndHold(getDraggable())
                .moveToElement(getDroppable())
                .release()
                .perform();
    }

}
