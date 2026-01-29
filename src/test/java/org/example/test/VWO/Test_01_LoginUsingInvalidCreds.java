package org.example.test.VWO;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.base.commonToAll;
import org.example.driver.DriverManager;
import org.example.listeners.RetryAnalyzers;
import org.example.listeners.ScreenshotListener;
import org.example.pages.POM.VWO.LoginPage;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static org.assertj.core.api.Assertions.assertThat;

@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer=RetryAnalyzers.class)
public class Test_01_LoginUsingInvalidCreds extends commonToAll {


    private static final Logger logger = LogManager.getLogger(Test_01_LoginUsingInvalidCreds.class);


    @Test
    @Owner("Vineet Verma")
    @Description("TC-01-Verify the error message on invalid username and password.")
    public void invalidCredsTest() {


        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        logger.info("Invalid login start");
        String errorMessage = loginPage.loginWithInvalidCreds(PropertiesReader.readKey("invalidUsername"), PropertiesReader.readKey("invalidPassword"));
        Allure.addAttachment("Log output", "text/plain", "This is some log text");
        assertThat(errorMessage).isNotEmpty();

    }

}
