package automationExercise.tests;

import automationExercise.Pages.*;
import org.testng.annotations.BeforeSuite;
import utilities.JsonFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PageRefactory;
import utilities.PropertiesReader;


public class Automation {

    WebDriver driver;

    AccountSuccessMessagePage successMessage;
    private JsonFileManager testData;


    @BeforeMethod
    public void setup() {

        driver = PageRefactory.initiateDriver(System.getProperty("browserName"), true);
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/TestData.json");



    }


    @AfterMethod
    public void teardown() {
        driver.quit();

    }



    @Test
    @Description("Sign up successfully and delete the account")
    @Severity(SeverityLevel.CRITICAL)
    public void Test1() {
        new HomePage(driver)
                 .getUrl()
                 .clickOnsignupOrLoginButton();
        new SignupAndLoginPage(driver)
                 .fillAccountInformation(testData.getTestData("username"), testData.getTestData("mail"));
        new SignupFormPage(driver)
                .chooseGenderOption()
                .SelectDateOfBirth(testData.getTestData("AccountInformation.Day"), testData.getTestData("AccountInformation.Month"), testData.getTestData("AccountInformation.Year"))
                .fillAddressInformation(testData.getTestData("AccountInformation.Password"), testData.getTestData("AccountInformation.FirstName"), testData.getTestData("AccountInformation.LastName"), testData.getTestData("AccountInformation.Company"), testData.getTestData("AccountInformation.Address1"), testData.getTestData("AccountInformation.Address2"), testData.getTestData("AccountInformation.Country"), testData.getTestData("AccountInformation.State"), testData.getTestData("AccountInformation.City"), testData.getTestData("AccountInformation.ZipCode"), testData.getTestData("AccountInformation.MobileNumber"))
                .selectSignUpAndOffersCheckboxes()
                .clickOnCreateAccountButton();
        new AccountSuccessMessagePage(driver)
                      .assertAccountCreatedMessageIsDisplayed()
                      .clickContinueButton();
        new DeleteAccountPage(driver)
                 .assertOnLoggedInAsUserName()
                 .clickOnDeleteAccountButton()
                 .assertAccountDeletedMessageIsDisplayed();

    }


    @BeforeSuite
    public void Properties() {
        PropertiesReader.loadProperties();
    }

}
