package pages;

import org.openqa.selenium.*;

public class LoginPage extends AHeadComponent{
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement noAccountButton;

    public LoginPage(WebDriver driver){
        super(driver);
        initLoginComponent();
    }

    private void initLoginComponent() {
        emailField = driver.findElement(By.cssSelector("input.form-control[name='email']"));
        passwordField = driver.findElement(By.cssSelector("input.form-control[name='password']"));
        loginButton = driver.findElement(By.cssSelector("#submit-login"));
        noAccountButton=driver.findElement(By.cssSelector("a[href*='login?create_account']"));
    }

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

    //noAccountButton
    public WebElement getNoAccountButton(){return noAccountButton;}
    public CreateAccountPage clickNoAccountButton(){
        getNoAccountButton().click();
        return new CreateAccountPage(driver);
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




