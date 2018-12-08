import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tools.TestRunner;

import java.util.concurrent.TimeUnit;


public class AddProductToCart extends TestRunner {
    @Test
    public void test1() throws InterruptedException {
        //precondition
        HomePage homePage = loadAplication();
        delayExecution(1000);
        //steps
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickToAddButton();

        Thread.sleep(10000);
        driver.get("http://studio5f.online/en/cart?action=show");
        ShoppingCartPage soppingCartPage=  new ShoppingCartPage(driver);
//        soppingCartPage.getProductName();

        Assert.assertTrue(soppingCartPage.getProductNameText().equals("Hummingbird printed t-shirt"));
    }


}
