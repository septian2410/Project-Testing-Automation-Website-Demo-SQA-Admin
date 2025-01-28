package com.juaracoding.automationtesting;

import com.juaracoding.automationtesting.drivers.DriverSingleton;
import com.juaracoding.automationtesting.pages.authentications.DashboardLogOutPage;
import com.juaracoding.automationtesting.pages.authentications.DashboardPage;
import com.juaracoding.automationtesting.pages.authentications.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTestAdmin {

    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private DashboardLogOutPage dashboardLogOutPage;
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverSingleton.driver;
    }

//    Test Positive ++ (Button Login)
    @Test(priority = -1)
    public void signInTest() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/admin");
        signInPage = new SignInPage(driver);        // Fitur di uji
        dashboardPage = new DashboardPage(driver);
        dashboardLogOutPage = new DashboardLogOutPage(driver);

        signInPage.loginActivity("pandu", "qwerty123") ;

        String expected = "Welcome to Demo SQA Testing Portal";
        String actual = dashboardPage.getTextWelocmeHeadingElement();
//        Assert.assertTrue(actual.toLowerCase().equals(expected.toLowerCase()));
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());

        dashboardPage.LogOutActivity();
        dashboardLogOutPage.LoginBack();

    }

//    Test Negative -- (Button Login, Not Correct)
    @Test
    public void signInTest2() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/admin");
        signInPage = new SignInPage(driver);
        dashboardPage = new DashboardPage(driver);

        signInPage.loginActivity("admin", "admin");

        String expected = "Please enter the correct username and password for a staff account. Note that both fields may be case-sensitive.";
        String actual = signInPage.getTextErrorNoteElement();
        Assert.assertEquals(actual, expected);


    }

}
