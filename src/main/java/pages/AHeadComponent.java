package pages;

import data.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public abstract class AHeadComponent {

    private DropdownOptions dropdownOptions;

    private class DropdownOptions {

        private List<WebElement> listOptions;

        public DropdownOptions(By searchLocator) {
            initListOptions(searchLocator);
        }


        private void initListOptions(By searchLocator){
            listOptions = driver.findElements(searchLocator);

        }

        public List<WebElement> getListOptions() {
            return listOptions;
        }

        public WebElement getDropdownOptionByPartialName(String optionName) {
            WebElement result = null;
            for (WebElement current : getListOptions()) {
                if (current.getText().toLowerCase().contains(optionName.toLowerCase())) {
                    result = current;
                    break;
                }
            }
            return result;
        }

        public List<String> getListOptionsText() {
            List<String> result = new ArrayList<String>();
            for (WebElement current : getListOptions()) {
                result.add(current.getText());
            }
            return result;
        }

        public void clickDropdownOptionByPartialName(String optionName) {
            getDropdownOptionByPartialName(optionName).click();
        }
    }

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
    private WebElement clothesButton;
    private WebElement artButton;
    private WebElement menButton;

    @FindBy(css ="div#block_myaccount_infos a[href*='addresses']")
    private WebElement footerAddressesButton;


    protected AHeadComponent(WebDriver driver) {
        this.driver = driver;


        contactUsButton = driver.findElement(By.cssSelector("#contact-link > a"));
        localization = driver.findElement(By.cssSelector("#_desktop_language_selector > div > div > button > span"));
        currency = driver.findElement(By.cssSelector("#_desktop_currency_selector > div > button > span"));


        signInButton = driver.findElement(By.cssSelector(".user-info > a[href='http://studio5f.online/en/my-account']"));
        cartButton = driver.findElement(By.id("_desktop_cart"));

        logo = driver.findElement(By.cssSelector(".logo.img-responsive"));

        searchProductField = driver.findElement(By.name("s"));
        searchProductButton = driver.findElement(By.cssSelector("button[type='submit']"));

        menuTop = driver.findElements(By.cssSelector(".top-menu"));
        accessoriesButton = driver.findElement(By.cssSelector("#category-6"));
        clothesButton = driver.findElement(By.cssSelector("#category-3"));
        artButton = driver.findElement(By.cssSelector("#category-9"));
        menButton = driver.findElement(By.cssSelector("#category-4"));

//        searchProductField = driver.findElement(By.name("s"));
//        searchProductButton = driver.findElement(By.cssSelector("button[type='submit']"));
//
//        menuTop = driver.findElements(By.cssSelector(".top-menu"));
//        accessoriesButton = driver.findElement(By.cssSelector("#category-6"));
//
//        footerAddressesButton = driver.findElement(By.cssSelector("div#block_myaccount_infos a[href*='addresses']"));
//    }
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
//            logger.trace("getCurrency() running return currency;");
            return currency;
        }

        public String getCurrencyText() {
            return getCurrency().getText().trim();
        }

        public void clickCurrency() {
            getCurrency().click();
        }

        public void clickCurrencyByPartialName(String optionName) {
            clickCurrency();
            createDropdownOptions(By.cssSelector("a[href*='SubmitCurrency']"));
            clickDropdownOptionByPartialName(optionName);
            clickLogo();
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

    //SignOutButtom
    public void clickSignOutButtom() {
        driver.findElement(By.cssSelector(".user-info a[href*='mylogout']")).click();
    }


    //CartButton
    public WebElement getCartButton() {
        return cartButton;
    }

    public String getCartButtonText() {
        return getCartButton().getText();
    }

    public void clickShoppingCart() {
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//
//        wait.until(ExpectedConditions.invisibilityOf(getCartButton()));
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

    public void clickContactUsButton(){getContactUsButton().click();}

    public void clearContactUsButton(){getContactUsButton().click();}


    //SearcProductButton
    public WebElement getSearchProductButton() {
        return searchProductButton;
    }

    public SearchResultPage clickSearchProductButton() {
        getSearchProductButton().click();
        return new SearchResultPage(driver);
    }

//    //menuTop
//    public List<WebElement> getMenuTop() {
//        return menuTop;
//    }
//
//    public List<String> getMenuTopTexts() {
//        List<String> result = new ArrayList<String>();
//        for (WebElement current : getMenuTop()) {
//            result.add(current.findElement(By.cssSelector(".top-menu")).getText()); // not good selector
//        }
//        return result;
//    }
//
//
//    public WebElement getMenuTopByCategoryPartialName(String categoryName) {
//        WebElement result = null;
//        for (WebElement current : getMenuTop()) {
//            if (current.findElement(By.cssSelector(".top-menu")).getText() // not good selector
//                    .toLowerCase().contains(categoryName.toLowerCase())) {
//                result = current;
//                break;
//            }
//        }
//        return result;
//    }

    //topmenu

    public void setMenuTop(List<WebElement> menuTop) {
        this.menuTop = menuTop;
    }


    public CategoryPage clickAccessoriesButton() {
        accessoriesButton.click();
        return new CategoryPage(driver);
    }

    public CategoryPage clickClothesButton() {
        clothesButton.click();
        return new CategoryPage(driver);
    }

    public CategoryPage clickArtButton() {
        artButton.click();
        return new CategoryPage(driver);
    }

    public CategoryPage hoverArtButton() {
        artButton.click();
        return new CategoryPage(driver);
    }

    public void hoverClothesButton() {
        Actions builder = new Actions(driver);
        builder.moveToElement(clothesButton).perform();
//        return new CategoryPage(driver);
    }

//    public CategoryPage menButton() {
//        menButton.click();
//        return new CategoryPage(driver);
//    }

    public void hoverAccessoriesButton() {
        Actions builder = new Actions(driver);
        builder.moveToElement(accessoriesButton).perform();


    }

    //footer
    public AddressesPage clickFooterAddressesButton() {
        footerAddressesButton.click();
        return new AddressesPage(driver);
    }

    // dropdownOptions
    protected DropdownOptions getDropdownOptions() {
        return dropdownOptions;
    }

    private void createDropdownOptions(By searchLocator) {
        dropdownOptions = new DropdownOptions(searchLocator);
    }

//	private void createDropdownOptions(By searchLocator, By lastLocator) {
//             dropdownOptions = new DropdownOptions(searchLocator, lastLocator);
//    }

    private boolean findDropdownOptionByPartialName(String optionName) {
        boolean isFound = false;
        if(getDropdownOptions() == null) {
            throw new RuntimeException("DropdownOption is null");
        }
        for (String current : getDropdownOptions().getListOptionsText() ) {
            if (current.toLowerCase().contains(optionName.toLowerCase())) {
                isFound = true;
            }
        }
        return isFound;
    }

    private void clickDropdownOptionByPartialName(String optionName) {
        if (!findDropdownOptionByPartialName(optionName)) {
            throw new RuntimeException(String.format("OPTION_NOT_FOUND_MESSAGE %s %s",
                    optionName, dropdownOptions.getListOptionsText().toString()));
        }
        getDropdownOptions().clickDropdownOptionByPartialName(optionName);
        dropdownOptions = null;
    }
}




