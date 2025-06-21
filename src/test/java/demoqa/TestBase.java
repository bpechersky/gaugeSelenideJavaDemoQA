package demoqa;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}