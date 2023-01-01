package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.base.BasePage;

public class CartPage extends BasePage {

   /* private final  By productName= By.cssSelector(".product-name > a");

    private final By checkoutBtn=By.cssSelector(".wc-proceed-to-checkout >a");*/

    @FindBy(css = ".product-name > a") private WebElement productName;
    @FindBy(how = How.CSS,using=".wc-proceed-to-checkout >a") @CacheLookup private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver,this);
    }


   /* This implemented with By locator strategy
   public String getProductName(){
      return   wait.until(ExpectedConditions.presenceOfElementLocated(productName)).getText();
     //   return driver.findElement(productName).getText();
    }*/

    /*
    This method is implemented using FindBy annotation strategy
     */
    public String getProductName(){
        return   wait.until(ExpectedConditions.visibilityOf(productName)).getText();
        //   return driver.findElement(productName).getText();
    }

    public CartPage clickAddToCartBtn(){
       // driver.findElement(addToCartBtn).click();
        return this;
    }

    public CheckoutPage clickCheckoutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
       // driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }

}
