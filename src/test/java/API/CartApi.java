package API;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.APItools;

import java.io.*;


public class CartApi {

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "http://ZBWJI8GLDFZSRD4QNP76A9D6RKDXN6GT@studio5f.online/api";

    }


//    @Test
//    public void cartTest() {
//        given()
//                .when()
//                .contentType (ContentType.XML)
//                .delete (String.valueOf(hasXPath("//prestashop/carts/cart[last()]")));
//
//    }

//    @Test
//    public void cartTest() {
//        given().pathParam("slotID", hasXPath("//*[@id=last()]"))
//                .when().delete("/carts/{slotID}")
//                .then().statusCode(200);
//    }

//    @Test
//    public void cartTest() {
//        given().
//                config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true))).
//                when().
//                delete("/carts").
//                then().
//                body(hasXPath("//*[@id=last()]"));
//    }

//

    //    @Test
//    public void cartTest() {
//
//        String id = String.valueOf(hasXPath("//*[@id=last()]"));
//
//
//        given().pathParam("slotID",id).
//                when().
//                delete("/carts/{slotID}");
//
//    }
//


    @Test
    public void addToCart() throws IOException {

        Response rs = given()
                        .body(APItools.generateStringFromXML("xml_sources/cart.xml"))
                        .when()
                        .post("/carts");


    }

    @Test
    public void verifyCart() {
        get("/carts").
                then().assertThat().
                body(hasXPath("//*[@id=last()]"));

    }

    @Test
    public void deleteFromCart() {
        given().
                when().delete("/carts/637");
    }

}
