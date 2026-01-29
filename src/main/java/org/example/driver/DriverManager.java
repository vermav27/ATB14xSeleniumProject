package org.example.driver;

import org.apache.commons.lang3.ObjectUtils;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    //To start the browser
    public static void init(){

        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();

        switch (browser){
            case  "edge" :
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "chrome" :
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--guest");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox" :
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--guest");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.println("No Browser Supported !");
                }

    }


    //To close the browser
    public static void closeBrowser(){

        if(getDriver() != null){
            driver.quit();
            driver = null;
        }

    }
}
