package com.testing.framework.tests.vwo;

import com.testing.framework.base.CommonToAllTest;
import com.testing.framework.driver.DriverManager;
import com.testing.framework.page.pageObjectModel.normal_POM.DashBoardPage;
import com.testing.framework.page.pageObjectModel.normal_POM.LoginPage;
import com.testing.framework.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testing.framework.driver.DriverManager.driver;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_01_NormalScript_POM extends CommonToAllTest {

    @Owner("Nikhita")
    @Description("TC#1 Verify that with the invalid email, password error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {

        //Driver Manager Code -1
        //WebDriver driver = DriverManager.getDriver();

        //Page class code (POM code) -2
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        //Assertions -3
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));

    }

    @Owner("Nikhita")
    @Description("TC#2 Verify Login with Valid Credentials")
    @Test
    public void test_positive_vwo_login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOValidLoginCreds(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage = new DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.getLoggedInUserName();

        assertThat(usernameLoggedIn).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(usernameLoggedIn, PropertiesReader.readKey("expected_username"));


    }

}
