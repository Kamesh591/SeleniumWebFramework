package org.selenium.base;

import org.openqa.selenium.WebDriver;
import org.selenium.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    //We can add methods related to driver creation and quitting
    //Screenshot capture method also can be impleted here

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public WebDriver getDriver() {
        return this.driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    // protected WebDriver driver;






   @Parameters(value = "browser")
    @BeforeMethod
    public void startDriver(String browser){
        this.driver.set(new DriverManager().initilizeDriver(browser));

    }


    @AfterMethod
    public void quitDriver(){
        this.driver.get().quit();

    }
}
