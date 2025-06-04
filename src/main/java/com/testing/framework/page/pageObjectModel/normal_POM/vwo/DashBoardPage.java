package com.testing.framework.page.pageObjectModel.normal_POM.vwo;

import com.testing.framework.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {

    WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    private final By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    // Action
    public String getLoggedInUserName() {
        WaitHelpers.waitJVM(10000); // Consider replacing with WebDriverWait
        driver.get("https://app.vwo.com/#/dashboard?accountId=1096012");
        return driver.findElement(userNameOnDashboard).getText();

    }
}
