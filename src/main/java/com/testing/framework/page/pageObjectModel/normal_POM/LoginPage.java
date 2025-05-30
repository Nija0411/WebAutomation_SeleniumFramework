package com.testing.framework.page.pageObjectModel.normal_POM;

import com.testing.framework.utils.PropertiesReader;
import com.testing.framework.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.testing.framework.driver.DriverManager.getDriver;
import static com.testing.framework.utils.WaitHelpers.waitJVM;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1: Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");

    //Step 2: Page Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        //waitJVM(5000);

        //OR
        WaitHelpers.checkVisibility(driver, error_message, 3);

        String error_msg_text = driver.findElement(error_message).getText();
        return error_msg_text;
    }

    public void loginToVWOValidLoginCreds(String user, String pwd) {
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        waitJVM(5000);

    }

}
