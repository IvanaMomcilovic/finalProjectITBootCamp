package tests;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
public class AuthRoutesTests extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.openLoginField();
    }

    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities ");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users  ");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }


}
