package Loggin;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ElementActions;
import utilities.JsonFileManager;

public class MainMenuPage {

    ////   Locators  \\\\

    private WebDriver driver;
    private JsonFileManager testData;
    private By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    private By loggedInAsUsername = By.cssSelector("a>b");




    ////   Actions  \\\\

    @Step("Step 8 : Click on Delete Account Button")
    public MainMenuPage deleteAccount() {
        ElementActions.click(driver, deleteAccountButton);
        return this;
    }

    ////   Validations  \\\\

    @Step("Step 7 :Assert on Logged In As User Name ")
    public MainMenuPage assertOnLoggedInAsUserName() {
        Assert.assertEquals(driver.findElement(loggedInAsUsername).getText(),testData.getjsonTestData("username") ,"user name not as expected !");
        System.out.println("User name is displayed and it is " + driver.findElement(loggedInAsUsername).getText());
        return this;
    }


    public MainMenuPage(WebDriver driver) {
        this.driver = driver;
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/TestData.json");

    }

}
