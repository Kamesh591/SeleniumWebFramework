package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.base.BasePage;

public class StorePage extends BasePage {

    private final  By searchField= By.id("woocommerce-product-search-field-0");
   private final By searchBtn=By.xpath("//button[@value='Search']");
   private final By title=By.cssSelector(".woocommerce-products-header__title.page-title");
  private final By addToCartBtn= By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
 private final By linkViewCart= By.cssSelector("a[title='View cart']");
    public StorePage(WebDriver driver) {
        super(driver);
    }

   /* public void enterTextInsearchField(String text){
        driver.findElement(searchField).sendKeys(text);
    }*/

    //advacned
    public StorePage enterTextInsearchField(String text){
        driver.findElement(searchField).sendKeys(text);

        return this;
    }
    public StorePage clickSearchBtn(){
        driver.findElement(searchBtn).click();
        return this;
    }
    public String getTitle(){
        return driver.findElement(title).getText();
    }

    public StorePage clickAddToCartBtn(){
        driver.findElement(addToCartBtn).click();
        return this;
    }

    public CartPage clickLinkViewCart(){
        driver.findElement(linkViewCart).click();
        return  new CartPage(driver);
    }
}
