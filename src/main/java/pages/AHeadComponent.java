package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public abstract class AHeadComponent {

    protected WebDriver driver;
    protected final String SEARCH_VALUE = "mug";

    @FindBy(css = "#contact-link > a")
    private WebElement contactUsButton;

    @FindBy(css = "#_desktop_language_selector > div > div > button > span")
    private WebElement localization;
    @FindBy(css = "#_desktop_currency_selector > div > button > span")
    private WebElement currency;

    @FindBy(css = ".user-info > a[href='http://studio5f.online/en/my-account']")
    private WebElement signInButton;

    @FindBy(id = "_desktop_cart")
    private WebElement cartButton;

    @FindBy(css = ".logo.img-responsive")
    private WebElement logo;

    @FindBy(name = "s")
    private WebElement searchProductField;

    @FindBy(css = "button[type='submit']")
    private WebElement searchProductButton;

    @FindBy(css =".top-menu")
    private List<WebElement> menuTop;

    @FindBy(css ="#category-6")
    private WebElement accessoriesButton;

    @FindBy(css ="div#block_myaccount_infos a[href*='addresses']")
    private WebElement footerAddressesButton;

    protected AHeadComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    protected AHeadComponent(WebDriver driver) {
//        this.driver = driver;

//        contactUsButton = driver.findElement(By.cssSelector("#contact-link > a"));
//        localization = driver.findElement(By.cssSelector("#_desktop_language_selector > div > div > button > span"));
//        currency = driver.findElement(By.cssSelector("#_desktop_currency_selector > div > button > span"));
//
//
//        signInButton = driver.findElement(By.cssSelector(".user-info > a[href='http://studio5f.online/en/my-account']"));
//        cartButton = driver.findElement(By.id("_desktop_cart"));
//        logo = driver.findElement(By.cssSelector(".logo.img-responsive"));

//        searchProductField = driver.findElement(By.name("s"));
//        searchProductButton = driver.findElement(By.cssSelector("button[type='submit']"));
//
//        menuTop = driver.findElements(By.cssSelector(".top-menu"));
//        accessoriesButton = driver.findElement(By.cssSelector("#category-6"));
//
//        footerAddressesButton = driver.findElement(By.cssSelector("div#block_myaccount_infos a[href*='addresses']"));
//    }


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

    public LoginPage clickSignInButton() {
        getSignInButton().click();
        return new LoginPage(driver);
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


    public String getUserName() {
        return driver.findElement(By.cssSelector(".account")).getText().trim();
    }

    //footer
    public AddressesPage clickFooterAddressesButton() {
        return new AddressesPage(driver);
    }
}


