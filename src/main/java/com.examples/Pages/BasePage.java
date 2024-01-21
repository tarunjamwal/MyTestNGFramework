package com.examples.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {

    static WebDriver driver;
    protected static PageFactory pageFactory;

    @Parameters("browserName")
    @BeforeClass
    public static void Setup(@Optional("chrome")String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\MyTestNGFramework\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }

            FileReader reader = new FileReader("C:\\Users\\admin\\IdeaProjects\\MyTestNGFramework\\PropertiesFile\\Config.properties");
            Properties data = new Properties();
            data.load(reader);

            driver.manage().window().maximize();
            driver.get(data.getProperty("url"));
            pageFactory = new PageFactory(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    @AfterClass
//    public static void Close() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}

