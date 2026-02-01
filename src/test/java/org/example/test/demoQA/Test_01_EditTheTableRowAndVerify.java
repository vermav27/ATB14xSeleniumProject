package org.example.test.demoQA;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.base.commonToAll;
import org.example.driver.DriverManager;
import org.example.listeners.ScreenshotListener;
import org.example.pages.POM.DemoQA.homePage;
import org.example.utils.PropertiesReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class Test_01_EditTheTableRowAndVerify extends commonToAll {

    @Test
    @Description("TC-01-Verify the value in the table after editing the table.")
    @Owner("Vineet Verma")
    public void loginToAppAndVerifyTheSumOfTransactions(){

        homePage homePage = new homePage(DriverManager.getDriver());
        homePage.editTableRowAndVerifyTheNameAddedInRow("Vineet");

    }

}
