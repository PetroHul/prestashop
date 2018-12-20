package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends AHeadComponent {
    @FindBy(css = ".product-line-info [href]")
    private WebElement productName;

    @FindBy(css = "span.product-price")
    private WebElement productPrice;

    @FindBy(css = ".remove-from-cart")
    private WebElement deleteButton;

    @FindBy(css = "a[href*='order'].btn.btn-primary")
    private WebElement orderButton;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //productname
    public WebElement getProductName() {
        return productName;
    }

    public String getProductNameText() {
        return getProductName().getText();
    }

    //deleteButton
    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public ShoppingEmptyCartPage clickDeleteButton() {
        getDeleteButton().click();
        return new ShoppingEmptyCartPage(driver);
    }

    //orderButton
    public WebElement getOrderButton() {
        return orderButton;
    }

    public void clickOrderButton() {
        getOrderButton().click();
    }
}
