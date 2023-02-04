package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import com.github.javafaker.Faker;

public class LoginTests extends BaseTest {
    Faker faker = new Faker();

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.pressLoginField().click();


    }

    @Test
    public void visitLoginPageTest() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void checkInputTypesTest() {
        Assert.assertEquals(loginPage.getEmailAttributeType(), "email");
        Assert.assertEquals(loginPage.getPasswordAttributeType(), "password");
    }

    @Test
    public void messageUserDoesNotExists() {
        loginPage.pressLoginButton(faker.internet().emailAddress(), faker.internet().password());
        Assert.assertTrue(loginPage.getMessage1().getText().contains("User does not exist"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void messagePasswordIsWrong() {
        loginPage.pressLoginButton("admin@admin.com", faker.internet().password());
        Assert.assertTrue(loginPage.getMessage2().getText().contains("Wrong password"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void logIn() {
        loginPage.pressLoginButton("admin@admin.com", "12345");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void logout(){
        loginPage.pressLoginButton("admin@admin.com", "12345");
        Assert.assertTrue(loginPage.getLogoutButton().isDisplayed());
        loginPage.getLogoutButton().click();
        driverWait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));


    }
}
