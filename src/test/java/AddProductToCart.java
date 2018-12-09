import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tools.TestRunner;

import java.util.concurrent.TimeUnit;


public class AddProductToCart extends TestRunner {
    @Test
    public void test1() throws InterruptedException {
        //arrange
        HomePage homePage = loadAplication();
        delayExecution(1000);
        //actual
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickToAddButton();
        delayExecution(1000);

        ProductMessagePage productMessagePage = new ProductMessagePage(driver);
        productMessagePage.closeAlertMessage();

        delayExecution(10000);

        productMessagePage.clickShoppingCart();
        ShoppingCartPage soppingCartPage = new ShoppingCartPage(driver);
        //assert
        Assert.assertTrue(soppingCartPage.getProductNameText().equals("Hummingbird printed t-shirt"));
    }


}
