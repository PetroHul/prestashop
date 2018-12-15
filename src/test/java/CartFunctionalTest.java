import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import tools.CartFunctionalRunner;
import tools.TestRunner;


public class CartFunctionalTest extends CartFunctionalRunner {

    @BeforeMethod
    public void prepareCart() {
        addProductTOCart();
    }

    @Test
    public void addToCartTest() {

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        Assert.assertTrue(shoppingCartPage.getProductNameText().equals("Hummingbird printed t-shirt"));
    }

    @Test
    public void deleteProductFromShoppingCartTest() {

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickDeleteButton();
        ShoppingEmptyCartPage shoppingEmptyCartPage = new ShoppingEmptyCartPage(driver);

        Assert.assertTrue(shoppingEmptyCartPage.getMessageText().equals("There are no more items in your cart"));

    }

}
