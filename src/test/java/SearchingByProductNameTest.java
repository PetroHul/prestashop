import data.Search;
import io.restassured.RestAssured;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.SearchEmptyResultPage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;
import tools.TestRunner;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.xml.HasXPath.hasXPath;

public class SearchingByProductNameTest extends TestRunner{

    @Test
    public void SearchingByProductNameTest(){
        //precondition
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        delayExecution(1000);
        List<String> products_name = new ArrayList<String>();
        products_name.add("Customizable Mug");
        products_name.add("Mug The Best Is Yet To Come");
        products_name.add("Mug The Adventure Begins");
        products_name.add("Mug Today Is A Good Day");
        products_name.add("Pack Mug + Framed Poster");

        Search search = Search.MUG;
        //steps
        searchResultPage.fillAll(search);
        delayExecution(1000);
        searchResultPage = searchResultPage.clickSearchProductButton();
        delayExecution(1000);
        System.out.println(searchResultPage.getProductListComponent().getProductsNameList());

        Assert.assertEquals(searchResultPage.getProductListComponent().getProductsNameList(),products_name);

    }

    @Test
    public void SortByProductNameZATest(){
        //precondition
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        delayExecution(1000);
        List<String> sortProducts_name = new ArrayList<String>();
        sortProducts_name.add("Pack Mug + Framed Poster");
        sortProducts_name.add("Mug Today Is A Good Day");
        sortProducts_name.add("Mug The Best Is Yet To Come");
        sortProducts_name.add("Mug The Adventure Begins");
        sortProducts_name.add("Customizable Mug");
        Search search = Search.MUG;
        //steps

        searchResultPage.fillAll(search);
        searchResultPage = searchResultPage.clickSearchProductButton();
        delayExecution(1000);

        searchResultPage.clickSortByButton();
        delayExecution(1000);

        searchResultPage.clickSortNameZAButton();
        delayExecution(3000);


        Assert.assertEquals(searchResultPage.getProductListComponent().getProductsNameList(),sortProducts_name);

    }

    @Test
    public void getErrorMassegeinInvalidSearchingTest(){

        SearchEmptyResultPage searchEmptyResultPage = new SearchEmptyResultPage(driver);
        delayExecution(1000);

        Search search = Search.SFDD;
        final String expectedSearch = search.toString().toLowerCase();
        //steps
        searchEmptyResultPage.fillAll(search);
        searchEmptyResultPage.clickSearchProductButton();
        delayExecution(1000);

        Assert.assertEquals(searchEmptyResultPage.getTextProductIsNotFoundMessage(),"Sorry for the inconvenience.");


    }


//    @Test
//    public void getProductFromAPI() {
//        get("http://Z8FVNB1KKDMU382ZPILGHIZ7J6ZWBV3H@studio5f.online/api/products?display=[name]&filter[id]=[3]&language=1")
//                .then()
//                .statusCode(200).assertThat()
//                .body("prestashop.products.product.name.language", equalTo("The best is yet to come' Framed poster"));
//
//    }

}
