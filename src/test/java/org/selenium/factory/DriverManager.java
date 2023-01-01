package org.selenium.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.consts.BrowserType;

import java.time.Duration;

public class DriverManager {

public WebDriver initilizeDriver(){
    //WebDriverManager.chromedriver().setup();
   // WebDriverManager.chromedriver().cachePath("Drivers").setup();
    //WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
    //WebDriverManager.edgedriver().cachePath("Drivers").setup();
    //WebDriver driver = new ChromeDriver();
    //WebDriver driver= new FirefoxDriver();
    //WebDriver driver= new EdgeDriver();
    WebDriver driver;

    //driver.get("https://askomdch.com/");

    String browser=System.getProperty("browser","CHROME");

    switch (BrowserType.valueOf(browser)){
        case CHROME:
            WebDriverManager.chromedriver().cachePath("Drivers").setup();
            driver= new ChromeDriver();
            break;
        case FIREFOX:
            WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
            driver= new FirefoxDriver();
            break;
        case EDGE:
            WebDriverManager.edgedriver().cachePath("Drivers").setup();
            driver= new EdgeDriver();
            break;
        default:
                throw  new RuntimeException("Choose the correct Browser");
               // break;
    }

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

    return driver;

}
}
