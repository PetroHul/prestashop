package API;

import static io.restassured.RestAssured.*;
import static io.restassured.config.XmlConfig.xmlConfig;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.OkHttpClient;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.NamespaceContext;
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
