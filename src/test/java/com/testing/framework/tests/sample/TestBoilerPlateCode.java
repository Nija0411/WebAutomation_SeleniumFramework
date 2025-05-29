package com.testing.framework.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBoilerPlateCode {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    @Description("Open Browser")
    public void openBrowser() {
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

    }

    @Test
    @Description("Verify Dry Run")
    @Severity(SeverityLevel.CRITICAL)
    public void getLogin() {
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
    }

    @AfterTest
    @Description("Close Browser")
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
