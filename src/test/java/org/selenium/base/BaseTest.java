package org.selenium.base;

import org.openqa.selenium.WebDriver;
import org.selenium.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    //We can add methods related to driver creation and quitting
    //Screenshot capture method also can be impleted here

    protected WebDriver driver;

    @BeforeMethod
    public void startDriver(){
        driver= new DriverManager().initilizeDriver();

    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();

    }
}
