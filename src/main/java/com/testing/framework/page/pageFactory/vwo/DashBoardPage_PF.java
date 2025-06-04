package com.testing.framework.page.pageFactory.vwo;

import com.testing.framework.base.CommonToAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.testing.framework.utils.WaitHelpers.visibilityOfElement;

public class DashBoardPage_PF extends CommonToAll {
    WebDriver driver;

    public DashBoardPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-qa='lufexuloga']")
    private WebElement userNameOnDashboard;


    // Page Actions
    public String loggedInUserName() {
        visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}
