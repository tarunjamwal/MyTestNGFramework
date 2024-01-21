package com.examples.Tests;

import com.examples.Pages.BasePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestProduct extends BasePage
{
    @Test
    public void addProducts() throws IOException {
        pageFactory.getLoginPage().loginUser();
        pageFactory.getProductPage().addProduct();

    }
}
