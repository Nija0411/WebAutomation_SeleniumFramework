package com.testing.framework.tests.vwo;

import com.testing.framework.driver.DriverManager;
import com.testing.framework.page.pageObjectModel.improved_POM.vwo.DashBoardPage;
import com.testing.framework.page.pageObjectModel.improved_POM.vwo.LoginPage;
import com.testing.framework.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testing.framework.driver.DriverManager.driver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_PropertyReader_DriverManager_POM_CommonToAll {
    @Description("TC#1- Verify that with invalid email, password, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        // Page Class Code (POM Code) - 2
        LoginPage loginPage  = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.LoginToVWOInvalidLogin(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        // Assertions - 3
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));
    }

    @Owner("Nikhita")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {
        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.LoginToVWOValidLogin(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage  = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
    }
}
