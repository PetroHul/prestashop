package pages;

import data.Address;
import data.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPageInAdmin extends AMenuAdminComponent {

    @FindBy(css = "#form_step1_name_2")
    WebElement nameProductInput;

    @FindBy(css = "#form_step6_reference")
    WebElement articuleInput;

    @FindBy(css = "#form_step1_qty_0_shortcut")
    WebElement productCountInput;

    @FindBy(css = "#form_step1_price_shortcut")
    WebElement productPriceInput;

    @FindBy(css = "#dropdownMenu")
    WebElement dropdownButton;

    @FindBy(css = ".dropdown-item.go-catalog.js-btn-save")
    WebElement addNewProductButton;


    public CreateNewProductPageInAdmin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private void fill(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    public void fillAll(Product data) {
        fill(nameProductInput, data.getName());
        fill(articuleInput, data.getArticle());
        fill(productCountInput, data.getCount());
        fill(productPriceInput, data.getPrice());
    }

    public WebElement getAddNewProductButton() {
        return addNewProductButton;
    }

    public void clickAddNewProductButton() {
        getAddNewProductButton().click();
    }

    public WebElement getDropdownButton() {
        return dropdownButton;
    }

    public void clicDropdownButton() {
        getDropdownButton().click();
    }


}
