package org.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.base.BaseTest;
import org.selenium.dataobjects.BillingAddress;
import org.selenium.dataobjects.Products;
import org.selenium.dataobjects.User;
import org.selenium.pages.CartPage;
import org.selenium.pages.CheckoutPage;
import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
import org.selenium.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class MyFirstFrameworkTest extends BaseTest {

    /*
    Author: Kameswara Gandru
    GitHub link : https://github.com/Kamesh591
    Purpose: Writing a test case using Fluent interface implementation
    Useful link: https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/
    Setting executable location from windows is possible with below command on windows
    Command: setx PATH "%PATH%;C:\WebDriver\bin"
    Note: It's always recomended to restart your IDE after setting up an environment path to read the latest PATH variables
     */


    @Test
    public void guestCheckoutUsingBankTransfer() throws InterruptedException, IOException {

       // driver.get("https://askomdch.com/");
       /* BillingAddress billingAddress= new BillingAddress()
                .setFirstName("Ram")
                .setLastName("Sethu")
                .setAddressLineOne("James1")
                .setAddressLineTwo("Backyarg Ground")
                .setCity("Brookly")
                .setCompanyName("MBL Infra")
                .setPostalCode("23503")
                .setEmailAddress("takeabnow@mailosauu.io");*/

       // BillingAddress billingAddress = new BillingAddress("Ram","Sethu","MBLInfra","James1","Backyard Ground","Brookly","23456","abc@test.com");
       /* BillingAddress billingAddress= new BillingAddress();
        InputStream inputStream= getClass().getClassLoader().getResourceAsStream("BillingAddress.json");
        billingAddress= JacksonUtils.deSerializeJSON(inputStream,billingAddress);*/

        BillingAddress billingAddress= JacksonUtils.deSerializeJSON("BillingAddress.json",BillingAddress.class);
        Products products= new Products(1215);

        StorePage storePage = new HomePage(driver)
                .load()
                .clickStoreMenuLink()
                .enterTextInsearchField("Blue")
                .clickSearchBtn();
       /* StorePage storePage = homePage.clickStoreMenuLink();
        storePage.enterTextInsearchField("Blue")
                .clickSearchBtn();*/
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn();

        CartPage cartPage = storePage.clickLinkViewCart();
        Assert.assertEquals(cartPage.getProductName(), products.getName());
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        /*checkoutPage.enterFirstNamefield("John")
                .enterLastNameField("Kumar")
                .enterBillingCompanyField("MBL Infra")
                .enterBillingAddressField1("James2")
                .enterBillingAddressField2("Backyard states")
                .enterBillingCityField("Lohegon")
                .enterBillingPostalcodeField("23478")
                .enterBillingEmailField("xyz@jamesbookr.com")
                .clickCheckoutOrderBtn();*/
        checkoutPage.fillBillingAddress(billingAddress)
                .selectDirectBankTransferBtn()
                        .clickCheckoutOrderBtn();
        Assert.assertEquals(checkoutPage.orderConfirmationMsg(), "Thank you. Your order has been received.");

    }

    @Test
    public void LoginAndCheckoutUsingBankTransfer() throws InterruptedException, IOException {

        BillingAddress billingAddress= JacksonUtils.deSerializeJSON("BillingAddress.json",BillingAddress.class);
        User user= new User("Kamesh591", "Welcome123");

       // driver.get("https://askomdch.com/");
        HomePage homePage = new HomePage(driver).load();
        StorePage storePage = homePage.clickStoreMenuLink();
        storePage.enterTextInsearchField("Blue")
                .clickSearchBtn();
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn();
        CartPage cartPage = storePage.clickLinkViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
       // checkoutPage.loginSubmission("Kamesh591", "Welcome123")
        checkoutPage.loginSubmission(user)
                .fillBillingAddress(billingAddress)
                .clickCheckoutOrderBtn();

               /* .enterFirstNamefield("John")
                .enterLastNameField("Kumar")
                .enterBillingCompanyField("MBL Infra")
                .enterBillingAddressField1("James2")
                .enterBillingAddressField2("Backyard states")
                .enterBillingCityField("Lohegon")
                .enterBillingPostalcodeField("23478")
                .enterBillingEmailField("xyz@jamesbookr.com")
                .clickCheckoutOrderBtn();*/
        Assert.assertEquals(checkoutPage.orderConfirmationMsg(), "Thank you. Your order has been received.");

       /* Assert.assertEquals(driver.getTitle(), "Checkout – AskOmDch");
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
        String orderConfirmationText = driver.findElement(By.cssSelector(".woocommerce-order >p")).getText();
        Assert.assertEquals(orderConfirmationText, "Thank you. Your order has been received.");
        driver.quit();
*/

    }
}
