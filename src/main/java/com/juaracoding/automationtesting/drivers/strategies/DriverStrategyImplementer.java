package com.juaracoding.automationtesting.drivers.strategies;

import com.juaracoding.automationtesting.drivers.managers.ChromeDriverManager;
import com.juaracoding.automationtesting.drivers.managers.FirefoxDriverManager;
import com.juaracoding.automationtesting.drivers.utils.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverStrategyImplementer implements IDriverStrategy {

    @Override
    public WebDriver setStrategy(String strategy) {
        switch (strategy) {
            case BrowserType.CHROME:
                return ChromeDriverManager.make();
            case BrowserType.FIREFOX:
                return FirefoxDriverManager.make();
            default:
                return ChromeDriverManager.make();

        }
    }

}
