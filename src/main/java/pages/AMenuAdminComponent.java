package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AMenuAdminComponent {

    protected WebDriver driver;

    protected AMenuAdminComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".link-levelone.has_submenu.-active a[href*='collapse-9'] span")
    private WebElement catalogButton;

    @FindBy(css = "#subtab-AdminProducts")
    private WebElement productsButton;

    @FindBy(xpath = "//*[@id='subtab-AdminParentCustomer']/a/span")
    private WebElement clientsFirstButton;

    @FindBy(css = "#subtab-AdminCustomers")
    private WebElement clientsButton;

    @FindBy(css = "#page-header-desc-customer-new_customer")
    private WebElement addUserButton;


    public WebElement getCatalogButton() {
        return catalogButton;
    }
    public void clickCatalog() {
        getCatalogButton().click();
    }

    public WebElement getProductsButton() {
        return catalogButton;
    }
    public void clickProducts() {
        getProductsButton().click();
    }

    public WebElement getClientsFirstButton() {
        return clientsFirstButton;
    }
    public void clickClientsFirstButton() {
        getClientsFirstButton().click();
    }

    public WebElement getClientsButton() {
        return clientsButton;
    }
    public void clickClientsButton() {
        getClientsButton().click();
    }

    public WebElement getAddUserButton() {
        return addUserButton;
    }
    public void clickAddUserButton() {
        getAddUserButton().click();
    }



}
