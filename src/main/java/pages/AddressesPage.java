package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage extends AHeadComponent {
    @FindBy(css = ".page-header > h1")
    private WebElement heading;

    protected AddressesPage(WebDriver driver) {
        super(driver);
            PageFactory.initElements(driver, this);
    }

    public String getHeadingText() {
        return heading.getText().trim().toUpperCase();
    }
}
