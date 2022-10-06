package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPageElements {

    public AccountPageElements(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input#tp-account-description")
    public WebElement descriptionField;

    @FindBy(xpath = "//input[@id='tp-account-balance']")
    public WebElement balanceField;

    @FindBy(xpath="//select[@id='tp-account-accountType']")
    public WebElement accountType;

    @FindBy(xpath="//select[@id='tp-account-accountStatusType']")
    public WebElement accountStatusType;

    @FindBy(xpath = "//select[@name='employee.id']")
    public WebElement employeeDropdown;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath="//div[@role='alert']")
    public WebElement toastMessage;

    @FindBy(xpath="//div[@class='invalid-feedback']")
    public WebElement invalidDescriptionFeedback;
}


