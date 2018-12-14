import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;
import tools.TestRunner;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.xml.HasXPath.hasXPath;

public class VerifySearchingByProductName extends TestRunner{

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
    @Test
    public void getProductFromAPI() {
        get("http://Z8FVNB1KKDMU382ZPILGHIZ7J6ZWBV3H@studio5f.online/api/products?display=[name]&filter[id]=[3]&language=1")
                .then()
                .statusCode(200).assertThat()
                .body("prestashop.products.product.name.language", equalTo("The best is yet to come' Framed poster"));

    }

}
