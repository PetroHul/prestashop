package API;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.APItools;
import tools.FileReaderWriter;

import java.io.*;


public class CartApi {

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

       FileReaderWriter.saveInFile("sources/saveId.txt", id);


    }

    @Test
    public void verifyCart() throws IOException {

        id = FileReaderWriter.getFromFile("sources/saveId.txt");
        System.out.println(id+"presented");

        get("/carts/"+id);

    }

    @Test
    public void deleteFromCart() throws IOException {

        id = FileReaderWriter.getFromFile("sources/saveId.txt");

        System.out.println(id + "delete");
        given().
                when().delete("/carts/" + id);
    }

}
