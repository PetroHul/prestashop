package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static API.APIclient.generateBytesArrayFromResource;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;

/*
* http://studio5f.online/api
* */
public class UserTest {
    @BeforeTest
    public void setUp () {
        RestAssured.baseURI = "http://ZBWJI8GLDFZSRD4QNP76A9D6RKDXN6GT@studio5f.online/api/";
    }

    @Test
    public void getMyUserTest() {
        get("customers/?display=[firstname,lastname,email]&filter[id]=[3]").then().statusCode(200).assertThat()
                .body("prestashop.customers.customer.lastname", equalTo("Pupkin"))
                .body("prestashop.customers.customer.firstname", equalTo("Vasia"))
                .body("prestashop.customers.customer.email", equalTo("local_part@domain.com"));
    }

    @Test
    public void createUser() throws IOException {
        byte[] myRequest = generateBytesArrayFromResource("xml_sources/create_user.xml");

        given()
            .contentType("text/xml")
            .body(myRequest).
        when().
            post("customers/").
        then().
            statusCode(201).
                body("prestashop.customer.id", equalTo("id"));//TODO getID
    }

//    @Test
//    public void deliteUser() throws IOException {
//        given().
//        when().
//            delete("customers/48").
//        then().
//            statusCode(201).
//                body("prestashop.customer.id", equalTo("id"));//TODO getID
//    }


}
