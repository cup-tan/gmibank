package com.gmibank.step_definitions;

import com.gmibank.pages.CommonPageElements;
import com.gmibank.pages.UserInfo;
import com.gmibank.utilities.ConfigurationReader;
import com.gmibank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class User_Info_Step_Defs {
    WebDriver driver = Driver.getDriver();

    CommonPageElements commonPageElements = new CommonPageElements();
    UserInfo userInfo = new UserInfo();

    @Given("user is on the application_home page")
    public void user_is_on_the_application_home_page() {
        driver.get(ConfigurationReader.getProperty("gmi_url"));
    }

    @Given("user navigates to user_icon")
    public void user_navigates_to_user_icon() {
        commonPageElements.loginModule.click();

    }

    @Given("user clicks on sign_in button")
    public void user_clicks_on_sign_in_button() {
        commonPageElements.homePageSignIn.click();
    }

    @Given("user enters username {string}")
    public void user_enters_username(String string) {
        commonPageElements.userName.sendKeys(string);
    }

    @Given("user enters password {string}")
    public void user_enters_password(String string) {
        commonPageElements.password.sendKeys(string);
    }

    @Given("clicks on sign_in button")
    public void clicks_on_sign_in_button() {
        commonPageElements.signInButton.click();
    }

    @Given("user clicks on user_icon")
    public void user_clicks_on_user_icon() {
        userInfo.userModule.click();
    }

    @Given("user clicks on user_info")
    public void user_clicks_on_user_info() {
        userInfo.userInfo.click();
    }

    @Then("user verifies first_name has {string}")
    public void user_verifies_first_name_has(String string) {
        String firstName = userInfo.firstName.getAttribute("value");
        Assert.assertEquals(firstName, string);
    }

    @Then("user verifies last_name has {string}")
    public void user_verifies_last_name_has(String string) {
        String lastName = userInfo.lastName.getAttribute("value");
        Assert.assertEquals(lastName, string);
    }

    @Then("user verifies email has {string}")
    public void user_verifies_email_has(String string) {
        String email = userInfo.email.getAttribute("value");
        Assert.assertEquals(email, string);
    }

    @Then("user verifies languages are available")
    public void user_verifies_languages_are_available() {
        Select select1 = new Select(userInfo.language);
        List<WebElement> languages = select1.getOptions();
        for (WebElement each : languages) {
            boolean isTrue = !each.getText().isEmpty();

            Select select2 = new Select(Driver.getDriver().findElement(By.id("langKey")));
            List<WebElement> allLanguages = select2.getOptions();
            System.out.println("select.getAllSelectedOptions() = " + select2.getAllSelectedOptions());
            System.out.println("allLanguages = " + allLanguages);
            String actualEng = allLanguages.get(0).getText();
            String actualTr = allLanguages.get(1).getText();

            Assert.assertEquals(actualEng, "English");
            Assert.assertEquals(actualTr, "Turkish");
        }
    }

    @Then("user verify if firstname is updatable with {string}")
    public void user_verify_if_firstname_is_updatable_with(String string) {
        userInfo.firstName.clear();
        userInfo.firstName.sendKeys(string);
        userInfo.saveButton.click();
        String updatedFirstName = userInfo.firstName.getAttribute("value");
        Assert.assertTrue(updatedFirstName.contains(string));
    }

    @Then("user verify if lastname is updatable with {string}")
    public void user_verify_if_lastname_is_updatable_with(String string) {
        userInfo.lastName.clear();
        userInfo.lastName.sendKeys(string);
        userInfo.saveButton.click();
        String updatedLastName = userInfo.lastName.getAttribute("value");
        Assert.assertTrue(updatedLastName.contains(string));
    }

    @Then("user verify if email is updatable by adding {string}")
    public void user_verify_if_email_is_updatable_by_adding(String string) {
        userInfo.email.clear();
        userInfo.email.sendKeys(string);
        userInfo.saveButton.click();
        String updatedEmail = userInfo.email.getAttribute("value");
        Assert.assertTrue(updatedEmail.contains(string));
    }

    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }
}


