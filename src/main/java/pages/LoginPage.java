package pages;

import data.IUser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AHeadComponent{
    @FindBy(css = "input.form-control[name='email']")
    private WebElement emailField;

    @FindBy(css = "input.form-control[name='password']")
    private WebElement passwordField;

    @FindBy(css = "#submit-login")
    private WebElement loginButton;

    @FindBy(css = "a[href*='login?create_account']")
    private WebElement noAccountButton;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // emailField
    public WebElement getEmailField() {
        return emailField;
    }
    public void setEmailField(WebElement emailField) {
        this.emailField = emailField;
    }
    public void clearEmailField() {
        getEmailField().clear();
    }
    public void clickEmailField() {
        getEmailField().click();
    }

    // passwordField
    public WebElement getPasswordField() {
        return passwordField;
    }
    public void setPasswordField(WebElement passwordField) {
        this.passwordField = passwordField;
    }
    public void clearPasswordField() {
        getPasswordField().clear();
    }
    public void clickPasswordField() {
        getPasswordField().click();
    }

    // loginButton
    public WebElement getLoginButton() {
        return loginButton;
    }
    public void clickLoginButton() {
        getLoginButton().click();
    }

    //noAccountButton
    public WebElement getNoAccountButton(){return noAccountButton;}
    public CreateAccountPage clickNoAccountButton(){
        getNoAccountButton().click();
        return new CreateAccountPage(driver);
    }

    // Business Logic
    public void signIn(String email, String password) {
        clickEmailField();
        clearEmailField();
        emailField.sendKeys(email);
        clickPasswordField();
        clearPasswordField();
        passwordField.sendKeys(password);
        clickLoginButton();
    }

    public MyAccountPage logInAcount(IUser user) {
        clickEmailField();
        clearEmailField();
        emailField.sendKeys(user.getEmail());
        clickPasswordField();
        clearPasswordField();
        passwordField.sendKeys(user.getPassword());
        clickLoginButton();
        return new MyAccountPage(driver);
    }

}




