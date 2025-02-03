package com.juaracoding.automationtesting;

import com.juaracoding.automationtesting.drivers.DriverSingleton;
import com.juaracoding.automationtesting.drivers.utils.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class HookTest {

    @BeforeTest
    public void init() {
        System.out.println("init");
        DriverSingleton.getDriver(BrowserType.CHROME); // browser testing
    }


    @AfterTest
    public void teardown() {
        System.out.println("test selesai");
        DriverSingleton.quitDriver();
    }

}
