package demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ResizablePage {

    public void openPage() {
        open("/resizable");
    }

    public SelenideElement getResizeHandle() {
        return $("#resizableBoxWithRestriction .react-resizable-handle");
    }

    public void resizeBox(int xOffset, int yOffset) {
        actions()
                .clickAndHold(getResizeHandle())
                .moveByOffset(xOffset, yOffset)
                .release()
                .perform();
    }
}
