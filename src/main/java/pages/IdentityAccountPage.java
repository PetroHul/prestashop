package pages;

import data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdentityAccountPage extends AHeadComponent{

    //Page Factory
    @FindBy(css = "input[name='id_gender'][value='1']")
    private WebElement socialTitleMr;

    @FindBy(css = "input[name='id_gender'][value='2']")
    private WebElement socialTitleMrs;

    @FindBy(css = "input.form-control[name='firstname']")
    private WebElement firstName;

    @FindBy(css = "input.form-control[name='lastname']")
    private WebElement lastName;

    @FindBy(css = "input.form-control[name='email']")
    private WebElement email;

    @FindBy(css = "input.form-control[name='password']")
    private WebElement password;

    @FindBy(css = "input.form-control[name='new_password']")
    private WebElement newPassword;

    @FindBy(css = "input.form-control[name='birthday']")
    private WebElement birthday;

    @FindBy(css = "input[namIdentityAccountPagee='optin']")
    private WebElement optionCheackBox;

    @FindBy(css = "input[name='newsletter']")
    private WebElement newsLetterCheackBox;

    @FindBy(css = "button[data-link-action='save-customer']")
    private WebElement buttonSave;

    public IdentityAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Social title
    public WebElement getSocialTitleMr() {
        return socialTitleMr;
    }
    public void setSocialTitleMr(WebElement socialTitleMr) {
        this.socialTitleMr = socialTitleMr;
    }
    public void clickSocialTitleMr() {
        getSocialTitleMr().click();
    }

    public WebElement getSocialTitleMrs() {
        return socialTitleMrs;
    }
    public void setSocialTitleMrs(WebElement socialTitleMrs) {
        this.socialTitleMrs = socialTitleMrs;
    }
    public void clickSocialTitleMrs() {
        getSocialTitleMrs().click();
    }

    //Frist name
    public WebElement getFirstName() {
        return firstName;
    }
    public void setFirstName(WebElement firstName) {
        this.firstName = firstName;
    }
    public void clearFirstName() {
        getFirstName().clear();
    }
    public void clickFirstName() {
        getFirstName().click();
    }
    public void typeFirstName(String value) {
        getFirstName().sendKeys(value);
    }

    //Last name
    public WebElement getLastName() {
        return lastName;
    }
    public void setLastName(WebElement lastName) {
        this.lastName = lastName;
    }
    public void clearLastName() {
        getLastName().clear();
    }
    public void clickLastName() {
        getLastName().click();
    }
    public void typeLastName(String value) {
        getLastName().sendKeys(value);
    }

    //Email
    public WebElement getEmail() {
        return email;
    }
    public void setEmail(WebElement email) {
        this.email = email;
    }
    public void clearEmail() {
        getEmail().clear();
    }
    public void clickEmail() {
        getEmail().click();
    }
    public void typeEmail(String value) {
        getEmail().sendKeys(value);
    }

    //Password
    public WebElement getPassword() {
        return password;
    }
    public void setPassword(WebElement password) {
        this.password = password;
    }
    public void clearPassword() {
        getPassword().clear();
    }
    public void clickPassword() {
        getPassword().click();
    }
    public void typePassword(String value) {
        getPassword().sendKeys(value);
    }

    //New Password
    public WebElement getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(WebElement newPassword) {
        this.newPassword = newPassword;
    }
    public void clearNewPassword() {
        getNewPassword().clear();
    }
    public void clickNewPassword() {
        getNewPassword().click();
    }
    public void typeNewPassword(String value) {
        getNewPassword().sendKeys(value);
    }

    //Birthdate
    public WebElement getBirthday() {
        return birthday;
    }
    public void setBirthday(WebElement birthday) {
        this.birthday = birthday;
    }
    public void clearBirthday() {
        getBirthday().clear();
    }
    public void clickBirthday() {
        getBirthday().click();
    }
    public void typeBirthday(String value) {
        getBirthday().sendKeys(value);
    }

    //First CheackBox Receive offers from out partners
    public WebElement getOptionCheackBox() {
        return optionCheackBox;
    }
    public void clickOptionCheackBox() {
        getOptionCheackBox().click();
    }

    //Second CheackBox Sign up for our newsletter
    public WebElement getNewsLetterCheackBox() {
        return newsLetterCheackBox;
    }
    public void clickNewsLetterCheackBox() {
        getNewsLetterCheackBox().click();
    }

    //Button Save
    public WebElement getButtonSave() {
        return buttonSave;
    }
    public void clickButtonSave() {
        getButtonSave().click();
    }
    public void clickButtonSaveAndStatus() {
        getButtonSave().click();
    }

    //Success massages
    public String getAlertSuccessText() {
        return driver.findElement(By.cssSelector("article.alert.alert-success")).getText();
    }
}
