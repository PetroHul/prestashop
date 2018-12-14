package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingEmptyCartPage extends ShoppingCartPage {

    @FindBy(css = ".no-items")
    private WebElement message;

    public ShoppingEmptyCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getMessage() {
        return message;
    }

    public String getMessageText() {
        return getMessage().getText();
    }
}
