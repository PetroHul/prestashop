import data.Product;
import data.Search;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateNewProductPageInAdmin;
import pages.ProductsAdminPage;
import pages.SearchResultPage;
import tools.TestRunner;

public class SearchCreatedProductTest extends TestRunner {
    @BeforeMethod
    public void searchCreatedProductTest() {

        Product product = Product.CUPS1;
        ProductsAdminPage productsAdminPage = signInAsAdmin();
        CreateNewProductPageInAdmin createNewProduct = new CreateNewProductPageInAdmin(driver);


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


        Search search = Search.CUPS1;
        final String expectedSearch = search.toString().toLowerCase();

        //steps
        searchResultPage.fillAll(search);

        searchResultPage = searchResultPage.clickSearchProductButton();
        delayExecution(1000);

        Assert.assertEquals(searchResultPage.getProductNameText(), expectedSearch);


    }

    @AfterMethod
    public void deleteProduct(){
        ProductsAdminPage productsAdminPage = signInAsAdmin();
        CreateNewProductPageInAdmin createNewProduct = new CreateNewProductPageInAdmin(driver);

        createNewProduct.clickDropdownDeleteButton();
        createNewProduct.clickDeleteProductButton();
        createNewProduct.clickAgreeDeleteProductButton();
        createNewProduct.clickIconForLogOut();
        createNewProduct.clickLogOutButton();

    }



}