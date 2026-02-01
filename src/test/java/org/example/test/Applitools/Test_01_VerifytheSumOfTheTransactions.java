package org.example.test.Applitools;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.base.commonToAll;
import org.example.driver.DriverManager;
import org.example.listeners.ScreenshotListener;
import org.example.pages.POM.Applitools.homePage;
import org.example.pages.POM.Applitools.loginPage;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Listeners(ScreenshotListener.class)
public class Test_01_VerifytheSumOfTheTransactions extends commonToAll {


    @Test
    @Description("TC-01-Verify the sum of the transactions.")
    @Owner("Vineet Verma")
    public void loginToAppAndVerifyTheSumOfTransactions(){

        loginPage loginPage = new loginPage(DriverManager.getDriver());
        loginPage.loginToApp(PropertiesReader.readKey("username_APPLITOOLS"),PropertiesReader.readKey("password_APPLITOOLS"));
        homePage homePage = new homePage(DriverManager.getDriver());
        homePage.verifyThatUserIsOnApp();
        Double spent = homePage.calculateTheTotalSpent();
        homePage.verifyTheSpentValue(1996.22,spent);

    }


}
