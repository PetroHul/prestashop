import data.Product;
import data.Search;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateNewProductPage;
import pages.ProductsAdminPage;
import pages.SearchResultPage;
import tools.TestRunner;

public class SearchCreatedProductTest extends TestRunner {
    @BeforeMethod
    public void searchCreatedProductTest() {

        Product product = Product.CUPS1;
        final String expectedProduct = product.getProductBodyText();
        ProductsAdminPage productsAdminPage = signInAsAdmin();
        CreateNewProductPage createNewProduct = new CreateNewProductPage(driver);


        createNewProduct.clickCreateNewProduct();

        createNewProduct.fillAll(product);
        createNewProduct.clicDropdownButton();

        createNewProduct.clickAddNewProductButton();

        createNewProduct.clickIconForLogOut();
        createNewProduct.clickLogOutButton();

    }
    @Test
    public void TestSearchingByProductName(){
        //precondition
        driver.get("http://studio5f.online/en/");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        delayExecution(1000);


        Search search = Search.CUP1;
        final String expectedSearch = search.getSearchBodyText();

        //steps
        searchResultPage.fillAll(search);

        searchResultPage = searchResultPage.clickSearchProductButton();
        delayExecution(1000);

        Assert.assertTrue(searchResultPage.getProductNameText().equals(expectedSearch));


    }

    @AfterMethod
    public void deleteProduct(){
        ProductsAdminPage productsAdminPage = signInAsAdmin();
        CreateNewProductPage createNewProduct = new CreateNewProductPage(driver);
        createNewProduct.clickDropdownDeleteButton();
        createNewProduct.clickDeleteProductButton();
        createNewProduct.clickAgreeDeleteProductButton();
        createNewProduct.clickIconForLogOut();
        createNewProduct.clickLogOutButton();

    }



}