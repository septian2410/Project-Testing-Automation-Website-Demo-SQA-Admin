package com.juaracoding.automationtesting.test;

import com.juaracoding.automationtesting.drivers.DriverSingleton;
import com.juaracoding.automationtesting.pages.authentications.DashboardLogOutPage;
import com.juaracoding.automationtesting.pages.authentications.DashboardPage;
import com.juaracoding.automationtesting.pages.authentications.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest {

    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private DashboardLogOutPage dashboardLogOutPage;
    private WebDriver driver;


    @BeforeClass
    public void setup() {
        driver = DriverSingleton.driver;
    }

    @BeforeMethod
    public void createObj() {
        signInPage = new SignInPage(driver);
        dashboardPage = new DashboardPage(driver);
        dashboardLogOutPage = new DashboardLogOutPage(driver);
    }


//    Test Positive ++ (Button Login)
    @Test(priority = -1)
    public void signInTest_Success() throws InterruptedException {
    driver.get("http://127.0.0.1:8000/admin");
        signInPage.loginActivity("pandu", "qwerty123") ;

        String expected = "Welcome to Demo SQA Testing Portal";
        String actual = dashboardPage.getTextWelocmeHeadingElement();
            Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());

        dashboardPage.LogOutActivity();
        dashboardLogOutPage.LoginBack();
    }

//    Test Negative -- (Button Login, Not Correct)
    @Test
    public void signInTest_Invalid() throws InterruptedException {
    driver.get("http://127.0.0.1:8000/admin");
        signInPage.loginActivity("admin", "admin");

        String expected = "Please enter the correct username and password for a staff account. Note that both fields may be case-sensitive.";
        String actual = signInPage.getTextErrorNoteElement();
            Assert.assertEquals(actual, expected);
    }
}
