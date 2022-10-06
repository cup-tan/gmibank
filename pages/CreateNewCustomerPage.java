package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustomerPage {

    public CreateNewCustomerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='search-ssn']")
    public WebElement ssnTextBox;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement ssnSearchButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstnameBox;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastnameBox;

    @FindBy(id = "tp-customer-middleInitial")
    public WebElement middleNameBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name='mobilePhoneNumber']")
    public WebElement mobilePhoneBox;

    @FindBy(id = "tp-customer-phoneNumber")
    public WebElement phoneNumberBox;

    @FindBy(id = "tp-customer-zipCode")
    public WebElement zipCodeBox;

    @FindBy(id = "tp-customer-address")
    public WebElement addressBox;

    @FindBy(id = "tp-customer-city")
    public WebElement cityBox;

    @FindBy(xpath = "//input[@id='tp-customer-ssn']")
    public WebElement ssnTextBox2;

    @FindBy(xpath = "//input[@id='tp-customer-createDate']")
    public WebElement createDateBox;

    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement countryBox;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement stateBox;

    @FindBy(xpath = "//select[@name='user.id']")
    public WebElement userBox;

    @FindBy(xpath = "//select[@id='tp-customer-account']")
    public WebElement AccountBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement addressFeedback;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement cityFeedback;



}
