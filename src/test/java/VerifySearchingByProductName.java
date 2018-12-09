import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;
import tools.TestRunner;

public class VerifySearchingByProductName extends TestRunner {

    @Test
    public void TestSearchingByProductName(String partialProductName){
        //precondition
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        delayExecution(1000);
        //steps
        searchResultPage.clearSearchProductField();

        searchResultPage.clickSearchProductField();
        delayExecution(1000);

        searchResultPage.setSearchProductField();
        delayExecution(1000);

        searchResultPage.clickSearchProductButton();
        delayExecution(1000);

        Assert.assertTrue(searchResultPage.getProductNameByPartialName(partialProductName).equals("Customizable Mug"));

    }
}
