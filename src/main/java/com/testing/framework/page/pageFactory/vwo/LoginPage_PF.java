package com.testing.framework.page.pageFactory.vwo;

import com.testing.framework.base.CommonToAll;
import com.testing.framework.utils.PropertiesReader;
import com.testing.framework.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends CommonToAll {

    WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //you're telling Selenium: Hey, use this driver to initialize all @FindBy elements inside this class (LoginPage_PF).
    }

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(id = "js-notification-box-msg")
    private WebElement error_message;

    // Page Actions
    public String loginToVWOInvalidCreds() {

        try {
            openVWOURL();
            enter_input(username, PropertiesReader.readKey("invalid_username"));
            enter_input(password, PropertiesReader.readKey("invalid_password"));
            clickElement(signButton);
            WaitHelpers.waitJVM(5000);
        } catch (Exception e) {
            System.out.println("Elements Not found!");
        }
        return getText(error_message);

    }

}
