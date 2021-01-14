package com.weavesocks.utilities.waiter;

import com.weavesocks.driver.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    private static final Logger LOGGER = LogManager.getLogger(Waiter.class);
    private static final String TIMEOUT_EXCEPTION_WAS_IGNORED_MESSAGE = "A timeout exception was ignored ";

    private Waiter() {
    }

    public static void waitForElementEnabled(By locator) {
        LOGGER.debug("Waiting for locator'{}' enable", locator);
        try {
            new WebDriverWait(Browser.getDriverInstance().getThreadDriver(), Timeouts.NORMAL).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException | ElementClickInterceptedException e) {
            LOGGER.error(TIMEOUT_EXCEPTION_WAS_IGNORED_MESSAGE + e.getMessage());
        }
    }

    public static void waitForElement(By locator) {
        LOGGER.debug("Waiting for element '{}' clickable", locator);
        new WebDriverWait(Browser.getDriverInstance().getThreadDriver(), Timeouts.NORMAL).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElement(WebElement element) {
        LOGGER.debug("Waiting for element '{}' clickable", element);
        new WebDriverWait(Browser.getDriverInstance().getThreadDriver(), Timeouts.MEDIUM).until(ExpectedConditions.elementToBeClickable(element));
    }
}
