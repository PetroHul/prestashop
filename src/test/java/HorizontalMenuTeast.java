

import data.Category;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tools.TestRunner;


public class HorizontalMenuTeast extends TestRunner {
    @Test
    public void addProductToShoppingCart() {
        //arrange
        HomePage homePage = loadApplication();
        CategoryPage accessoriesPage;
        String actual;
        String expected = Category.ACCESSORIES.toString();

        //act
        accessoriesPage = homePage.clickAccesssoriesButton();
        actual = accessoriesPage.getCategoryName();
        //assert
         Assert.assertEquals(actual,expected);





    }
}
