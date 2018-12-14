package API;
//import org.testng.annotations.Test;
//import pages.HomePage;
//import pages.LoginPage;
//import tools.TestRunner;
//
//import java.util.concurrent.TimeUnit;
//
//import static io.restassured.RestAssured.given;
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
//import org.testng.annotations.Test;
////import com.jayway.restassured.RestAssured;
//import static org.testng.Assert.assertTrue;
//import org.xml.sax.
//public class FirstApiTest {
//
//    @Test
//    public void testFirstAPI() throws InterruptedException{
//        given().
//                get("http://Z59BV19EUGEUMFAFWRL2DBRGMF4114MF@studio5f.online/api/products/2").
//         then().
//                body(RestResponse.result.name)
//    }
//
//
////    @Before
////    public void setup() {
////        RestAssured.baseURI = "https://api.github.com";
////        RestAssured.port = 443;
////    }
////
//}

        import org.testng.AssertJUnit;
        import org.testng.annotations.Test;
        import static com.jayway.restassured.RestAssured.get;

        import com.jayway.restassured.response.Response;
        import org.json.JSONArray;
        import org.json.JSONException;

public class FirstApiTest {

    @Test
    public void getRequestFindCapital() throws JSONException {

        // выполняем запрос get для доступа ко всем параметрам ответа
        Response resp = get("http://restcountries.eu/rest/v1/name/ukraine");

        JSONArray jsonResponse = new JSONArray(resp.asString());

        // получение параметра capital (столицы Норвегии)
        String capital = jsonResponse.getJSONObject(0).getString("capital");

        // проверка, что столицей является Осло
        AssertJUnit.assertEquals(capital, "Kiev");
    }
}
