package API;
import static io.restassured.RestAssured.*;
import static io.restassured.config.XmlConfig.xmlConfig;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.RandomString;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.OkHttpClient;
import org.testng.annotations.*;
import tools.APItools;
import tools.FileReaderWriter;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.NamespaceContext;
import java.io.*;
public class FirstApiTest {
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
