package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SearchResultPage extends AHeadComponent {

    @FindBy(css = ".btn-unstyle.select-title")
    private WebElement sortByButton;

    @FindBy(css = "a[href*='=product.name.desc&s=mug']")
    private WebElement sortNameZAButton;

    @FindBy(css = ".h3.product-title a")
    private WebElement productName;

    private ProductListComponent productListComponent;
    private ProductComponent productComponent;


    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        productListComponent = new ProductListComponent(driver);

    }

    public WebElement getProductName() {
        return productName;
    }

    public String getProductNameText() {
        return getProductName().getText().toLowerCase();
    }
    public WebElement getSortByButton() {
        return sortByButton;
    }

    public void clickSortByButton() {
        getSortByButton().click();
    }

    public WebElement getSortNameZAButton() {
        return sortNameZAButton;
    }

    public void clickSortNameZAButton() {
        getSortNameZAButton().click();
    }

    public ProductListComponent getProductListComponent() {
        return productListComponent;
    }



}
