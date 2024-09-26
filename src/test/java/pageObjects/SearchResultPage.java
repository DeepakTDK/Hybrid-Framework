package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria')]")
    WebElement invalidProductMessage;

    @FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[1]")
    WebElement productOne;

    @FindBy(xpath = "//div[@id='product-search']//div[2]//div[1]//div[2]//div[2]//button[1]//span[1]")
    WebElement productTwo;

    public String getInvalidProductMessageText() {
        return invalidProductMessage.getText();
    }

    public void clickProductOne(){
        productOne.click();
    }

    public void clickProductTwo(){
        productTwo.click();
    }
}
