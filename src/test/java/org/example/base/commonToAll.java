package org.example.base;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class commonToAll {

    @BeforeMethod
    public void setup(){
        DriverManager.init();
    }

    @AfterMethod
    public void finish(){
        DriverManager.closeBrowser();
    }

}
