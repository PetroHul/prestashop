

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tools.TestRunner;

import javax.swing.plaf.ActionMapUIResource;


public class HorizontalMenuTeast extends TestRunner {
    @Test
    public void addProductToShoppingCart() {
        //arrange
        HomePage homePage = loadAplication();
        CategoryPage accessoriesPage;
        String actual;
        String expected = "ACCESSORIES";

        //act
        accessoriesPage = homePage.clickAccesssoriesButton();
        actual = accessoriesPage.getCategoryName();
        //assert
         Assert.assertEquals(actual,expected);





    }
}
