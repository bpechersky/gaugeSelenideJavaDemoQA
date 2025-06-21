package demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TextBoxPage {

    public void openPage() {
        open("/text-box");

        // Remove interfering ads (iframes)
        sleep(1000); // brief wait to ensure ads load before removing
        executeJavaScript("document.querySelectorAll('iframe, #fixedban, .adsbygoogle')"
                + ".forEach(el => el.remove());");
    }

    public void fillForm(String name, String email, String address, String permAddress) {
        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(address);
        $("#permanentAddress").setValue(permAddress);

        // Scroll & click the button to avoid iframe obstruction
        $("#submit").scrollIntoView(true).click();
    }

    public void verifyOutput(String name, String email, String address, String permAddress) {
        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text(email));
        $("#output #currentAddress").shouldHave(text(address));
        $("#output #permanentAddress").shouldHave(text(permAddress));
    }

    public static class SortablePage {

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
}
