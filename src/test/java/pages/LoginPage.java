package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement messageUserDoesNotExists;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement messageWrongPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span")
    private WebElement logoutButton;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span")
    private WebElement signMeUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement messageEmailAlreadyExists;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span")
    private WebElement adminField;

    @FindBy(xpath = "/html/body/div/div[3]/div/a[1]/div[2]")
    private WebElement citiesField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span")
    private WebElement presenceOfLogOutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span")
    private WebElement newItemCityButton;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement writeNameOfCity;

    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]/span")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageSavedSuccessfully;

    @FindBy(id = "edit")
    private WebElement editButton;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement editCity;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[3]/button[2]/span")
    private WebElement messageEditSavedSuccessfully;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement firstRowOfCityTable;

    @FindBy(id="search")
    private WebElement searchCityField;


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void pressLoginButton(String email, String password) {
        this.email.clear();
        this.email.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);

        loginButton.click();
    }

    public String getEmailAttributeType() {
        return email.getAttribute("type");
    }

    public String getPasswordAttributeType() {
        return password.getAttribute("type");
    }

    public String getConfirmPasswordAttributeType() {
        return confirmPassword.getAttribute("type");
    }

    public WebElement getMessage1() {
        return messageUserDoesNotExists;
    }

    public WebElement getMessage2() {
        return messageWrongPassword;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getMessage3() {
        return messageEmailAlreadyExists;
    }

    //  public WebElement getMessage4() {
    //    return messageIMPORTANTverifyYourAccount;
    //}
    public LoginPage(WebDriver driver, WebDriverWait driverWait, WebElement messageEmailAlreadyExists) {
        super(driver, driverWait);
        this.messageEmailAlreadyExists = messageEmailAlreadyExists;
    }

    public void pressSignMeUpButton(String name, String email, String password, String confirmPassword) {
        this.name.clear();
        this.name.sendKeys(name);

        this.email.clear();
        this.email.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);

        this.confirmPassword.clear();
        this.confirmPassword.sendKeys(confirmPassword);

        signMeUpButton.click();
    }

    public WebElement pressAdminField() {
        return adminField;
    }

    public void openAdminField() {
        adminField.click();
    }

    public WebElement pressCitiesField() {
        return citiesField;
    }

    public void openCitiesField() {
        citiesField.click();
    }

    public boolean presenceOfLogOutButton() {
        return logoutButton.isDisplayed();
    }

    public WebElement pressNewItemCityButton() {
        return newItemCityButton;
    }

    public void openNewItemCityButton() {
        newItemCityButton.click();
    }

    public void writeNameOfCity(String city) {
        this.name.clear();
        this.name.sendKeys(city);
        saveButton.click();
    }

    //  public WebElement pressEditButton() {
    //    return editButton;
    //}
    public void clickEditButton() {
        editButton.click();
    }

    public WebElement getEditCity(String cityName) {
        return editCity;
    }

    public WebElement getMessage4() {
        return messageEditSavedSuccessfully;
    }
}
