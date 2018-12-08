package pages;

import org.openqa.selenium.*;

public class LoginPage extends AHeadComponent{
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement loginButton;

    protected WebDriver driver;
    public  LoginPage(WebDriver driver){
        super(driver);
    }

    // emailField
    public WebElement getEmailField() {
        return emailField;
    }
    public void clearEmailField() {
        getEmailField().clear();
    }

    public void setEmailField(WebElement emailField) {
        this.emailField = emailField;
    }

    // passwordField
    public WebElement getPasswordField() {
        return passwordField;
    }
    public void clearPasswordField() {
        getPasswordField().clear();
    }

    public void setPasswordField(WebElement passwordField) {
        this.passwordField = passwordField;
    }
    // loginButton
    public WebElement getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(WebElement loginButton) {
        this.loginButton = loginButton;
    }
}
