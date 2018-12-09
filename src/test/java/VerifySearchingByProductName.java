import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;
import tools.TestRunner;

import java.util.ArrayList;
import java.util.List;

public class VerifySearchingByProductName extends TestRunner {

    @Test
    public void TestSearchingByProductName(){
        //precondition
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        delayExecution(1000);
        List<String> products_name = new ArrayList<String>();
        products_name.add("Customizable Mug");
        products_name.add("Mug The Best Is Yet To Come");
        products_name.add("Mug The Adventure Begins");
        products_name.add("Mug Today Is A Good Day");
        products_name.add("Pack Mug + Framed Poster");
        //steps
        searchResultPage.clearSearchProductField();

        searchResultPage.clickSearchProductField();
        delayExecution(1000);

        searchResultPage.setSearchProductField();
        delayExecution(1000);

        searchResultPage = searchResultPage.clickSearchProductButton();
        delayExecution(1000);

        Assert.assertEquals(searchResultPage.getProductListComponent().getProductsNameList(),products_name);

    }
}
