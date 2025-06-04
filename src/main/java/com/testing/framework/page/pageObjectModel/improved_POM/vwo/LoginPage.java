package com.testing.framework.page.pageObjectModel.improved_POM.vwo;

import com.testing.framework.base.CommonToAll;
import com.testing.framework.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.testing.framework.driver.DriverManager.getDriver;

public class LoginPage extends CommonToAll {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Step 1 - Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("");
    private By error_message = By.id("js-login-btn");

    public String LoginToVWOInvalidLogin(String user, String pwd) {
        openVWOURL();
        enter_input(username, user);
        enter_input(password, pwd);
        clickElement(signButton);
        WaitHelpers.checkVisibility(getDriver(), error_message);
        return getText(error_message);
    }

    public void LoginToVWOValidLogin(String user, String pwd){
        openVWOURL();
        enter_input(username, user);
        enter_input(password, pwd);
        clickElement(signButton);

    }
}
