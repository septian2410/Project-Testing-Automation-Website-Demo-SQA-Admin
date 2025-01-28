package com.juaracoding.automationtesting.drivers.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager {

    public static WebDriver make() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("D:\\Tools\\chrome testing 130\\chrome-win64\\chrome.exe");
        options.addArguments("--start-maximized");

        return new ChromeDriver(options);
    }

}
