package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends AHeadComponent {


    private WebElement productName;
    private WebElement productPrice;
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        initProductComponent();
    }

    private void initProductComponent() {
        this.productName = driver.findElement(By.cssSelector("h1[itemprop = 'name']"));
        this.productPrice = driver.findElement(By.cssSelector(".product-prices"));
        this.addToCartButton = driver.findElement(By.cssSelector(".btn.btn-primary.add-to-cart"));
    }


    //    addToCartButton
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void clickToAddButton() {
        getAddToCartButton().click();
    }

}
