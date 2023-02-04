package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CitiesTests extends BaseTest {
    private Faker faker;
    private String cityName;

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.pressLoginField().click();
        loginPage.pressLoginButton("admin@admin.com", "12345");
        loginPage.pressAdminField().click();
        loginPage.pressCitiesField().click();
        loginPage.pressNewItemCityButton().click();

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
        loginPage.writeNameOfCity(cityName);
        Assert.assertTrue(loginPage.getMessage4().getText().contains("Saved successfully"));
    }

    //ne znam da li radi ovaj test jer je blokiran sajt
    @Test
    public void editCity() {
        loginPage.clickEditButton();
        loginPage.writeNameOfCity(cityName);
        Assert.assertTrue(loginPage.getMessage4().getText().contains("Saved successfully"));
    }

    //ne znam da uradim test #4
//@Test
    //  public void newCityOntheTopOfFirstRow(){
//}

    @Test
    public void deleteCity() {
        loginPage.writeNameOfCity(cityName);

    }

}
