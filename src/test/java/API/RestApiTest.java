package API;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestApiTest {



    @Test
    public void testUserRegistrationResponceStatusOK() {

        RequestSpecification request = given();
        request.header("Content-Type", "text/xml");
        request.body("id_customer=&id_gender=2&firstname=arg&lastname=arg&email=arfttffg@40ede.com&password=argsethaegaeghaeaerga&birthday=&submitCreate=1");


        Response response = request.post("http://studio5f.online/en/login?create_account=1");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);

    }

    @Test
    public void testGetTshortBySizeReturnStatusOK() {
        given()
                .queryParam("q", "Size-L").queryParam("from-xhr")
                .when()
                    .get("http://studio5f.online/en/4-men")
                .then()
                    .assertThat().statusCode(200);
    }


}
