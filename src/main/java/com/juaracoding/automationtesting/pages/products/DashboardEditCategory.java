package com.juaracoding.automationtesting.pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DashboardEditCategory {

    @FindBy(xpath = " //li[@class='success']")
    WebElement categoryElementSuccess;

    @FindBy(xpath = " //input[@name='_save']")
    WebElement buttonSave;

    private WebDriver driver;
    private WebDriverWait wait;

    public DashboardEditCategory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public String getUrlDashboardCategoryChange() {
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

        public void clickSaveButton() {
            buttonSave.click();
    }

    public void saveCategory() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
            clickSaveButton();
    }

    public void waitForCategorySuccessEditElement() {
        By locator = By.xpath("//li[@class='success']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Tunggu elemen terlihat
    }
    public String getTextCategorySuccessContinue() {
        waitForCategorySuccessEditElement();
        try {
            Thread.sleep(2000); // Berhenti selama 2 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return categoryElementSuccess.getText(); // Kembalikan teks category success (Edit category)
    }



}
