package API;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.APItools;
import tools.FileReaderWriter;

import java.io.IOException;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;

public class ProductTest {


    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "http://ZBWJI8GLDFZSRD4QNP76A9D6RKDXN6GT@studio5f.online/api";
    }

    @Test
    public void getProductFromAPI() {
        get("/products?display=[name]&filter[id]=[3]&language=1")
                .then()
                .statusCode(200).assertThat()
                .body("prestashop.products.product.name.language", equalTo("The best is yet to come' Framed poster"));

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
