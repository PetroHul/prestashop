package pages;

import data.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AHeadComponent {
    protected WebDriver driver;

    @FindBy(css = "#contact-link > a")
    private WebElement contactUsButton;

    @FindBy(css = "#_desktop_currency_selector > div > button > span")
    private WebElement currency;

    @FindBy(css = ".user-info > a[href='http://studio5f.online/en/my-account']")
    private WebElement signInButton;

    @FindBy(id = "_desktop_cart")
    private WebElement cartButton;

    @FindBy(css = ".logo.img-responsive")
    private WebElement logo;

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchProductField;

    @FindBy(css = "button[type='submit']")
    private WebElement searchProductButton;

    @FindBy(css = "#category-6")
    private WebElement accessoriesButton;

    @FindBy(css = "#category-3")
    private WebElement clothesButton;

    @FindBy(css = "#category-9")
    private WebElement artButton;

    @FindBy(css = "#category-4")
    private WebElement menButton;

    @FindBy(css = "div#block_myaccount_infos a[href*='addresses']")
    private WebElement footerAddressesButton;


    @FindBy(xpath ="//*[@id='_desktop_user_info']/div/a[2]/span")
    private WebElement registerUserName;

    private DropdownOptions dropdownOptions;

    protected AHeadComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private class DropdownOptions {

        private List<WebElement> listOptions;

        public DropdownOptions(By searchLocator) {
            initListOptions(searchLocator);
        }

        private void initListOptions(By searchLocator) {
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

    //RegisterUserName
    public WebElement getregisterUserName() {
        return registerUserName;
    }

    public String getUserName() {
        return registerUserName.getText();
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
    private void fill(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    public void fillAll(Search data) {
        fill(searchProductField, data.toString().toLowerCase());
    }

    public void clickContactUsButton() {
        getContactUsButton().click();
    }

    public void clearContactUsButton() {
        getContactUsButton().click();
    }


    //SearcProductButton
    public WebElement getSearchProductButton() {
        return searchProductButton;
    }

    public SearchResultPage clickSearchProductButton() {
        getSearchProductButton().click();
        return new SearchResultPage(driver);
    }

    //topmenu
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

    public void hoverClothesButton() {
        Actions builder = new Actions(driver);
        builder.moveToElement(clothesButton).perform();
    }

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