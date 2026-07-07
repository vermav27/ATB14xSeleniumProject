package org.example.driver;

import org.apache.commons.lang3.ObjectUtils;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.Dimension;
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

        boolean headless = Boolean.parseBoolean(
                System.getProperty("headless", "false"));

        switch (browser){
            case  "edge" :
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");

                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                }

                driver = new EdgeDriver(edgeOptions);
                if (headless) {
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                } else {
                    driver.manage().window().maximize();
                }

                break;
            case "chrome" :
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--guest");

                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }

                driver = new ChromeDriver(chromeOptions);
                if (headless) {
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                } else {
                    driver.manage().window().maximize();
                }

                break;
            case "firefox" :
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--guest");

                if (headless) {
                    firefoxOptions.addArguments("-headless");
                }

                driver = new FirefoxDriver(firefoxOptions);
                if (headless) {
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                } else {
                    driver.manage().window().maximize();
                }

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
