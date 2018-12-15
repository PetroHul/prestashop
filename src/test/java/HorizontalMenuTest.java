import data.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.HomePage;
import tools.TestRunner;


public class HorizontalMenuTest extends TestRunner {

    public HomePage homePage;
    @BeforeMethod
    public void init() {
    homePage = loadApplication();
    }

    @Test
    public void checkClothes() {
        //arrange

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
        CategoryPage accessoriesPage;
        String actual;
        String expected = Category.ACCESSORIES.toString();
        //act
        accessoriesPage = homePage.clickAccessoriesButton();
        actual = accessoriesPage.getCategoryName();
        //assert
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void checkArt() {
        //arrange

        CategoryPage artPage;
        String actual;
        String expected = Category.ART.toString();
        //act
        artPage = homePage.clickArtButton();
        actual = artPage.getCategoryName();
        //assert
        Assert.assertEquals(actual, expected);


    }

    @Test
    public void testMouseHoverWorksProperlyClothes() {
        //arrange

        String expected = Category.MEN.toString();
        //act
        homePage.hoverClothesButton();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category-4")));
        WebElement menElement = driver.findElement(By.cssSelector("#category-4"));
        String actual = menElement.getText();


        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testMouseHoverWorksPropertyAccessories() {
        //arrange

        String expected = Category.STATIONERY.toString();
        //act
        homePage.hoverAccessoriesButton();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category-7")));
        WebElement stationeryElement = driver.findElement(By.cssSelector("#category-7"));
        String actual = stationeryElement.getText();

        Assert.assertEquals(actual, expected);
    }

}

