package com.gmibank.pages;

import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomersPage {

    public ManageCustomersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "jh-create-entity")
    public WebElement createNewCustomer;


}

