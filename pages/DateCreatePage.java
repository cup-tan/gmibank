package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class DateCreatePage {

    public DateCreatePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="account-menu")
    public WebElement loginModule;

    @FindBy(linkText = "Sign in")
    public  WebElement homePageSignIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;

    @FindBy(css="input#password")
    public WebElement password;

    @FindBy(css = "button.btn.btn-primary")
    public WebElement signInButton;

    @FindBy(linkText = "My Operations")
    public  WebElement myOperations;

    @FindBy(linkText = "Manage Customers")
    public  WebElement manageCustomer;

    @FindBy(linkText = "Create a new Customer")
    public  WebElement newCustomer;

    @FindBy(id="search-ssn")
    public  WebElement user_ssn;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    public  WebElement searchbutton;

    @FindBy(xpath ="//input[@id='tp-customer-firstName']")
    public WebElement firstname;

    @FindBy(xpath = "//input[@id='tp-customer-lastName']")
    public WebElement surname;

    @FindBy(xpath ="//input[@name='middleInitial']")
    public WebElement middleinitial;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name ='mobilePhoneNumber']")
    public WebElement mobileNumber;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@name='zipCode']")
    public WebElement zipcode;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement address;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement checkssn;

    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement country;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement state;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement save;

    @FindBy(xpath ="//div[@class='Toastify__toast-body']")
    public WebElement test;

    @FindBy(xpath="//div[@role='alert']")
    public WebElement toastMessage;

    @FindBy(xpath = "//select[@id='tp-customer-account']")
    public WebElement account;

    @FindBy(xpath = "//input[@name='zelleEnrolled']")
    public WebElement zelle;
}
