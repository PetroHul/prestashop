package tools;

import data.IUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {

    protected WebDriver driver;
    private Object IUser;

    @BeforeClass
    public void setUp() {
        String property = System.getProperty("user.dir") + "/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", property);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://studio5f.online/en/");
    }

    protected HomePage loadAplication() {
        return new HomePage(driver);
    }

    protected HomePage loadAplication(IUser user) {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton()
                .logInAcount(user)
                .getLogo()
                .click();
        return new HomePage(driver);
    }

    protected void delayExplicitExecution(WebElement webElement){
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

    protected void sigiIn() {

        final String email = "User@gmail.com";
        final String password = "qwerty";

        HomePage homePage = loadAplication();
        homePage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.fillLoginForm(email, password);


    }
}
