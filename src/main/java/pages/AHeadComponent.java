package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AHeadComponent  {
    protected WebDriver driver;

//    need for search, will change to enum
    protected final String SEARCH_VALUE= "mug";

    protected AHeadComponent(WebDriver driver){
        this.driver = driver;

    }

//    search
    public WebElement getSearchProductField(){
        return driver.findElement(By.name("s"));
    }
    public String getSearchProductFieldText(){
        return getSearchProductField().getAttribute(SEARCH_VALUE);
    }
    public void setSearchProductField(String text){
        getSearchProductField().sendKeys(text);
    }
    public void clearSearchProductField(){
        getSearchProductField().clear();
    }
    public WebElement getSearchProductButton(){
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }
    public void clickSearchProductButton(){
        getSearchProductButton().click();
    }

}
