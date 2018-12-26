package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAdminPage {

    protected WebDriver driver;


    public LoginAdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#email")
    private WebElement emailField;
    @FindBy(css = "#passwd")
    private WebElement passwordField;
    @FindBy(css = "#submit_login")
    private WebElement loginButton;


    // PageObject Atomic Operation

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

    // Business Logic
    public void fillLoginForm(String email, String password) {
        clickEmailField();
        clearEmailField();
        emailField.sendKeys(email);
        clickPasswordField();
        clearPasswordField();
        passwordField.sendKeys(password);
        clickLoginButton();
    }


}
