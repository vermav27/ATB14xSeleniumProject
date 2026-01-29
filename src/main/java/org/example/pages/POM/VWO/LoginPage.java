package org.example.pages.POM.VWO;

import org.example.utils.PropertiesReader;
import org.example.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //PAGE LOCATORS
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signInButton = By.id("js-login-btn");
    private By errorMsg = By.id("js-notification-box-msg");



    //PAGE ACTIONS
    public String loginWithInvalidCreds(String usr,String pass){

        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signInButton).click();

        WaitHelpers.checkForVisibility(driver,errorMsg);

        String getErrorMsg = driver.findElement(errorMsg).getText();
        return getErrorMsg;

    }
}
