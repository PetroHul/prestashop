package API;

import data.IUser;
import data.UserRepository;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.APItools;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AcountTest {
    String acountId;
    IUser acountUser = UserRepository.get().newUser();

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "http://ZBWJI8GLDFZSRD4QNP76A9D6RKDXN6GT@studio5f.online/api/";
    }

    @Test
    public void emailIsNewTest() {
        Assert.assertTrue(!APItools.isEmailInBase(acountUser.getEmail()));
    }

    @Test(priority = 1)
    public void createUserTest() throws IOException {
        acountId = APItools.createUser(acountUser);
    }

    @Test(priority = 2)
    public void getUserEmailByIdTest() {
        Assert.assertEquals(APItools.getUserEmail(acountId), acountUser.getEmail());
    }

    @Test(priority = 3)
    public void deleteUserTest() throws IOException {
        given().
                when().
                delete("customers/" + acountId).
                then().
                statusCode(200);
    }
}
