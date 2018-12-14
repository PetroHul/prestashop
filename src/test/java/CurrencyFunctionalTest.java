import data.Category;
import data.Currencies;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AHeadComponent;
import pages.CategoryPage;
import pages.HomePage;
import tools.TestRunner;

public class CurrencyFunctionalTest extends TestRunner  {

    private HomePage homePage;
    @Test
    public void checkCurrencyTest() {
//        CategoryPage accessoriesPage;
//        String actual;
//        String expected = Category.ACCESSORIES.toString();
//        //act
//        accessoriesPage = homePage.clickAccessoriesButton();
//        actual = accessoriesPage.getCategoryName();
//        //assert
//        Assert.assertEquals(actual, expected);
//    }

        AHeadComponent currencyPage;
        String actual;
        String expected = Currencies.UAH.toString();
//act
//        currencyPage = homePage.clickCurrency();


    }
}
