package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.FileReaderWriter;

import java.io.IOException;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


public class CartApiTest {

    String id = "";

    @BeforeTest
    public void setUp() throws IOException {
        RestAssured.baseURI = "http://ZBWJI8GLDFZSRD4QNP76A9D6RKDXN6GT@studio5f.online/api";

        Response rs =
                given()
                        .body(FileReaderWriter.generateStringFromXML("sources/cart.xml"))
                        .when()
                        .post("/carts");

        id = rs.getBody().xmlPath().getString("prestashop.cart.id");

        FileReaderWriter.saveInFile("sources/cartID.txt", id);

        System.out.println("save id = " + id);
    }

    @Test(priority = 2)
    public void verifyCart() throws IOException {

        id = FileReaderWriter.getFromFile("sources/cartID.txt");
        get("/carts/" + id)
                .then()
                .statusCode(200);
        System.out.println("presented id = " + id);
    }

    @Test(priority = 3)
    public void deleteFromCart() throws IOException {

        id = FileReaderWriter.getFromFile("sources/cartID.txt");

        given()
                .when()
                .delete("/carts/" + id)
                .then()
                .statusCode(200);

        System.out.println("delete id = " + id);

    }

}
