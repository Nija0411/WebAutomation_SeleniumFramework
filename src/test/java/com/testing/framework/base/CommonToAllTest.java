package com.testing.framework.base;

import com.testing.framework.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class CommonToAllTest {

    @BeforeMethod
    public void setUp() {
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.down();
    }

}
