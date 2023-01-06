package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.base.BasePage;
import org.selenium.dataobjects.BillingAddress;
import org.selenium.dataobjects.User;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage {



    private final By firstNamefield = By.cssSelector("#billing_first_name");
    private final By lastNameField = By.cssSelector("#billing_last_name");
    private final By billingCompanyField = By.cssSelector("#billing_company");
    private final By billingAddressField1 = By.cssSelector("#billing_address_1");
    private final By billingAddressField2 = By.cssSelector("#billing_address_2");
    private final By billingCityField = By.cssSelector("#billing_city");
    private final By billingPostalcodeField = By.cssSelector("#billing_postcode");
    private final By billingEmailField = By.cssSelector("#billing_email");
    private final By checkoutOrderBtn = By.cssSelector("button[name='woocommerce_checkout_place_order']");

    private final By orderConfirmation=By.cssSelector(".woocommerce-order >p");

    private final By userNameFld=By.cssSelector("#username");

    private final By passwordFld=By.cssSelector("#password");
    private final By loginSubmitBtn=By.cssSelector(".woocommerce-form-login__submit");
   private final By loginLink= By.cssSelector(".woocommerce-form-login-toggle a");

   private final By overlay= By.cssSelector(".blockUI.blockOverlay");

   private final By billingCountry= By.cssSelector("#billing_country");

   private final By billingState=By.cssSelector("#billing_state");

   private final By directBankTransferBtn=By.cssSelector("#payment_method_bacs");

    private final By alternateCountryDropDown = By.id("select2-billing_country-container");
    private final By alternateStateDropDown = By.id("select2-billing_state-container");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstNamefield(String firstName){
        WebElement element=waitForElementToBeVisible(firstNamefield);
        element.clear();
        element.sendKeys(firstName);
       /* driver.findElement(firstNamefield).clear();
        driver.findElement(firstNamefield).sendKeys(firstName);*/
        return this;
    }

    public CheckoutPage enterLastNameField(String lastName){
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckoutPage selectCountry(String countryName){
       /* Select select= new Select(driver.findElement(billingCountry));
        select.selectByVisibleText(countryName);*/

        wait.until(ExpectedConditions.elementToBeClickable(alternateCountryDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" + countryName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
    }

    public CheckoutPage selectState(String state){
        /*Select select= new Select(driver.findElement(billingState));
        select.selectByVisibleText(state);*/

        wait.until(ExpectedConditions.elementToBeClickable(alternateStateDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" + state + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
    }
    public CheckoutPage enterBillingCompanyField(String billingCompany){
        driver.findElement(billingCompanyField).clear();
        driver.findElement(billingCompanyField).sendKeys(billingCompany);
        return this;
    }

    public CheckoutPage enterBillingAddressField1(String billingAddress1){
        driver.findElement(billingAddressField1).clear();
        driver.findElement(billingAddressField1).sendKeys(billingAddress1);
        return this;
    }

    public CheckoutPage enterBillingAddressField2(String billingAddress2){
        driver.findElement(billingAddressField2).clear();
        driver.findElement(billingAddressField2).sendKeys(billingAddress2);
        return this;
    }

    public CheckoutPage enterBillingCityField(String billingCity){
        driver.findElement(billingCityField).clear();
        driver.findElement(billingCityField).sendKeys(billingCity);
        return this;
    }

    public CheckoutPage enterBillingPostalcodeField(String billingZipcode){
        driver.findElement(billingPostalcodeField).clear();
        driver.findElement(billingPostalcodeField).sendKeys(billingZipcode);
        return this;
    }

    public CheckoutPage enterBillingEmailField(String billingEmail){
        driver.findElement(billingEmailField).clear();
        driver.findElement(billingEmailField).sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage selectDirectBankTransferBtn(){
     WebElement e=   wait.until(ExpectedConditions.elementToBeClickable(directBankTransferBtn));

        System.out.println(e.isSelected());
     if (!e.isSelected()){
         e.click();
     }
     return this;

    }

    public CheckoutPage clickCheckoutOrderBtn() throws InterruptedException {
       // Thread.sleep(2000);
      /*List<WebElement> elements= driver.findElements(overlay);
      if (elements.size()>0){
          System.out.println("Number of Overlays is "+elements.size());
          new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfAllElements(elements));
          System.out.println("Overlays are visible");
      }*/
        //The above code has been moved to BasePage class for DRY principle
        waitForOverlayToDisappear(overlay);
        driver.findElement(checkoutOrderBtn).click();
        return this;
    }


    public String orderConfirmationMsg(){
        return driver.findElement(orderConfirmation).getText();
    }

    private void enterUserNameFld(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFld));
        driver.findElement(userNameFld).sendKeys(username);
    }

    private void enterPasswordFld(String password){
        driver.findElement(passwordFld).sendKeys(password);
    }

    private void clickLoginSubmitBtn(){
        driver.findElement(loginSubmitBtn).click();
    }

    private void clickLoginLink(){
        driver.findElement(loginLink).click();
    }

    /*
    org.openqa.selenium.ElementNotInteractableException: element not interactable exception observed
     */
    public CheckoutPage loginSubmission(String username, String password){
        clickLoginLink();

        enterUserNameFld(username);
        enterPasswordFld(password);
        clickLoginSubmitBtn();
        return this;
    }

    public CheckoutPage loginSubmission(User user){
        clickLoginLink();
        enterUserNameFld(user.getUsername());
        enterPasswordFld(user.getPassword());
        clickLoginSubmitBtn();
        return this;
    }

    public CheckoutPage fillBillingAddress(BillingAddress billingAddress){
        return enterFirstNamefield(billingAddress.getFirstName())
                .enterLastNameField(billingAddress.getLastName())
                .enterBillingCompanyField(billingAddress.getCompanyName())
                .enterBillingAddressField1(billingAddress.getAddressLineOne())
                .enterBillingAddressField2(billingAddress.getAddressLineOne())
                .enterBillingCityField(billingAddress.getCity())
                .enterBillingPostalcodeField(billingAddress.getPostalCode())
                .enterBillingEmailField(billingAddress.getEmailAddress())
                .selectCountry(billingAddress.getBillingCountry())
                .selectState(billingAddress.getBillingState());
    }



}
