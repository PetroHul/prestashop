import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductMessagePage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import tools.TestRunner;


public class CartFunctionalTest extends TestRunner {
    @Test
    public void addProductToShoppingCart() {
        //arrange
        HomePage homePage = loadAplication();
        delayExecution(1000);
        //actual
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickToAddButton();

        delayExecution(10000);

        ProductMessagePage productMessagePage = new ProductMessagePage(driver);
        productMessagePage.closeAlertMessage();

        delayExecution(10000);
        productMessagePage.clickShoppingCart();
        ShoppingCartPage soppingCartPage = new ShoppingCartPage(driver);
        //assert
        Assert.assertTrue(soppingCartPage.getProductNameText().equals("Hummingbird printed t-shirt"));
    }


}
