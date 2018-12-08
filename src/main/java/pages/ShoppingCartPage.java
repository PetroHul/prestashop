package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {

    private WebDriver driver;
    private WebElement productName;
    private WebElement productPrice;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        initProductComponent();
    }

    private void initProductComponent() {
        this.productName = driver.findElement(By.cssSelector(".product-line-info [href]"));
        this.productPrice = driver.findElement(By.cssSelector("span.product-price"));
    }

    public WebElement getProductName() {
        return productName;
    }
    public String getProductNameText() {
        return getProductName().getText();
    }

}
