package com.weavesocks.pages;

import com.weavesocks.utilities.waiter.Waiter;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(MainPage.class);
    private String authXpath = "//li[@id='%s']";

    private By logoutBtn = By.cssSelector("#logout > a");
    private By profileName = By.cssSelector("#howdy > a");
    private By formTitle = By.xpath("//div[@class='alert alert-danger']");

    @Step("Clicks on the '{nameOfBtn}' button")
    public MainPage click(String nameOfBtn) {

        WebElement element = findElement(String.format(authXpath, nameOfBtn));
        Waiter.waitForElement(element);
        element.click();

        return this;
    }

    @Step("Logs out")
    public MainPage logout() {
        LOGGER.info("Waits for the element: {}", logoutBtn);
        Waiter.waitForElement(logoutBtn);
        WebElement logoutElement = driver.findElement(logoutBtn);

        LOGGER.info("Clicks on the logout button if it is displayed");
        if (logoutElement.isDisplayed()) {
            logoutElement.click();
        }

        return this;
    }

    @Step("Gets the title of page")
    public String getTitle() {
        LOGGER.info("Gets title of the current page.");
        return driver.getTitle();
    }

    @Override
    @Step("Navigate to: {0}")
    public void navigateToUrl(String url) {
        LOGGER.info("Navigates to: {}", url);
        driver.navigate().to(url);
    }

    @Step("Gets user's name")
    public String getUserProfileName() {
        LOGGER.info("Gets user profile name");
        Waiter.waitForElement(profileName);

        LOGGER.info("Gets user profile name");
        return driver.findElement(profileName).getText();
    }

    @Step("Gets an invalid login credentials message")
    public String getInvalidLoginCredentialsMessage() {
        LOGGER.info("Waits the element with locator: {}", formTitle);
        Waiter.waitForElement(formTitle);

        LOGGER.info("Gets a message by locator: {}", formTitle);
        return driver.findElement(formTitle).getText();
    }
}
