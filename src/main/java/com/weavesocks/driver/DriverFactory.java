package com.weavesocks.driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver createDriverInstance(String browser, String version) {
        WebDriver driver;
        switch (browser) {
            case "localChrome":
            case "localFirefox":
                throw new IllegalArgumentException("Unexpected value: " + browser);
            default:
                driver = new RemoteDriver().createDriver(browser, version);
        }

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
}
