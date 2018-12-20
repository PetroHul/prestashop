package API;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.FileReaderWriter;


import java.io.IOException;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasXPath;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProductTest {

    @Test
    public void getProductFromAPI() {
        get("http://Z8FVNB1KKDMU382ZPILGHIZ7J6ZWBV3H@studio5f.online/api/products?display=[name]&filter[id]=[3]&language=1")
                .then()
                .statusCode(200).assertThat()
                .body("prestashop.products.product.name.language", equalTo("The best is yet to come' Framed poster"));
    }

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "http://ZBWJI8GLDFZSRD4QNP76A9D6RKDXN6GT@studio5f.online/api";
    }

    @Test
    public void createNewProduct() throws IOException {
        given()
                .body(FileReaderWriter.generateStringFromXML("sources/create_product.xml"))
                .when()
                .post("/products");
    }

    @Test
    public void verifyProduct() {
        get("/products").
                then().assertThat().
                body(hasXPath("//*[@id=last()]"));

    }
}
