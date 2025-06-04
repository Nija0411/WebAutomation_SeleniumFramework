package com.testing.framework.base;

import com.testing.framework.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.testing.framework.driver.DriverManager.getDriver;

public class CommonToAll {

    // Instead of writing common action methods like click(), get(), getText(), and sendKeys() in each individual page class,
    // we will create a CommonToAllPages class to define and reuse these actions across all page classes.

    public CommonToAll() {
        // If you want to call something before every Page Object Class call, Put your Code here");
        // Open File, Open Data Base Connection You can write code here
    }

    public void openVWOURL() {
        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void openOrangeHRMURL() {
        getDriver().get(PropertiesReader.readKey("ohr_url"));
    }

    public void openKatalonURL() {
        getDriver().get(PropertiesReader.readKey("katalon_url"));
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by) {
        by.click();
    }

    public void enter_input(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enter_input(WebElement by, String key) {
        by.sendKeys(key);
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by) {
        return by.getText();
    }

}
