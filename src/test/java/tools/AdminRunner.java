package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginAdminPage;
import pages.ProductsAdminPage;

public class AdminRunner extends TestRunner {
    protected WebDriver adminDriver;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        adminDriver = new ChromeDriver();
    }

    @AfterClass(alwaysRun = true)
    @Override
    public void tearDown() {
        super.tearDown();
        adminDriver.quit();
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        adminDriver.get("http://studio5f.online/admin166mehs6u/index.php?controller=AdminLogin&token=f90774d4cf1bef623f2802e0de734b2d&logout");
    }

    protected LoginAdminPage loadAdminPage() {
        return new LoginAdminPage(adminDriver);
    }

    protected ProductsAdminPage signInAsAdmin(){
        final String email = "set@set.ua";
        final String password ="12345678";

        LoginAdminPage loginAdminPage = loadAdminPage();
        loginAdminPage.fillLoginForm(email, password);

        return new ProductsAdminPage(adminDriver);

    }
}
