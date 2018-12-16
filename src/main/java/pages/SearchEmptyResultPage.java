package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchEmptyResultPage extends AHeadComponent{

    @FindBy(css = ".page-content.page-not-found h4")
    private WebElement productIsNotFoundMessage;

    public SearchEmptyResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getProductIsNotFoundMessage() {
        return productIsNotFoundMessage;
    }

    public String getTextProductIsNotFoundMessage(){
        return getProductIsNotFoundMessage().getText().trim();
    }
}
