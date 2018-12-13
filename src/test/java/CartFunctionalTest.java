import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tools.TestRunner;


public class CartFunctionalTest extends TestRunner {
    @Test
    public void addProductToShoppingCartTest() {
        //arrange
        loadApplication();
        signIn();

        MyAccountPage accountUser = new MyAccountPage(driver);
        delayExplicitExecution(accountUser.getLogo());
        accountUser.clickLogo();


        //actual
        HomePage homePage = new HomePage(driver);
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickToAddButton();

        ProductMessagePage productMessagePage = new ProductMessagePage(driver);
        delayExplicitExecution(productMessagePage.getAlertMessageCloseButton());
        productMessagePage.closeAlertMessage();

        delayExecution(10000);
//        delayExplicitExecution(productMessagePage.getCartButton());

        productMessagePage.clickShoppingCart();
        ShoppingCartPage soppingCartPage = new ShoppingCartPage(driver);
        //assert
        Assert.assertTrue(soppingCartPage.getProductNameText().equals("Hummingbird printed t-shirt"));
    }

    @Test
    public void deleteProductFromShoppingCartTest() {

    }

}
