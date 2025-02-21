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

public class SignInPage {

    private WebDriverWait wait;

    // Elemen Web yang Diidentifikasi
    @FindBy(id = "id_username"      )
    WebElement usernameElement;

    @FindBy(id = "id_password")
    WebElement passwordElement;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement buttonSignInElement;

    @FindBy(xpath = "//p[@class='errornote']")
    WebElement errornote;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);                  // Inisialisasi Elemen Web yang Diidentifikasi
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //  Mengatur waktu tunggu
    }

        public void fillUsername(String username) {
            usernameElement.sendKeys(username);
        }
        public void fillPassword(String password) {
            passwordElement.sendKeys(password);
        }
        public void clickLoginButton() {
            buttonSignInElement.click();
        }

    public void loginActivity(String username, String password) throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);   // Menunggu 2 detik
            fillUsername(username);
        TimeUnit.SECONDS.sleep(2);
            fillPassword(password);
        TimeUnit.SECONDS.sleep(2);
            clickLoginButton();
    }

        public void waitForErrorNoteElement() {
            By locator = By.xpath("//p[@class='errornote']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Tunggu elemen terlihat di browser
        }
        public String getTextErrorNoteElement() {
            waitForErrorNoteElement(); // Tunggu elemen sebelum mengakses teksnya
            String errorMessage = errornote.getText(); // Ambil teks dari elemen
            try {
                Thread.sleep(2000); // Berhenti selama 2 detik
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return errorMessage; // Kembalikan teks error (login not correct)
        }


}
