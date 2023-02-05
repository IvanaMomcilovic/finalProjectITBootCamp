package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

import java.util.List;

public class CitiesTests extends BaseTest {
    private Faker faker;
    private String cityName;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.pressLoginField().click();
        loginPage.pressLoginButton("admin@admin.com", "12345");
        loginPage.getAdminField().click();
        loginPage.getCitiesField().click();
        loginPage.getNewItemCityButton().click();

        faker = new Faker();
        cityName = faker.address().cityName(); // ovo ce kada se pokrene na nivou klase jednom napravi novi grad
        // i onda taj isti koristim u svim metodama
    }

    @Test
    public void visitAdminPageTest() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(loginPage.presenceOfLogOutButton());
    }

    @Test
    public void createNewCityTest() {
        loginPage.getWriteNameOfCity();
        loginPage.getSaveCityButton();
        Assert.assertTrue(loginPage.getMessageSavedSuccessfully().getText().contains("Saved successfully"));
    }


    @Test
    public void editCityTest() {
        createNewCityTest();
        loginPage.clickEditButton();
        loginPage.getWriteNameOfCity().sendKeys("edited");
        loginPage.getSaveCityButton().click();
        Assert.assertTrue(loginPage.getMessageSavedSuccessfully().getText().contains("Saved successfully"));
    }

    @Test
    public void searchCity() {
        createNewCityTest();
        editCityTest();
        loginPage.getSearchCityField().sendKeys(cityName + "edited");
        loginPage.getCityNameEdited().click();
        Assert.assertTrue(loginPage.getCityNameEdited().getText().equals(loginPage.getSearchCityField().getAttribute("value")));
    }

    @Test
    public void deleteCityTest() {
        createNewCityTest();
        loginPage.getSearchCityField().sendKeys(cityName);
        loginPage.getCityNameEdited().click();
        loginPage.getConfirmDeleteCity();
        Assert.assertTrue(loginPage.getConfirmMessageDeleteCity().getText().contains("Deleted successfully"));
    }

}
