package demoqa;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.lang.Thread.sleep;

public class TestBase {

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }


    @BeforeMethod
    public void removeAds() {
        try {
            sleep(1000); // wait for ads to load
            executeJavaScript(
                    "document.querySelectorAll('iframe, #fixedban, .adsbygoogle, .grippy-host')" +
                            ".forEach(el => el.remove());"
            );
        } catch (Exception e) {
            System.out.println("Ad removal failed (probably no page loaded yet): " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}