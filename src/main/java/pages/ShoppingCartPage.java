package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {

    private WebDriver driver;
    private WebElement productName;
    private WebElement productPrice;
    private WebElement deleteButton;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        initProduct();
    }

    private void initProduct() {
        this.productName = driver.findElement(By.cssSelector(".product-line-info [href]"));
        this.productPrice = driver.findElement(By.cssSelector("span.product-price"));
//        this.deleteButton = driver.findElement(By.xpath(".remove-from-cart"));
    }

    public WebElement getProductName() {
        return productName;
    }
    public String getProductNameText() {
        return getProductName().getText();
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }
}
