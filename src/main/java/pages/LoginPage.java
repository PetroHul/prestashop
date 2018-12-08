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


    public WebElement getEmailField() {
        return emailField;
    }

    public void setEmailField(WebElement emailField) {
        this.emailField = emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(WebElement passwordField) {
        this.passwordField = passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(WebElement loginButton) {
        this.loginButton = loginButton;
    }
}
