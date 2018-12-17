package API;

import data.IUser;
import data.UserRepository;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.APItools;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AcountTest {
    @DataProvider(parallel = true)
    public Object[] removeAcounts() {
        return new Object[] {"183"};
    }

    @BeforeTest
    public void setUp () {
        RestAssured.baseURI = "http://ZBWJI8GLDFZSRD4QNP76A9D6RKDXN6GT@studio5f.online/api/";
    }

    @Test
    public void isEmailInBaseTest() {
        Assert.assertTrue(APItools.isEmailInBase(UserRepository.get().creatingUser().getEmail()));
    }

    @Test
    public void getUserEmailById() {
        Assert.assertEquals(APItools.getUserEmail("3"), "local_part@domain.com");
    }

    @Test
    public String createUser() throws IOException {
        IUser user = UserRepository.get().newUser();
        String id =
        given()
            .contentType("text/xml")
            .body(APItools.createUserXML(user)).
        when().
            post("customers").
        then().
            statusCode(201)
                .body("prestashop.customer.firstname", equalTo(user.getFirstName()))
                .body("prestashop.customer.lastname", equalTo(user.getLastName()))
                .body("prestashop.customer.email", equalTo(user.getEmail()))
                .extract().response().xmlPath().getString("prestashop.customer.id")
        ;
        return id;
    }

    @Test(dataProvider = "removeAcounts")
    public void deleteUser(String id) throws IOException {
        given().
        when().
            delete("customers/" + id).
        then().
            statusCode(200);
    }
}
