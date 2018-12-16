import data.Category;
import data.Currencies;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import tools.TestRunner;

public class CurrencyFunctionalTest extends TestRunner  {

//    private HomePage homePage;
//    @Test
//    public void checkCurrencyTest() {
//        CategoryPage accessoriesPage;
//        String actual;
//        String expected = Category.ACCESSORIES.toString();
//        //act
//        accessoriesPage = homePage.clickAccessoriesButton();
//        actual = accessoriesPage.getCategoryName();
//        //assert
//        Assert.assertEquals(actual, expected);
//    }

//        AHeadComponent currencyPage;
//        String actual;
//        String expected = Currencies.UAH.toString();
//act
//        currencyPage = homePage.clickCurrency();


//    }



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
