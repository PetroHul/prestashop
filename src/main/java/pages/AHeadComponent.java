package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AHeadComponent  {
    protected WebDriver driver;
    private WebElement contactUsButton;
    private WebElement localization;
    private WebElement currency;
    private WebElement signInButton;
    private WebElement cartButton;
    private WebElement logo;
    private WebElement searchProductField;
    private WebElement searchProductButton;

    protected AHeadComponent(WebDriver driver){
        this.driver = driver;
        contactUsButton=driver.findElement(By.cssSelector("#contact-link > a"));
        localization=driver.findElement(By.cssSelector("#_desktop_language_selector > div > div > button > span"));
        currency=driver.findElement(By.cssSelector("#_desktop_currency_selector > div > button > span"));
        signInButton=driver.findElement(By.cssSelector("#_desktop_user_info > div > a"));
        cartButton=driver.findElement(By.cssSelector("#_desktop_cart > div > div > i"));
        logo=driver.findElement(By.cssSelector("#_desktop_logo > h1 > a > img"));
        searchProductField=driver.findElement(By.cssSelector("#search_widget > form > input.ui-autocomplete-input"));
        searchProductButton=driver.findElement(By.cssSelector("#search_widget > form > button > i"));
    }

    // PageObject Atomic Operation

    // ContactUsButton
    public WebElement getContactUsButton() {
        return contactUsButton;
    }

    public String getContactUsText() {
        return getContactUsButton().getText().substring(0, 1);
    }

    public void clickContactUs() {
        getContactUsButton().click();
    }

    //Localization
    public WebElement getLocalization() {
        return localization;
    }
    public String getLocalizationText() {
        return getLocalization().getText().substring(0, 1);
    }

    public void clickLocalization() {
        getLocalization().click();
    }


    // Currency
    public WebElement getCurrency() {
        return currency;
    }

    public String getCurrencyText() {
        return getCurrency().getText().substring(0, 1);
    }

    public void clickCurrency() {
        getCurrency().click();
    }

    //SignInButton
    public WebElement getSignInButton() {
        return signInButton;
    }

    public String getSignInButtonText() {
        return getSignInButton().getText();
    }

    public void clickSignInButton() {
        getSignInButton().click();
    }


    //CartButton
    public WebElement getCartButton() {
        return cartButton;
    }

    public String getCartButtonText() {
        return getCartButton().getText();
    }

    public void clickShoppingCart() {
        getCartButton().click();
    }

    //Logo
    public WebElement getLogo() {
        return logo;
    }

    public String getLogoText() {
        return getLogo().getText();
    }

    public void clickLogo() {
        getLogo().click();
    }

    //SearchProductField
    public WebElement getSearchProductField() {
        return searchProductField;
    }

    public String getSearchProductFieldText() {
        return getSearchProductField().getText();
    }

    public void clickSearchProductField() {
        getSearchProductField().click();
    }

    //SearcProductButton
    public WebElement getSearchProductButton() {
        return searchProductButton;
    }

    public String getSearchProductButtonText() {
        return getSearchProductButton().getText();
    }

    public void clickSearchProductButton() {
        getSearchProductButton().click();
    }
}
