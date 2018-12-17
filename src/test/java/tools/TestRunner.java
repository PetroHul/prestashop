package tools;

import data.IUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginAdminPage;
import pages.LoginPage;
import pages.ProductsAdminPage;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        String property = System.getProperty("user.dir") + "/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", property);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://studio5f.online/en/");
    }

    protected HomePage loadApplication() {
        return new HomePage(driver);
    }

    protected HomePage loadApplication(IUser user) {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton()
                .logInAcount(user)
                .getLogo()
                .click();
        return new HomePage(driver);
    }

    public LoginAdminPage loadAdminPage() {
        return new LoginAdminPage(driver);
    }

    protected ProductsAdminPage signInAsAdmin() {

        driver.get("http://studio5f.online/admin166mehs6u/index.php?controller=AdminLogin&token=f90774d4cf1bef623f2802e0de734b2d&logout");

        final String email = "set@set.ua";
        final String password = "12345678";

        LoginAdminPage loginAdminPage = loadAdminPage();
        loginAdminPage.fillLoginForm(email, password);

        return new ProductsAdminPage(driver);

    }

    protected void delayExplicitExecution(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void delayExecution(long miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void signIn() {

        final String email = "User@gmail.com";
        final String password = "qwerty";

        HomePage homePage = loadApplication();
        homePage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.signIn(email, password);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
