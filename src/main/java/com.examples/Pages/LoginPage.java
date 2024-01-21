package com.examples.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void loginUser() throws IOException {

        FileReader reader = new FileReader("C:\\Users\\admin\\IdeaProjects\\MyTestNGFramework\\PropertiesFile\\Config.properties");
        Properties data = new Properties();
        data.load(reader);

        driver.findElement(username).sendKeys(data.getProperty("username"));
        driver.findElement(password).sendKeys(data.getProperty("password"));
        driver.findElement(loginButton).click();

    }

}
