package pages;

import data.SocialTitle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CreateAccountPage extends AHeadComponent {

    @FindBy(css = ".page-header > h1")
    private WebElement heading;

    @FindBy(css = "input[name='id_gender']")
    private List<WebElement> socialTitle;

    @FindBy(css = "input[name='firstname']")
    private WebElement firstName;

    @FindBy(css = "input[name='lastname']")
    private WebElement lastName;

    @FindBy(css = ".form-control[name='email']")
    private WebElement email;

    @FindBy(css = "input[name='password']")
    private WebElement password;

    @FindBy(css = "input[name='birthday']")
    private WebElement birthdate;

    @FindBy(css = "input[name='optin']")
    private WebElement receiveOffers;

    @FindBy(css = "input[name='newsletter")
    private WebElement newsletter;

    @FindBy(css = ".btn.btn-primary.form-control-submit.float-xs-right")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id='customer-form']/section/div[4]/div[1]/div/ul/li")
    private WebElement errorMessage;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getHeading() {
        return heading.getText().trim();
    }


    public List<WebElement> getSocialTitle() {
        return socialTitle;
    }

    public void setSocialTitle(SocialTitle socialTitle) {
        switch (socialTitle) {
            case MR:
                this.socialTitle.get(0).click();
                break;
            case MRS:
                this.socialTitle.get(1).click();
                break;
        }

    }

    public WebElement getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.click();
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }

    public WebElement getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.click();
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public WebElement getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.click();
        this.email.clear();
        this.email.sendKeys(email);
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password.click();
        this.password.clear();
        this.password.sendKeys(password);
    }

    public WebElement getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate.click();
        this.birthdate.clear();
        this.birthdate.sendKeys(birthdate);
    }

    public WebElement getReceiveOffers() {
        return receiveOffers;
    }

    public void setReceiveOffers(boolean receiveOffers) {

        if (receiveOffers) {
            this.receiveOffers.click();
        } else ; //do nothing

    }

    public WebElement getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        if (newsletter) {
            this.newsletter.click();
        } else ; //do nothing
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public HomePage clickSaveButton() {
        this.saveButton.click();
        return new HomePage(driver);
    }

    public WebElement getErrorMessaget() {
        return errorMessage;
    }

    public String getMessageText(){
        return getErrorMessaget().getText();
    }
}
