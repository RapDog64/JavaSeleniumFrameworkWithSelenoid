package com.weavesockstest;

import com.weavesocks.driver.Browser;
import com.weavesocks.driver.DriverFactory;
import com.weavesocks.pages.Constants;
import com.weavesocks.pages.MainPage;
import com.weavesocks.utilities.listeners.AllureListener;
import com.weavesocks.utilities.listeners.RetryTestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;


@Listeners({AllureListener.class, RetryTestListener.class})
public abstract class BaseTest {

    protected MainPage mainPage;

    @BeforeClass
    @Parameters({"browser", "version"})
    public void setUp(String browser, String version) {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver driver = driverFactory.createDriverInstance(browser, version);
        Browser.getDriverInstance().setDriver(driver);

        mainPage = new MainPage();
        mainPage.navigateToUrl(Constants.MAIN_PAGE);
    }

    @AfterClass
    public void tearDown() {
        Browser.getDriverInstance().driverQuit();
    }

    @AfterMethod
    public void logout() {
        mainPage.navigateToUrl(Constants.MAIN_PAGE);
    }
}
