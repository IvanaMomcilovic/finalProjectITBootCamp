package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    //login, signuUp, authRouts
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
    //signup
    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span")
    private WebElement signMeUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement messageEmailAlreadyExists;

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

    //cities
    @FindBy(className = "btnAdmin")
    private WebElement adminField;

    @FindBy(className = "btnAdminCities")
    private WebElement citiesField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span")
    private WebElement presenceOfLogOutButton;

    @FindBy(className = "btnNewItem")
    private WebElement newItemCityButton;

    @FindBy(name = "name")
    private WebElement writeNameOfCity;

    @FindBy(className = "btnSave")
    private WebElement saveCityButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageSavedSuccessfully;

    @FindBy(id = "edit")
    private WebElement editButton;

    @FindBy(className = "text-left")
    private WebElement editCity;

    @FindBy(id = "search")
    private WebElement searchCityField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[3]/button[2]/span")
    private WebElement messageEditSavedSuccessfully;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    private WebElement cityNameEdited;

    @FindBy(xpath = "//*[@id=\"delete\"]")
    private WebElement deleteCityButton;

    @FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement confirmDeleteCity;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement confirmMessageDeleteCity;

    public WebElement getAdminField() {
        return adminField;
    }


    public WebElement getCitiesField() {
        return citiesField;
    }


    public boolean presenceOfLogOutButton() {
        return logoutButton.isDisplayed();
    }

    public WebElement getNewItemCityButton() {
        return newItemCityButton;
    }

    public WebElement getWriteNameOfCity() {
        return writeNameOfCity;
    }

    public WebElement getSaveCityButton() {
        return saveCityButton;
    }

    public WebElement getMessageSavedSuccessfully() {
        return messageSavedSuccessfully;
    }

    public void clickEditButton() {
        editButton.click();
    }

    public WebElement getEditCity(String cityName) {
        return editCity;
    }

    public WebElement getSearchCityField() {
        return searchCityField;
    }

    public WebElement getCityNameEdited() {
        return cityNameEdited;
    }

    public WebElement getDeleteCityButton() {
        return deleteCityButton;
    }

    public WebElement getConfirmDeleteCity() {
        return confirmDeleteCity;
    }

    public WebElement getMessage4() {
        return messageEditSavedSuccessfully;
    }

    public WebElement getConfirmMessageDeleteCity() {
        return confirmMessageDeleteCity;
    }

    //locale
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button/span")
    private WebElement languageField;
    @FindBy(className = "btnEN")
    private WebElement en;

    @FindBy(className = "btnES")
    private WebElement es;

    @FindBy(className = "btnFR")
    private WebElement fr;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement headerText;


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLanguageField() {
        return languageField;
    }

    public WebElement getEn() {
        return en;
    }

    public WebElement getEs() {
        return es;
    }

    public WebElement getFr() {
        return fr;
    }

    public WebElement getHeaderText() {
        return headerText;
    }

    //profile
    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "urlTwitter")
    private WebElement twitter;

    @FindBy(id = "urlGitHub")
    private WebElement github;

    @FindBy(className = "btnClose")
    private WebElement closeMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement myProfileButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveProfileButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement messageSuccessfullySaved;


    public WebElement getPhone() {
        return phone;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getTwitter() {
        return twitter;
    }

    public WebElement getGithub() {
        return github;
    }

    public WebElement getMessageSuccessfullySaved() {
        return messageSuccessfullySaved;
    }

    public WebElement getCloseMessage() {
        return closeMessage;
    }

    public WebElement getMyProfileButton() {
        return myProfileButton;
    }


    public void myProfileFillForm(String phone, String city, String country, String twitter, String github) throws InterruptedException {

        Thread.sleep(2500);
        this.phone.sendKeys(phone);
        Thread.sleep(2500);
        this.city.sendKeys(Keys.CONTROL + "a");
        this.city.sendKeys(Keys.DELETE);
        this.city.sendKeys(city);
        this.city.sendKeys(Keys.ARROW_DOWN);
        this.city.sendKeys(Keys.ENTER);
        Thread.sleep(2500);
        this.country.sendKeys(country);
        this.twitter.sendKeys(twitter);
        this.github.sendKeys(github);
        saveProfileButton.click();
    }
}
