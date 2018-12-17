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


public class CartApiTest {

    String id = "";

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "http://ZBWJI8GLDFZSRD4QNP76A9D6RKDXN6GT@studio5f.online/api";

    }

    @Test
    public void addToCart() throws IOException {

        Response rs = given()
                .body(APItools.generateStringFromXML("sources/cart.xml"))
                .when()
                .post("/carts");

        id = rs.getBody().xmlPath().getString("prestashop.cart.id");

        FileReaderWriter.saveInFile("sources/cartID.txt", id);

        System.out.println("save id " + id);

    }

    @Test
    public void verifyCart() throws IOException {

        id = FileReaderWriter.getFromFile("sources/cartID.txt");
        System.out.println("presented " + id);

        get("/carts/" + id).then().statusCode(200);

    }

    @Test
    public void deleteFromCart() throws IOException {

        id = FileReaderWriter.getFromFile("sources/cartID.txt");

        System.out.println("delete" + id);
        given().
                when().delete("/carts/" + id).then().statusCode(200);
    }

}
