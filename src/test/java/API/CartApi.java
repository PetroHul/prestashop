package API;

import static io.restassured.RestAssured.*;
import static io.restassured.config.XmlConfig.xmlConfig;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.OkHttpClient;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;


public class CartApi {


//    @Test
//    public void addToCart() {
//        get("http://Z8FVNB1KKDMU382ZPILGHIZ7J6ZWBV3H@studio5f.online/api/carts/8").
//                then().
//                body(hasXPath("//id_product", containsString("1")));
//
//    }


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
    public void cartTest() throws IOException {

        File xmlFile = new File("cart.xml");
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufReader = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();
        while (line != null) {
            sb.append(line).append("\n");
            line = bufReader.readLine();
        }
        String xml2String = sb.toString();

        given()
                .body(xml2String)
                .when()
                .post("/carts");

    }

    @Test
    public void tes() throws IOException {

        given()
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<prestashop xmlns:xlink=\"http://www.w3.org/1999/xlink\">\r\n<cart>\r\n\t<id></id>\r\n\t<id_address_delivery></id_address_delivery>\r\n\t<id_address_invoice></id_address_invoice>\r\n\t<id_currency>1</id_currency>\r\n\t<id_customer>1</id_customer>\r\n\t<id_guest></id_guest>\r\n\t<id_lang>1</id_lang>\r\n\t<id_shop_group></id_shop_group>\r\n\t<id_shop></id_shop>\r\n\t<id_carrier></id_carrier>\r\n\t<recyclable></recyclable>\r\n\t<gift></gift>\r\n\t<gift_message></gift_message>\r\n\t<mobile_theme></mobile_theme>\r\n\t<delivery_option></delivery_option>\r\n\t<secure_key></secure_key>\r\n\t<allow_seperated_package></allow_seperated_package>\r\n\t<date_add></date_add>\r\n\t<date_upd></date_upd>\r\n<associations>\r\n<cart_rows>\r\n\t<cart_row>\r\n\t<id_product>1</id_product>\r\n\t<id_product_attribute></id_product_attribute>\r\n\t<id_address_delivery></id_address_delivery>\r\n\t<quantity></quantity>\r\n\t</cart_row>\r\n</cart_rows>\r\n</associations>\r\n</cart>\r\n</prestashop>\r\n")
                .when()
                .post("/carts");

    }


}
