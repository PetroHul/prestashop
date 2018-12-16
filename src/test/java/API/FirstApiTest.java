//package API;
//
////import com.jayway.restassured.RestAssured;
//public class FirstApiTest {
//
//
//
//        import org.testng.AssertJUnit;
//        import org.testng.annotations.Test;
//        import static com.jayway.restassured.RestAssured.get;
//
//        import com.jayway.restassured.response.Response;
//        import org.json.JSONArray;
//        import org.json.JSONException;
//
//public class FirstApiTest {
//
//    @Test
//    public void getRequestFindCapital() throws JSONException {
//
//        // выполняем запрос get для доступа ко всем параметрам ответа
//        Response resp = get("http://restcountries.eu/rest/v1/name/ukraine");
//
//        JSONArray jsonResponse = new JSONArray(resp.asString());
//
//        // получение параметра capital (столицы Норвегии)
//        String capital = jsonResponse.getJSONObject(0).getString("capital");
//
//        // проверка, что столицей является Осло
//        AssertJUnit.assertEquals(capital, "Kiev");
//    }
//
//}
