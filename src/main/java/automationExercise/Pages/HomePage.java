package automationExercise.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ElementActions;

public class HomePage {


    private WebDriver driver;
    private String url = "https://automationexercise.com/ ";


    private By getAccountDeleteed = By.xpath("//b[text()='Account Deleted!']");

    ////   Locators  \\\\
    private By signupOrLoginButton = By.xpath("//a[@href='/login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }


    ////   Actions  \\\\
    public void navigatetoUrl() {
        driver.navigate().to(url);

    }

@Step("Step 2: click on Signup button")
    public HomePage clickOnsignupOrLoginButton() {
       // driver.findElement(signupOrLoginButton).click();

    ElementActions.click(driver,signupOrLoginButton);
        return this;

    }

    @Step("Step 1 : get the url {url}")
    public HomePage getUrl() {
        driver.get(url);
        return this;
    }


}
