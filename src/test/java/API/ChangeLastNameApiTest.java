package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.FileReaderWriter;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotEquals;
public class ChangeLastNameApiTest {
    String lastname = "";
    String lastname1 = "";

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "http://ZBWJI8GLDFZSRD4QNP76A9D6RKDXN6GT@studio5f.online/api";
    }

    @Test
    public void changeLastName() throws IOException {

        Response rs1 = given()
                .body(FileReaderWriter.generateStringFromXML("sources/customerOneData.xml"))
                .when()
                .get("/customers/1");

        lastname = rs1.getBody().xmlPath().getString("prestashop.customer.lastname");
        System.out.println(lastname);

        Response rs = given()
                .body(FileReaderWriter.generateStringFromXML("sources/customerOneData.xml"))
                .when()
                .put("/customers/1");

        lastname1 = rs.getBody().xmlPath().getString("prestashop.customer.lastname");

        System.out.println(lastname1);
        assertNotEquals(lastname,lastname1);

    }
}
