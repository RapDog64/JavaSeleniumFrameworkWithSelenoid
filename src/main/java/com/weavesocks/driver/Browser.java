package com.weavesocks.driver;

import org.openqa.selenium.WebDriver;


public class Browser {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static Browser driverInstance = new Browser();

    private Browser() {
    }

    public void driverQuit() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }

    public static Browser getDriverInstance() {
        return driverInstance;
    }

    public WebDriver getThreadDriver() {
        return DRIVER.get();
    }


    public void setDriver(WebDriver driver) {
        DRIVER.set(driver);
    }
}
