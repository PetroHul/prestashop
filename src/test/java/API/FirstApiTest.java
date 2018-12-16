package API;
import static io.restassured.RestAssured.*;
import static io.restassured.config.XmlConfig.xmlConfig;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.OkHttpClient;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.NamespaceContext;
import java.io.*;
public class FirstApiTest {

    @Test
    public void getRequestFindCapital()  {


    }
}
