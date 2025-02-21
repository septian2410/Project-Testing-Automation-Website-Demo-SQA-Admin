package com.juaracoding.automationtesting.test;

import com.juaracoding.automationtesting.drivers.DriverSingleton;
import com.juaracoding.automationtesting.pages.products.DashboardAddCategory;
import com.juaracoding.automationtesting.pages.authentications.DashboardLogOutPage;
import com.juaracoding.automationtesting.pages.authentications.DashboardPage;
import com.juaracoding.automationtesting.pages.authentications.SignInPage;
import com.juaracoding.automationtesting.pages.products.DashboardCategory;
import com.juaracoding.automationtesting.pages.products.DashboardEditCategory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoryTest {

    private WebDriver driver;
    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private DashboardLogOutPage dashboardLogOutPage;
    private DashboardAddCategory dashboardAddCategory;
    private DashboardCategory dashboardCategory;
    private DashboardEditCategory dashboardEditCategory;


    @BeforeClass
    public void setup() {
        driver = DriverSingleton.driver;
    }

    @BeforeMethod
    public void createObj() {
        signInPage = new SignInPage(driver);
        dashboardPage = new DashboardPage(driver);
        dashboardLogOutPage = new DashboardLogOutPage(driver);
        dashboardAddCategory = new DashboardAddCategory(driver);
        dashboardCategory = new DashboardCategory(driver);
        dashboardEditCategory = new DashboardEditCategory(driver);
    }


    //    Test Positive ++ (Save Button)
    @Test(priority = -1)
    public void testSaveCategory_Success() throws InterruptedException {
    driver.get("http://127.0.0.1:8000/admin");
        signInPage.loginActivity("pandu", "qwerty123");
        dashboardPage.AddCategoryActivity();

        String expectedUrl1 = "http://127.0.0.1:8000/admin/products/category/add/";
        String actualUrl1 = dashboardAddCategory.getUrlDashboardAddCategory();
            Assert.assertTrue(actualUrl1.contains(expectedUrl1),
                "URL does not contain the expected path. Found: " + actualUrl1);

        dashboardAddCategory.saveCategory("Kesehatan");

        String expectedUrl2 = "http://127.0.0.1:8000/admin/products/category/";
        String actualUrl2 = dashboardCategory.getUrlDashboardCategory();
            Assert.assertTrue(actualUrl2.contains(expectedUrl2),
                "URL does not contain the expected path. Found: " + actualUrl2);

        String expected = "The category “Kesehatan” was added successfully.";
        String actual = dashboardCategory.getTextCategorySuccess();
            Assert.assertEquals(actual, expected);

        dashboardPage.LogOutActivity();
        dashboardLogOutPage.LoginBack();
    }

    //    Test Negative -- (Save Button, Null)
    @Test()
    public void testSaveCategory_NullInput() throws InterruptedException {
    driver.get("http://127.0.0.1:8000/admin");
        signInPage.loginActivity("pandu", "qwerty123");
        dashboardPage.AddCategoryActivity();

        String expectedUrl1 = "http://127.0.0.1:8000/admin/products/category/add/";
        String actualUrl1 = dashboardAddCategory.getUrlDashboardAddCategory();
            Assert.assertTrue(actualUrl1.contains(expectedUrl1),
                "URL does not contain the expected path. Found: " + actualUrl1);

        dashboardAddCategory.saveCategory(" ");

        String expectedUrl2 = "http://127.0.0.1:8000/admin/products/category/";
        String actualUrl2 = dashboardCategory.getUrlDashboardCategory();
            Assert.assertTrue(actualUrl2.contains(expectedUrl2),
                "URL does not contain the expected path. Found: " + actualUrl2);

        String expected = "Please correct the error below.";
        String actual = dashboardAddCategory.getTextErrorInputCategoryElement();
            Assert.assertEquals(actual, expected);

        dashboardPage.LogOutActivity();
        dashboardLogOutPage.LoginBack();
    }

    //    Test Positive ++ (Save And Add Another)
    @Test()
    public void testSaveAndAddAnotherCategory_Success() throws InterruptedException {
    driver.get("http://127.0.0.1:8000/admin");
        signInPage = new SignInPage(driver);
        signInPage.loginActivity("pandu", "qwerty123");
        dashboardPage.AddCategoryActivity();

        String expectedUrl1 = "http://127.0.0.1:8000/admin/products/category/add/";
        String actualUrl1 = dashboardAddCategory.getUrlDashboardAddCategory();
            Assert.assertTrue(actualUrl1.contains(expectedUrl1),
                "URL does not contain the expected path. Found: " + actualUrl1);

        dashboardAddCategory.AddAnotherCategory("Teknologi");

        String expected = "The category “Teknologi” was added successfully. You may add another category below.";
        String actual = dashboardAddCategory.getTextCategorySuccessAdd();
            Assert.assertEquals(actual, expected);

        dashboardPage.LogOutActivity();
        dashboardLogOutPage.LoginBack();
    }

    //    Test Negative -- (Save And Add Another, Null)
    @Test()
    public void testSaveAndAddAnotherCategory_NullInput() throws InterruptedException {
    driver.get("http://127.0.0.1:8000/admin");
        signInPage.loginActivity("pandu", "qwerty123");
        dashboardPage.AddCategoryActivity();

        String expectedUrl1 = "http://127.0.0.1:8000/admin/products/category/add/";
        String actualUrl1 = dashboardAddCategory.getUrlDashboardAddCategory();
            Assert.assertTrue(actualUrl1.contains(expectedUrl1),
                "URL does not contain the expected path. Found: " + actualUrl1);

        dashboardAddCategory.AddAnotherCategory(" ");

        String expectedUrl2 = "http://127.0.0.1:8000/admin/products/category/";
        String actualUrl2 = dashboardCategory.getUrlDashboardCategory();
            Assert.assertTrue(actualUrl2.contains(expectedUrl2),
                "URL does not contain the expected path. Found: " + actualUrl2);

        String expected = "Please correct the error below.";
        String actual = dashboardAddCategory.getTextErrorInputCategoryElement();
            Assert.assertEquals(actual, expected);

        dashboardPage.LogOutActivity();
        dashboardLogOutPage.LoginBack();
    }

    //    Test Positive ++ (Save And Continue Editing)
    @Test()
    public void testSaveAndContinueEditingCategory_Success() throws InterruptedException {
    driver.get("http://127.0.0.1:8000/admin");
        signInPage.loginActivity("pandu", "qwerty123");
        dashboardPage.AddCategoryActivity();

        String expectedUrl1 = "http://127.0.0.1:8000/admin/products/category/add/";
        String actualUrl1 = dashboardAddCategory.getUrlDashboardAddCategory();
            Assert.assertTrue(actualUrl1.contains(expectedUrl1),
                "URL does not contain the expected path. Found: " + actualUrl1);

        dashboardAddCategory.ContinueEditingCategory("Hiburan");

        String expectedUrl2 = "http://127.0.0.1:8000/admin/products/category/\\d+/change/";
        String actualUrl2 = dashboardEditCategory.getUrlDashboardCategoryChange();
            Assert.assertTrue(actualUrl2.matches(expectedUrl2),
                "URL does not contain the expected path. Found: " + actualUrl2);

        String expected = "The category “Hiburan” was added successfully. You may edit it again below.";
        String actual = dashboardEditCategory.getTextCategorySuccessContinue();
            Assert.assertEquals(actual, expected);

        dashboardEditCategory.saveCategory();
        dashboardPage.LogOutActivity();
        dashboardLogOutPage.LoginBack();
    }

    //    Test Negative -- (Save And Continue,  Null)
    @Test(priority = 10)
    public void testSaveAndContinueEditingCategory_NullInput() throws InterruptedException {
    driver.get("http://127.0.0.1:8000/admin");
        signInPage.loginActivity("pandu", "qwerty123");
        dashboardPage.AddCategoryActivity();

        String expectedUrl1 = "http://127.0.0.1:8000/admin/products/category/add/";
        String actualUrl1 = dashboardAddCategory.getUrlDashboardAddCategory();
            Assert.assertTrue(actualUrl1.contains(expectedUrl1),
                "URL does not contain the expected path. Found: " + actualUrl1);

        dashboardAddCategory.ContinueEditingCategory(" ");

        String expectedUrl2 = "http://127.0.0.1:8000/admin/products/category/add/";
        String actualUrl2 = dashboardCategory.getUrlDashboardCategory();
            Assert.assertTrue(actualUrl2.contains(expectedUrl2),
                "URL does not contain the expected path. Found: " + actualUrl2);

        String expected = "Please correct the error below.";
        String actual = dashboardAddCategory.getTextErrorInputCategoryElement();
            Assert.assertEquals(actual, expected);

        dashboardPage.LogOutActivity();
        dashboardLogOutPage.LoginBack();
    }

}

