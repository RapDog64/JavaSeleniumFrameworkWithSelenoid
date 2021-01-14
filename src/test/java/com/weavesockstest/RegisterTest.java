package com.weavesockstest;

import com.weavesocks.models.User;
import com.weavesocks.pages.Locators;
import com.weavesocks.pages.forms.RegisterForm;
import com.weavesocks.utilities.generators.UserGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Epic(value = "Registration")
@Story("User Registration")
@Feature("Main page registration")
public class RegisterTest extends BaseTest {

    @Test
    @Description("Verifies that user can sing up on the website")
    public void verifyUserRegistration() {
        User user = UserGenerator.generateUser();

        mainPage.click(Locators.REGISTER_BUTTON);
        String userProfileName = new RegisterForm()
                .registerNewUser(user)
                .getUserProfileName();
        assertTrue(userProfileName.contains(user.getFirstname()));
    }
}
