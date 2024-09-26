package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//table[@class = 'table table-striped']//tr")
    List<WebElement> cartTable;

    @FindBy(xpath = "//span[@id='cart-total']")
    WebElement cartBtn;

    @FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
    WebElement shoppingCartBtn;

    @FindBy(xpath = "//input[starts-with(@name, 'quantity')]")
    WebElement inputQuantity;

    @FindBy(xpath = "//i[@class='fa fa-refresh']")
    WebElement quantityUpdateBtn;

    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")
    WebElement totalPrice;

    @FindBy(xpath = "//td[normalize-space()='x2']")
    WebElement updatedQuantity;

    public int cartRows(){
        return cartTable.size();
    }

    public void clickCartBtn(){
        cartBtn.click();
    }

    public WebElement getCartBtn() {
        return cartBtn;
    }

    public void clickShoppingCartBtn(){
        shoppingCartBtn.click();
    }

    public void setInputQuantity(String quantity){
        inputQuantity.clear();
        inputQuantity.sendKeys(quantity);
    }

    public void clickQuantityUpdate(){
        quantityUpdateBtn.click();
    }

    public String getTotalPrice(){
        String dummy = totalPrice.getText();
        return dummy.substring(1,dummy.length());
    }

    public String getUpdatedQuantity(){
        return updatedQuantity.getText();
    }

}
