package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTests extends BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();


    }

    @Test
    public void visitSignUpPageTest() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void checkInputTypesTest() {
        Assert.assertEquals(loginPage.getEmailAttributeType(), "email");
        Assert.assertEquals(loginPage.getPasswordAttributeType(), "password");
        Assert.assertEquals(loginPage.getConfirmPasswordAttributeType(), "password");
    }

    @Test
    public void userAlreadyExists() {
        loginPage.pressSignMeUpButton("Test Test", "admin@admin.com", "123654", "123654");
        Assert.assertTrue(loginPage.getMessage3().getText().contains("E-mail already exists"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void signUp() {
        loginPage.pressSignMeUpButton(String.valueOf(faker.name()), faker.internet().emailAddress(), "2909973", "2909973");
        driverWait.until(ExpectedConditions.urlContains("/home"));
    }

}


