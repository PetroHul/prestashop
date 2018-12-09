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

    public ProductListComponent getProductListComponent(){
        return productListComponent;
    }


}
