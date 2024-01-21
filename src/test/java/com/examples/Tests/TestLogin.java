package com.examples.Tests;

import com.examples.Pages.BasePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestLogin extends BasePage
{
    @Test
    public void VerifyLogin() throws IOException {
        pageFactory.getLoginPage().loginUser();
    }
}
