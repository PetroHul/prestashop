package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SearchResultPage;

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
        driver.get("http://studio5f.online/en/");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

//    @BeforeMethod
//    public void beforeMethod() {
//        driver.get("http://localhost/PRESTASHOP/en/index.php");
//    }

    protected HomePage loadAplication(){
        return new HomePage(driver);
    }

    protected void delayExecution(long miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
