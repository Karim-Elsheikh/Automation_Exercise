package Loggin;

import org.apache.http.entity.mime.content.ByteArrayBody;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    WebDriver driver ;
    private By logoutButton = By.xpath("   //a[@href='/logout']");
    private By emailAddressFieldforLogin = By.xpath("//input[@data-qa='login-email']");
    private By passwordField = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");

    public LogoutPage(WebDriver driver) {
       this.driver=driver ;
    }

    public LogoutPage clickOnLoggoutButton(){

        driver.findElement(logoutButton).click();
        return this ;
    }
     public LogoutPage loginWithEmailAndPassword(String email ,String Password ){
        driver.findElement(emailAddressFieldforLogin).sendKeys(email);
        driver.findElement(passwordField).sendKeys(Password);
        driver.findElement(loginButton).click();



         return this ;
     }
}
