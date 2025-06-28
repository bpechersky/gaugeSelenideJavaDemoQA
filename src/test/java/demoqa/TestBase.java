package demoqa;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.lang.Thread.sleep;

public class TestBase {
    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        if (System.getenv("CI") != null) {
            Configuration.headless = true;
        }
        Configuration.browserSize = "1920x1080";
    }



    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

            // Allure reporting
    Configuration.reportsFolder = "build/allure-results";
    Configuration.screenshots = true;
    Configuration.savePageSource = true;

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