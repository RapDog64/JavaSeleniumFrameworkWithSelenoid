package com.weavesocks.pages;

import com.weavesocks.driver.Browser;
import com.weavesocks.utilities.waiter.Waiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        driver = Browser.getDriverInstance().getThreadDriver();
        wait = new WebDriverWait(driver, 15);
    }

    protected void clickOnButton(By locator) {
        LOGGER.debug("Finds the element by locator: {}", locator);
        Waiter.waitForElement(locator);

        LOGGER.debug("Click on button: {}", locator);
        driver.findElement(locator).click();
    }

    protected WebElement findElement(String xpath) {
        LOGGER.info("Finds the element by xpath: {}", xpath);
        return driver.findElement(By.xpath(xpath));
    }

    protected void enterValue(String value, By locator) {
        LOGGER.info("Waits for the element by: {}", locator);
        Waiter.waitForElement(locator);

        LOGGER.info("clicks and clears an input field");
        driver.findElement(locator).click();
        driver.findElement(locator).clear();

        LOGGER.info("Enters text '{}' into the input field", value);
        driver.findElement(locator).sendKeys(value);
    }

    public abstract void navigateToUrl(String url);

}
