package com.juaracoding.automationtesting.pages.authentications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DashboardPage {

    private WebDriverWait wait;

    @FindBy(xpath = "//h1[normalize-space()='Welcome to Demo SQA Testing Portal']")
    private WebElement welcomeHeadingElement;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonLogoutElement;

    @FindBy(xpath = "//a[@href='/admin/products/category/add/']")
    private WebElement buttonAddCategory;

    public DashboardPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }


    public void waitForWelcomeHeadingElement() {
        By locator = By.xpath("//h1[normalize-space()='Welcome to Demo SQA Testing Portal']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getTextWelocmeHeadingElement() {
        waitForWelcomeHeadingElement();
        return welcomeHeadingElement.getText(); // Kembalikan teks DashboardPage
    }


        public void clickAddCategoryButton() {
            buttonAddCategory.click();
        }

        public void clickLogOutButton() {
            buttonLogoutElement.click();
        }


    public void AddCategoryActivity( ) {
        clickAddCategoryButton();
    }

    public void LogOutActivity( ) throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        clickLogOutButton();
    }


}
