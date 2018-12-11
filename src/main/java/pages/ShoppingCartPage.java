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

//    private void initProduct() {
//        this.productName = driver.findElement(By.cssSelector(".product-line-info [href]"));
//        this.productPrice = driver.findElement(By.cssSelector("span.product-price"));
////        this.deleteButton = driver.findElement(By.xpath(".remove-from-cart"));
//    }

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
