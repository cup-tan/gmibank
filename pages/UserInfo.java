package com.gmibank.pages;
import com.gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserInfo {
    public UserInfo(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="account-menu")
    public WebElement userModule;

    @FindBy(xpath = "//span[contains(text(), 'User Info')]")
    public  WebElement userInfo;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id="langKey")
    public WebElement language;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement saveButton;

}
