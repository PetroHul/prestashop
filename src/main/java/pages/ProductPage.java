package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private WebElement addToCartButton;

//    this.addToCartButton = productLayout.findElement(By.cssSelector(".btn.btn-primary.add-to-cart"));




//    addToCartButton
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
    public void clickToAddButton(){
        getAddToCartButton().click();
    }
}
