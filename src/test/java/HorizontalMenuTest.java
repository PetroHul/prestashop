

import data.Category;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tools.TestRunner;

import javax.swing.plaf.ActionMapUIResource;


public class HorizontalMenuTest extends TestRunner {

    @Test
    public void checkClothes() {
        //arrange
        HomePage homePage = loadAplication();
        CategoryPage clothesPage;
        String actual;
        String expected = Category.CLOTHES.toString();
        //act
        clothesPage = homePage.clickClothesButton();
        actual = clothesPage.getCategoryName();
        //assert
        Assert.assertEquals(actual, expected);


    }

    @Test
    public void checkAccessories() {
        //arrange
        HomePage homePage1 = loadAplication();
        CategoryPage accessoriesPage;
        String actual;
        String expected = Category.ACCESSORIES.toString();
        //act
        accessoriesPage = homePage1.clickAccessoriesButton();
        actual = accessoriesPage.getCategoryName();
        //assert
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void checkArt() {
        //arrange
        HomePage homePage3 = loadAplication();
        CategoryPage artPage;
        String actual;
        String expected = Category.ART.toString();
        //act
        artPage = homePage3.clickArtButton();
        actual = artPage.getCategoryName();
        //assert
        Assert.assertEquals(actual, expected);


    }
}

