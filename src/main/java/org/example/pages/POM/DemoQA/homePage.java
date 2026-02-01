package org.example.pages.POM.DemoQA;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.POM.Applitools.loginPage;
import org.example.utils.PropertiesReader;
import org.example.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class homePage {

    private static final Logger logger = LogManager.getLogger(loginPage.class);

    WebDriver driver;

    //Constructor
    public homePage(WebDriver driver){
        this.driver = driver;
    }

    //Page Locators
    private By rowToEdit = By.xpath("//div[@class='rt-tbody']/div[3]/div//span[@title='Edit']");
    private By firstName = By.xpath("//div[@id='firstName-wrapper']//input");
    private By BTN_submit = By.xpath("//button[@id='submit']");
    private By TBL_firstname = By.xpath("//div[@class='rt-tbody']/div[3]/div/div[1]");


    //Page Actions
    public void editTableRowAndVerifyTheNameAddedInRow(String nameToAdd){

        logger.info("Opening website Demo QA");
        driver.get(PropertiesReader.readKey("url_DEMOQA"));

        logger.info("Scrolling to take table into view");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");

        logger.info("Waiting for edit button for visibility");
        WaitHelpers.checkForVisibility(driver,rowToEdit);
        driver.findElement(rowToEdit).click();
        WaitHelpers.checkForVisibility(driver,firstName);

        logger.info("Clearing Text in field");
        driver.findElement(firstName).clear();

        logger.info("Entering Value " + nameToAdd);
        driver.findElement(firstName).sendKeys(nameToAdd);
        driver.findElement(BTN_submit).click();

        logger.info("Getting Value of the table cell & Verifying");
        String actualName = driver.findElement(TBL_firstname).getText();
        verifyTheNameInTableCell(nameToAdd,actualName);

    }

    public void verifyTheNameInTableCell(String nameAdded,String actualName){
        assertThat(actualName).isEqualTo(nameAdded);
    }

}
