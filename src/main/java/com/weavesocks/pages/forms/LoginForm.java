package com.weavesocks.pages.forms;

import com.weavesocks.models.User;
import com.weavesocks.pages.MainPage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class LoginForm extends MainPage {

    private static final Logger LOGGER = LogManager.getLogger(LoginForm.class);

    private By usernameField = By.cssSelector("#username-modal");
    private By passwordField = By.cssSelector("#password-modal");
    private By loginBtn = By.xpath("//button[@class='btn btn-primary']");

    @Step("Login as a user with")
    public MainPage loginAsUser(User user) {
        enterValue(user.getUsername(), usernameField);
        enterValue(user.getPassword(), passwordField);
        clickLogInButton();
        return this;
    }

    @Step("Click on the Login button")
    public MainPage clickLogInButton() {
        LOGGER.info("Clicks on the login button");
        clickOnButton(loginBtn);
        return this;
    }
}
