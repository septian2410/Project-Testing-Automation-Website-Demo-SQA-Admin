package com.juaracoding.automationtesting.pages.authentications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DashboardLogOutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[normalize-space()='Log in again']")
    private WebElement buttonLogInElement;

    public DashboardLogOutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        buttonLogInElement.click();
    }

    public void LoginBack( ) throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        clickLoginButton();
    }

}
