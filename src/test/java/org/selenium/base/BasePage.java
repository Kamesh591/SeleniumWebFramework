package org.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait= new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    public void load(String endPoint){
        driver.get("https://askomdch.com"+endPoint);
    }

    /*
    Purpose: ExplicitWait implementation to check Element to disappear
    Selenium Doc: https://www.selenium.dev/documentation/webdriver/waits/
    Note: ExplicitWait polls for an element for every 500 milli seconds
     */
    public void waitForOverlayToDisappear(By overlay){
        List<WebElement> elements= driver.findElements(overlay);
        if (elements.size()>0){
            System.out.println("Number of Overlays is "+elements.size());
           // new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfAllElements(elements));
            wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
            System.out.println("Overlays are visible");
        }
        else {
            System.out.println("Overlays not visible");
        }
    }


    public WebElement waitForElementToBeVisible(By elemenet){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elemenet));
    }
}
