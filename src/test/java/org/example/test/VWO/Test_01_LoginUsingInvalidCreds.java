package org.example.test.VWO;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.pages.POM.VWO.LoginPage;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_01_LoginUsingInvalidCreds {


    @Test
    @Owner("Vineet Verma")
    @Description("TC-01-Verify the error message on invalid username and password.")
    public void invalidCredsTest() {

        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        String errorMessage = loginPage.loginWithInvalidCreds(PropertiesReader.readKey("invalidUsername"), PropertiesReader.readKey("invalidPassword"));
        assertThat(errorMessage).isNotEmpty();
        driver.quit();

    }

}
