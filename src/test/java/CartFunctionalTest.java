import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tools.TestRunner;


public class CartFunctionalTest extends TestRunner {
    @Test
    public void addProductToShoppingCartTest() {
        //arrange
        HomePage homePage = loadApplication();
        delayExecution(1000);

        sigiIn();

        delayExecution(10000);

        MyAccountPage accountUser = new MyAccountPage(driver);
        accountUser.clickLogo();
        delayExecution(10000);

        //actual
        HomePage homePage1 = new HomePage(driver);
        homePage1.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();
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

    @Test
    public void deleteProductFromShoppingCartTest() {

    }

}
