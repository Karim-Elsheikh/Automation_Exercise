package automationExercise.tests;

import automationExercise.Pages.*;
import org.testng.annotations.BeforeSuite;
import utilities.ExcelFileManager;
import utilities.JsonFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PropertiesReader;


public class AutomationTCs {

    WebDriver driver;

    AccountSuccessMessagePage successMessage;
    private utilities.PageRefactory.Factory PageRefactory;
    private JsonFileManager testData;
    private ExcelFileManager exceltestData;

    @BeforeMethod
    public void setup() {

        driver = PageRefactory.initiateDriver(System.getProperty("browserName"), true);
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/TestData.json");
        exceltestData = new ExcelFileManager("D:\\Selenium projects\\Automation_Exercise\\src\\test\\resources\\TestDataExcelFiles");


    }


    @AfterMethod
    public void teardown() {
        driver.quit();

    }



    @Test
    @Description("Sign up successfully and delete the account")
    @Severity(SeverityLevel.CRITICAL)
    public void Test() {
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
    public void properties() {
        PropertiesReader.loadProperties();
    }

}
