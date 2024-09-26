package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement lnkRegister;

    @FindBy(linkText = "Login")   // Login link added in step5
    WebElement linkLogin;

    @FindBy(xpath="//input[@placeholder='Search']")
    WebElement searchBox;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement searchBtn;

    @FindBy(xpath = "//table[@class = 'table table-striped']//tr")
    List<WebElement> cartTable;

    @FindBy(xpath = "//span[@id='cart-total']")
    WebElement cartBtn;

    public int cartRows(){
        return cartTable.size();
    }

    public void clickCartBtn(){
        cartBtn.click();
    }

    public void clickMyAccount()
    {
        lnkMyaccount.click();
    }

    public void clickRegister()
    {
        lnkRegister.click();
    }

    public void clickLogin()
    {
        linkLogin.click();
    }

    public void inputSearchbox(String product){
        searchBox.sendKeys(product);
    }

    public void clickSearchbtn(){
        searchBtn.click();
    }

    public WebElement getCartBtn() {
        return cartBtn;
    }
}