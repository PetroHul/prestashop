package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AMenuAdminComponent {

    protected WebDriver driver;


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

    @FindBy(css = "#page-header-desc-configuration-add")
    private WebElement createNewProductButton;

    @FindBy(css = "#product_catalog_list > div:nth-child(2) > div > div > table > tbody > tr:nth-child(1) > td.text-right > div > div > button")
    private WebElement dropdownDeleteButton;

    @FindBy(css = "#product_catalog_list > div:nth-child(2) > div > div > table > tbody > tr:nth-child(1) > td.text-right > div > div > div > a:nth-child(3)")
    private WebElement deleteProductButton;

    @FindBy(css = ".modal.fade.show .modal-dialog .modal-content .modal-footer .btn.btn-primary.btn-lg")
    private WebElement agreeDeleteProductButton;

    @FindBy(css = ".rounded-circle.person .material-icons")
    private WebElement iconForLogOut;

    @FindBy(css = "a[href*= 'AdminLogin&token=f90774d4cf1bef623f2802e0de734b2d&logout']")
    private WebElement logOutButton;

    protected AMenuAdminComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCatalogButton() {
        return catalogButton;
    }

    public void clickCatalog() {
        getCatalogButton().click();
    }

    public WebElement getProductsButton() {
        return productsButton;
    }
//      Create product
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

    public WebElement getCreateNewProductButton() {
        return createNewProductButton;
    }

    public void clickCreateNewProduct() {
        getCreateNewProductButton().click();
    }

//    Delete product
    public WebElement getDropdownDeleteButton() {
        return dropdownDeleteButton;
    }

    public void clickDropdownDeleteButton() {
        getDropdownDeleteButton().click();
    }

    public WebElement getDeleteProductButton() {
        return deleteProductButton;
    }

    public void clickDeleteProductButton() {
        getDeleteProductButton().click();
    }

    public WebElement getAgreeDeleteProductButton() {
        return agreeDeleteProductButton;
    }


    public void clickAgreeDeleteProductButton() {
        getAgreeDeleteProductButton().click();
    }

    //Log out
    public WebElement getIconForLogOut() {
        return iconForLogOut;
    }

    public void clickIconForLogOut() {
        getIconForLogOut().click();
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public void clickLogOutButton() {
        getLogOutButton().click();
    }

}
