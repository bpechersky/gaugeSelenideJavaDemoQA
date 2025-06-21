package demoqa.tests;

import demoqa.TestBase;
import demoqa.pages.CheckBoxPage;
import org.testng.annotations.Test;

public class CheckBoxTest extends TestBase {

    CheckBoxPage page = new CheckBoxPage();

    @Test
    public void testCheckNotesBox() {
        page.openPage();
        page.expandAll();
        page.selectNotes();
        page.verifyResult("notes");
    }
}
