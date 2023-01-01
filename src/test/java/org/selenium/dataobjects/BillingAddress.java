package org.selenium.dataobjects;

public class BillingAddress {

    public BillingAddress(){

    }

    public BillingAddress (String firstName, String lastName,String companyName, String addressLineOne, String addressLineTwo, String city, String postalCode, String emailAddress){
        this.firstName=firstName;
        this.lastName=lastName;
        this.companyName=companyName;
        this.addressLineOne= addressLineOne;
        this.addressLineTwo=addressLineTwo;
        this.city=city;
        this.postalCode=postalCode;
        this.emailAddress=emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    private String firstName;
    private String lastName;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;

    private String billingCountry;

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    private String billingState;
    public String getCompanyName() {
        return companyName;
    }

    public BillingAddress setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    private String companyName;

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BillingAddress setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
        return this;
    }

    public BillingAddress setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
        return this;
    }

    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public BillingAddress setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public BillingAddress setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    private String postalCode;
    private String emailAddress;
}
