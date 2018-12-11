package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AHeadComponent {

    @FindBy(css = "h1[itemprop = 'name']")
    private WebElement productName;

    @FindBy(css = ".product-prices")
    private WebElement productPrice;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
//        initProductComponent();
    }

//    private void initProductComponent() {
//        this.productName = driver.findElement(By.cssSelector("h1[itemprop = 'name']"));
//        this.productPrice = driver.findElement(By.cssSelector(".product-prices"));
//        this.addToCartButton = driver.findElement(By.cssSelector(".btn.btn-primary.add-to-cart"));
//    }


    //    addToCartButton
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void clickToAddButton() {
        getAddToCartButton().click();
    }

}
