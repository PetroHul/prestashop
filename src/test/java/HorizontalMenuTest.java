

import data.Category;
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
        String expected = Category.ACCESSORIES.toString();

        //act
        accessoriesPage = homePage.clickAccessoriesButton();
        actual = accessoriesPage.getCategoryName();
        //assert
         Assert.assertEquals(actual,expected);


        public void addProductToShoppingCart() {
            //arrange
            HomePage homePage1 = loadAplication();
            CategoryPage accessoriesPage;
            String actual;
            String expected = Category.ACCESSORIES.toString();

            //act
            accessoriesPage = homePage.clickAccessoriesButton();
            actual = accessoriesPage.getCategoryName();
            //assert
            Assert.assertEquals(actual,expected);





    }
}
