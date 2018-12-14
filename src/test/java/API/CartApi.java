package API;

import static io.restassured.RestAssured.*;
import static io.restassured.config.XmlConfig.xmlConfig;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class CartApi {

//    final String url = "http://Z8FVNB1KKDMU382ZPILGHIZ7J6ZWBV3H@studio5f.online/api";

    @Test
    public void addToCart() {
        get("http://Z8FVNB1KKDMU382ZPILGHIZ7J6ZWBV3H@studio5f.online/api/carts/8").
                then().
                body(hasXPath("//id_product", containsString("1")));

    }


}
