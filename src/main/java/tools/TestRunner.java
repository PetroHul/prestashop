package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://studio5f.online/en/");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
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
