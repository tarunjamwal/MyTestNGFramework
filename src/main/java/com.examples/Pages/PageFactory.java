package com.examples.Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage getLoginPage(){
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public ProductPage getProductPage()
    {
        if (productPage == null)
        {
            productPage = new ProductPage(driver);
        }
        return productPage;
    }



}