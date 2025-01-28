package com.juaracoding.automationtesting.pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardCategory {

    @FindBy(xpath = " //li[@class='success']")
    WebElement categoryElementSuccess;

    private WebDriver driver;
    private WebDriverWait wait;

    public DashboardCategory(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getUrlDashboardCategory() {
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public void waitForCategorySuccessElement() {
        By locator = By.xpath("//li[@class='success']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Tunggu elemen terlihat
    }

    public String getTextCategorySuccess() {
        waitForCategorySuccessElement();
        try {
            Thread.sleep(2000); // Berhenti selama 2 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return categoryElementSuccess.getText(); // Kembalikan teks category success (Save Category)
    }

}

