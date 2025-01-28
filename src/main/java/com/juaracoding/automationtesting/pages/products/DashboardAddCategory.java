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

public class DashboardAddCategory {

    @FindBy(xpath = "//input[@id='id_name']")
    WebElement categoryElement;

    @FindBy(xpath = "//input[@name='_save']")
    WebElement buttonSave;

    @FindBy(xpath = "//input[@name='_addanother']")
    WebElement buttonAddAnother;

    @FindBy(xpath = "//input[@name='_continue']")
    WebElement buttonContinueEdit;

    @FindBy(xpath = "//p[@class='errornote']")
    WebElement categoryErrorElement;

    @FindBy(xpath = "//li[@class='success']")
    WebElement categorySuccessAddElement;

    private WebDriver driver;
    private WebDriverWait wait;

      public DashboardAddCategory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public String getUrlDashboardAddCategory() {
        System.out.println(driver.getCurrentUrl());
       return driver.getCurrentUrl();
    }

    public void fillCategory(String category) {
        categoryElement.sendKeys(category);
    }

    public void clickSaveButton() {
        buttonSave.click();
    }

    public void clickAddAnotherButton() {
        buttonAddAnother.click();
    }

    public void clickContinueEditButton() {
        buttonContinueEdit.click();
    }


    public void saveCategory(String category) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        fillCategory(category);
        TimeUnit.SECONDS.sleep(2);
        clickSaveButton();
    }

    public void AddAnotherCategory(String category) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        fillCategory(category);
        TimeUnit.SECONDS.sleep(2);
        clickAddAnotherButton();
    }

    public void ContinueEditingCategory(String category) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        fillCategory(category);
        TimeUnit.SECONDS.sleep(2);
        clickContinueEditButton();
    }

    public void waitForErrorInputCategoryElement() {
        By locator = By.xpath("//p[@class='errornote']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Tunggu elemen terlihat
    }

    public String getTextErrorInputCategoryElement() {
        waitForErrorInputCategoryElement(); // Tunggu elemen sebelum mengakses teksnya
        try {
            Thread.sleep(2000); // Berhenti selama 2 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return categoryErrorElement.getText(); // Kembalikan teks error (Input Null)
    }

    public void waitForCategorySuccesAddElement() {
        By locator = By.xpath("//li[@class='success']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Tunggu elemen terlihat
    }

    public String getTextCategorySuccessAdd() {
        waitForCategorySuccesAddElement(); // Tunggu elemen sebelum mengakses teksnya
        try {
            Thread.sleep(2000); // Berhenti selama 2 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return categorySuccessAddElement.getText(); // Kembalikan teks category success (Add category)
    }

}
