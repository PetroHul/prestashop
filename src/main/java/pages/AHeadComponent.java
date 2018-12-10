package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public abstract class AHeadComponent {

    protected WebDriver driver;
    protected final String SEARCH_VALUE = "mug";

    private WebElement contactUsButton;
    private WebElement localization;
    private WebElement currency;
    private WebElement signInButton;
    private WebElement cartButton;
    private WebElement logo;
    private WebElement searchProductField;
    private WebElement searchProductButton;
    private List<WebElement> menuTop;
    private WebElement accessoriesButton;


    protected AHeadComponent(WebDriver driver) {
        this.driver = driver;


        contactUsButton = driver.findElement(By.cssSelector("#contact-link > a"));
        localization = driver.findElement(By.cssSelector("#_desktop_language_selector > div > div > button > span"));
        currency = driver.findElement(By.cssSelector("#_desktop_currency_selector > div > button > span"));

        signInButton = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a[1]"));
        cartButton = driver.findElement(By.id("_desktop_cart"));
        logo = driver.findElement(By.cssSelector(".logo.img-responsive"));

        searchProductField = driver.findElement(By.name("s"));
        searchProductButton = driver.findElement(By.cssSelector("button[type='submit']"));

        menuTop = driver.findElements(By.cssSelector(".top-menu"));
        accessoriesButton = driver.findElement(By.cssSelector("#category-6"));

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

    public String getSearchProductFieldText(String text) {
        return getSearchProductField().getAttribute(text);
    }

    public void setSearchProductField() {
        getSearchProductField().sendKeys(SEARCH_VALUE);
    }

    public void clickSearchProductField() {
        getSearchProductField().click();
    }

    public void clearSearchProductField() {
        getSearchProductField().clear();
    }


    //SearcProductButton
    public WebElement getSearchProductButton() {
        return searchProductButton;
    }

    public SearchResultPage clickSearchProductButton() {
        getSearchProductButton().click();
        return new SearchResultPage(driver);
    }

    //menuTop
    public List<WebElement> getMenuTop() {
        return menuTop;
    }

    public List<String> getMenuTopTexts() {
        List<String> result = new ArrayList<String>();
        for (WebElement current : getMenuTop()) {
            result.add(current.findElement(By.cssSelector(".top-menu")).getText()); // not good selector
        }
        return result;
    }

    public WebElement getMenuTopByCategoryPartialName(String categoryName) {
        WebElement result = null;
        for (WebElement current : getMenuTop()) {
            if (current.findElement(By.cssSelector(".top-menu")).getText() // not good selector
                    .toLowerCase().contains(categoryName.toLowerCase())) {
                result = current;
                break;
            }
        }
        return result;
    }

    //topmenu

    public void setMenuTop(List<WebElement> menuTop) {
        this.menuTop = menuTop;
    }


    public CategoryPage clickAccesssoriesButton() {
        accessoriesButton.click();
        return new CategoryPage(driver);
    }
}

