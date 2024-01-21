package com.examples.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ProductPage {
    WebDriver driver;
    By product = By.xpath("//div[@class='inventory_item']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct() throws IOException {
        // Load configuration properties
        FileReader reader = new FileReader("C:\\Users\\admin\\IdeaProjects\\MyTestNGFramework\\PropertiesFile\\Config.properties");
        Properties data = new Properties();
        data.load(reader);

        // Get the product name from the configuration file
        String productName = data.getProperty("productName");

        // Print the product name to verify if it's read correctly
        System.out.println("Product Name: " + productName);

        // Find and click the "Add to Cart" button for the specified product
        List<WebElement> productElements = driver.findElements(product);
        for (WebElement productElement : productElements) {
            WebElement productNameElement = productElement.findElement(By.xpath(".//div[@class='inventory_item_name']"));
            if (productNameElement.getText().equalsIgnoreCase(productName)) {
                WebElement addToCart = productElement.findElement(By.xpath(".//button[text()='ADD TO CART']"));
                addToCart.click();
                break;
            }
        }
    }
}
