package demoqa.utils;

import io.qameta.allure.testng.AllureTestNg;

import java.io.File;

public class AllureListener extends AllureTestNg {
    public AllureListener() {
        System.setProperty("allure.results.directory", "target/allure-results");
        new File("target/allure-results").mkdirs(); // ensure dir exists
    }
}
