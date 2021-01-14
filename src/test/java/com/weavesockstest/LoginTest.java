package com.weavesockstest;

import com.weavesocks.models.User;
import com.weavesocks.pages.Constants;
import com.weavesocks.pages.Locators;
import com.weavesocks.pages.forms.LoginForm;
import com.weavesocks.utilities.generators.UserGenerator;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic(value = "Login")
@Story("User login")
@Feature(value = "Login on the main page")
public class LoginTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Verifies the title of the website")
    public void verifyTitle() {
        String expectedTitle = "WeaveSocks";

        String actualTitle = mainPage.getTitle();
        assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies the title of the login form")
    public void loginWithCorrectCredentials() {
        User user = User.builder()
                .username("den")
                .password("123")
                .firstname("denis")
                .lastname("petrov")
                .email("dsadsadsadsad@email.ru")
                .build();

        mainPage.click(Locators.LOGIN_BUTTON);
        String actualUsername = new LoginForm()
                .loginAsUser(user)
                .getUserProfileName();
        assertTrue(actualUsername.contains(user.getFirstname()));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies the title of the login form")
    public void loginWithIncorrectCredentials() {
        User user = UserGenerator.generateUser();

        mainPage.click(Locators.LOGIN_BUTTON);
        String actualMessage = new LoginForm()
                .loginAsUser(user)
                .getInvalidLoginCredentialsMessage();
        assertEquals(actualMessage, Constants.INVALID_CREDENTIALS_MESSAGE);
    }
}
