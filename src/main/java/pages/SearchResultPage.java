package pages;

import org.openqa.selenium.WebDriver;

public class SearchResultPage extends AHeadComponent {

    public SearchResultPage(WebDriver driver){
        super(driver);
        initProductComponent();
    }

    private ProductListComponent productListComponent;

    private void initProductComponent() {
        productListComponent = new ProductListComponent(driver);
    }

    private ProductListComponent getProductListComponent(){
        return productListComponent;
    }

    public String getProductNameByPartialName(String partialProductName){
        return getProductListComponent().getProductComponentByPartialName(partialProductName).getNameText();
    }
}
