import org.testng.*;
import org.testng.annotations.Test;
import pages.*;
import tools.TestRunner;
public class LoginPageTest extends TestRunner {

    @Test
    public void testLogin() throws InterruptedException {

        HomePage homePage = loadAplication();

        //HomePage homePage = HomePage()


        // .fillLoginForm('barzoom5@gmailcom',"529440");
    }
}