package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends AHeadComponent{
    @FindBy(css = ".product-line-info [href]")
    private WebElement productName;

    @FindBy(css ="span.product-price")
    private WebElement productPrice;

//    private WebElement deleteButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getProductName() {
        return productName;
    }
    public String getProductNameText() {
        return getProductName().getText();
    }

//    public WebElement getDeleteButton() {
//        return deleteButton;
//    }
}
