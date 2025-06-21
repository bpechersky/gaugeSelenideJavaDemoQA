package demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DraggablePage {

    public void openPage() {
        open("/dragabble");
    }

    public SelenideElement getDraggableBox() {
        return $("#dragBox");
    }



    public void dragBox(int xOffset, int yOffset) {
        actions()
                .clickAndHold(getDraggableBox())
                .moveByOffset(xOffset, yOffset)
                .release()
                .perform();
    }

}
