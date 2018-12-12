package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressesPage extends AHeadComponent {
    //    @FindBy(how = How.CSS, using = (".page-header > h1");
    private WebElement heading;

    protected AddressesPage(WebDriver driver) {
        super(driver);
        heading = driver.findElement(By.cssSelector(".page-header > h1"));
    }

    public String getHeadingText() {
        return heading.getText().trim().toUpperCase();
    }
}
