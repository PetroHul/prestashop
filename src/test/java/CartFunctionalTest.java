import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;
import pages.ShoppingEmptyCartPage;
import tools.CartFunctionalRunner;

public class CartFunctionalTest extends CartFunctionalRunner {

    @BeforeMethod
    public void addToCart() {
        addProductTOCart();
    }

    @Test
    public void addToCartTest() {

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        Assert.assertTrue(shoppingCartPage.getProductNameText().equals("Hummingbird printed t-shirt"));
    }

    @AfterMethod
    public void deleteProductFromShoppingCartTest() {

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickDeleteButton();

        ShoppingEmptyCartPage shoppingEmptyCartPage = new ShoppingEmptyCartPage(driver);

        Assert.assertTrue(shoppingEmptyCartPage.getMessageText().equals("There are no more items in your cart"));

    }
}
