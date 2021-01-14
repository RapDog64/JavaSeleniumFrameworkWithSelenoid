package com.weavesocks.pages.forms;

import com.weavesocks.models.User;
import com.weavesocks.pages.Locators;
import com.weavesocks.pages.MainPage;
import com.weavesocks.utilities.waiter.Waiter;
import org.openqa.selenium.By;

public class RegisterForm extends MainPage {

    private String registerInput = "register-%s-modal";
    private By registerButton = By.xpath("//button[@class='btn btn-primary' and contains(text(), 'Register')]");

    public MainPage registerNewUser(User user) {
        enterUsername(user.getUsername());
        enterFirstName(user.getFirstname());
        enterLastName(user.getLastname());
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickRegisterButton();

        return new MainPage();
    }

    public MainPage clickRegisterButton() {
        Waiter.waitForElement(registerButton);
        driver.findElement(registerButton).click();
        return new MainPage();
    }

    public RegisterForm enterUsername(String username) {
        By usernameLocator = By.id(String.format(registerInput, Locators.USERNAME));
        enterValue(username, usernameLocator);
        return this;
    }

    public RegisterForm enterFirstName(String firstName) {
        By firstNameLocator = By.id(String.format(registerInput, Locators.FIRST_NAME));
        enterValue(firstName, firstNameLocator);
        return this;
    }

    public RegisterForm enterLastName(String lastName) {
        By lastNameLocator = By.id(String.format(registerInput, Locators.LAST_NAME));
        enterValue(lastName, lastNameLocator);
        return this;
    }

    public RegisterForm enterEmail(String email) {
        By emailLocator = By.id(String.format(registerInput, Locators.EMAIL));
        enterValue(email, emailLocator);
        return this;
    }

    public RegisterForm enterPassword(String password) {
        By passwordLocator = By.id(String.format(registerInput, Locators.PASSWORD));
        enterValue(password, passwordLocator);
        return this;
    }
}
