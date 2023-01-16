package org.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyFirstTest {

    /*
    Author: Kameswara Gandru
    GitHub link : https://github.com/Kamesh591
    Purpose: Starting the drivers with possible options
    Useful link: https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/
    Setting executable location from windows is possible with below command on windows
    Command: setx PATH "%PATH%;C:\WebDriver\bin"
    Note: It's always recomended to restart your IDE after setting up an environment path to read the latest PATH variables
     */
    @Test
    public void firstTest(){
        //System.setProperty("webdriver.driver.chromedriver","Chrome Driver path"); Here we did setup for Chrome Driver using Command: setx PATH "%PATH%;C:\WebDriver\bin"
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
        driver.findElement(By.cssSelector("#menu-item-1228 >a")).click();
        driver.quit();

    }


    @Test
    public void guestCheckoutUsingBankTransfer(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://askomdch.com/");
        driver.findElement(By.cssSelector("#menu-item-1228 >a")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.xpath("//button[@value='Search']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),"Search results: “Blue”");


        // Assert.assertEquals("","Search results: “Blue”");
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".product-name > a")).getText(),"Blue Shoes");
        driver.findElement(By.cssSelector(".wc-proceed-to-checkout >a")).click();

        Assert.assertEquals(driver.getTitle(),"Checkout – AskOmDch");

        driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("Jangry");
        driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("Jilebi");
        driver.findElement(By.cssSelector("#billing_company")).sendKeys("JJGroup");
        driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("James2");
        driver.findElement(By.cssSelector("#billing_address_2")).sendKeys("Backside of House");
        driver.findElement(By.cssSelector("#billing_city")).sendKeys("Lohagon");
        driver.findElement(By.cssSelector("#billing_postcode")).clear();
        driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("52334");
        driver.findElement(By.cssSelector("#billing_email")).sendKeys("james.ghruau@wucsdj.com");
        driver.findElement(By.cssSelector("button[name='woocommerce_checkout_place_order']")).click();


       String orderConfirmationText= driver.findElement(By.cssSelector(".woocommerce-order >p")).getText();
       Assert.assertEquals(orderConfirmationText,"Thank you. Your order has been received.");
       driver.quit();



    }

    @Test
    public void LoginAndCheckoutUsingBankTransfer(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://askomdch.com/");
        driver.findElement(By.cssSelector("#menu-item-1228 >a")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.xpath("//button[@value='Search']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),"Search results: “Blue”");

        // Assert.assertEquals("","Search results: “Blue”");
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".product-name > a")).getText(),"Blue Shoes");
        driver.findElement(By.cssSelector(".wc-proceed-to-checkout >a")).click();

        Assert.assertEquals(driver.getTitle(),"Checkout – AskOmDch");
        driver.findElement(By.cssSelector(".woocommerce-form-login-toggle a")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys("Kamesh591");
        driver.findElement(By.cssSelector("#password")).sendKeys("Welcome123");
        driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();
        driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("Jangry");
        driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("Jilebi");
        driver.findElement(By.cssSelector("#billing_company")).sendKeys("JJGroup");
        driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("James2");
        driver.findElement(By.cssSelector("#billing_address_2")).sendKeys("Backside of House");
        driver.findElement(By.cssSelector("#billing_city")).sendKeys("Lohagon");
        driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("52334");
        driver.findElement(By.cssSelector("#billing_email")).clear();
        driver.findElement(By.cssSelector("#billing_email")).sendKeys("james.ghruau@wucsdj.com");
        driver.findElement(By.cssSelector("button[name='woocommerce_checkout_place_order']")).click();
        String orderConfirmationText= driver.findElement(By.cssSelector(".woocommerce-order >p")).getText();
        Assert.assertEquals(orderConfirmationText,"Thank you. Your order has been received.");
        driver.quit();



    }
}
