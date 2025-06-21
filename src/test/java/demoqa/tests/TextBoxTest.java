package demoqa.tests;

import demoqa.TestBase;
import demoqa.pages.TextBoxPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxTest extends TestBase {

    TextBoxPage textBox = new TextBoxPage();

    @Test
    public void testFillTextBoxForm() {
        textBox.openPage();
        textBox.fillForm("John Doe", "john@example.com", "123 Elm St", "456 Oak St");
        textBox.verifyOutput("John Doe", "john@example.com", "123 Elm St", "456 Oak St");
    }


}