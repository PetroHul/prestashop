package pages;

import data.SocialTitle;
import data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class CreateAccountPage extends AHeadComponent {

    private WebElement heading;
    private List<WebElement> socialTitle;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement password;
    private WebElement birthdate;
    private WebElement receiveOffers;
    private WebElement newsletter;
    private WebElement saveButton;


    protected CreateAccountPage(WebDriver driver) {
        super(driver);
        initRegisterComponent();
    }

    private void initRegisterComponent() {
        heading = driver.findElement(By.cssSelector(".page-header > h1"));
        socialTitle = driver.findElements(By.cssSelector("input[name='id_gender']"));
        firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        email = driver.findElement(By.cssSelector(".form-control[name='email']"));
        password = driver.findElement(By.cssSelector("input[name='password']"));
        birthdate = driver.findElement(By.cssSelector("input[name='birthday']"));
        receiveOffers = driver.findElement(By.cssSelector("input[name='optin']"));
        newsletter = driver.findElement(By.cssSelector("input[name='newsletter"));
        saveButton = driver.findElement(By.cssSelector(".btn.btn-primary.form-control-submit.float-xs-right"));


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
}
