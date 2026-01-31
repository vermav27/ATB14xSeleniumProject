package org.example.pages.POM.Applitools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;

public class homePage {

    private static final Logger logger = LogManager.getLogger(homePage.class);

    WebDriver driver;

    public homePage(WebDriver driver){

        this.driver = driver;

    }

    //Page Locators
    private By transactionValues = By.xpath("//tbody/tr/td[5]/span");



    //Page Actions
    public void verifyThatUserIsOnApp(){

        logger.info("Start verification that user is on the app home page.");
        String appURL = driver.getCurrentUrl();
        assertThat(appURL).contains("app.html");
        logger.info("Verified user is on the home page.");

    }


    public Double calculateTheTotalSpent(){

        logger.info("Starting Calculating Value");
        List<WebElement> tableValues = driver.findElements(transactionValues);
        double Sum = 0;
        for(WebElement val:tableValues){

            logger.info("String value converting to double");
            String string_Value = "";
            String str_valueWithoutUSD = val.getText().replace(" USD", "");
            if(str_valueWithoutUSD.contains(",") || str_valueWithoutUSD.contains(" ")){
                String str_valueWithoutSpace = str_valueWithoutUSD.replace(" ","");
                String str_valueWithoutComma = str_valueWithoutSpace.replace(",","");
                string_Value = str_valueWithoutComma;
            }

            double int_valueWithoutUSD = Double.parseDouble(string_Value);
            logger.info("String value converted to double value.");
            Sum = Sum + int_valueWithoutUSD;

        }
        logger.info("Returning the spent value.");
        return Sum;
    }

    public void verifyTheSpentValue(Double expectedValue,Double actualValue){
        logger.info("Starting verifying the value");
        assertThat(actualValue).isEqualTo(expectedValue);
        logger.info("Value verified");

    }


}
