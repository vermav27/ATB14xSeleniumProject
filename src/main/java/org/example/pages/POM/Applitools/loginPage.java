package org.example.pages.POM.Applitools;

import org.example.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loginPage {

    private static final Logger logger = LogManager.getLogger(loginPage.class);

    WebDriver driver;

    //Constructor
    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    //Page Locators
    private By username = By.xpath("//input[@id='username']");
    private By password = By.xpath("//input[@id='password']");
    private By BTN_signIn = By.xpath("//a[@id='log-in']");


    //Page Actions
    public void loginToApp(String user,String pass){

        logger.info("Entering Login to the app.");
        driver.get(PropertiesReader.readKey("url_APPLITOOLS"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(BTN_signIn).click();
        logger.info("Logged In");

    }



}
