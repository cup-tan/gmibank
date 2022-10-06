package com.gmibank.step_definitions;

import com.gmibank.pages.AccountPageElements;
import com.gmibank.pages.CommonPageElements;
import com.gmibank.utilities.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountPageSteps {

    AccountPageElements accountPage = new AccountPageElements();
    CommonPageElements commonPage = new CommonPageElements();

    @Given("Click on My Operations")
    public void click_on_My_Operations() {
        commonPage.myOperations.click();
    }

    @Given("Click on Manage Accounts")
    public void click_on_Manage_Accounts() {
        commonPage.manageAccounts.click();
    }

    @Given("Click on Create a new Account")
    public void click_on_Create_a_new_Account() {
        commonPage.createNewAccount.click();
    }

    @When("provide description")
    public void provide_description() {
        accountPage.descriptionField.click();
        CommonMethods.sendText(accountPage.descriptionField, "New Account");
    }

    @When("enter Balance")
    public void enter_Balance() {
        CommonMethods.sendText(accountPage.balanceField, "1000");
    }

    @When("click on Save button")
    public void click_on_Save_button() {
        accountPage.saveButton.click();
    }

    @Then("account created toast message display")
    public void account_created_toast_message_display() throws InterruptedException {
        Assert.assertEquals(CommonMethods.jsGetInnerText(accountPage.toastMessage),
                "translation-not-found[gmiBankBackendApp.tPAccount.created]");
    }

    @Then("{string}  feedback is appeared")
    public void feedback_is_appeared(String string) {
        Assert.assertTrue(accountPage.invalidDescriptionFeedback.isDisplayed());
    }

    @When("click on Account Type")
    public void click_on_Account_Type() {
        accountPage.accountType.click();
    }

    @Then("Account Type options displayed")
    public void account_Type_options_displayed(io.cucumber.datatable.DataTable accountTypes) {
        SoftAssert softAssert = new SoftAssert();
        List<String> accounts = accountTypes.asList();
        for (int i = 0; i < accounts.size(); i++) {
            String expectedOption = accounts.get(i);
            Select select = new Select(accountPage.accountType);
            List<WebElement> options = select.getOptions();
            for (int y = 0; y < options.size(); y++) {
                softAssert.assertEquals(options.get(i).getAttribute("value"), expectedOption);
                break;
            }
            softAssert.assertAll();
        }
    }

    @Then("Account Type options selectable")
    public void account_Type_options_selectable(io.cucumber.datatable.DataTable accountTypes) {
        SoftAssert softAssert = new SoftAssert();
        List<String> accounts = accountTypes.asList();
        for (int i = 0; i < accounts.size(); i++) {
            String expectedOption = accounts.get(i);
            softAssert.assertTrue(CommonMethods.dropDownIsSelectedByVisibleText(accountPage.accountType, expectedOption));
        }
        softAssert.assertAll();
    }
}