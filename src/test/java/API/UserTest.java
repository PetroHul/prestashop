package API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
/*
* http://studio5f.online/api
* */
public class UserTest {
    @Test
    public void userId_3_IsMyUserTest() {
        get("http://Z8FVNB1KKDMU382ZPILGHIZ7J6ZWBV3H@studio5f.online/api/customers/?display=[firstname,lastname,email]&filter[id]=[3]").then().statusCode(200).assertThat()
                .body("prestashop.customers.customer.lastname", equalTo("Pupkin"))
                .body("prestashop.customers.customer.firstname", equalTo("Vasia"))
                .body("prestashop.customers.customer.email", equalTo("local_part@domain.com"));
    }
}
