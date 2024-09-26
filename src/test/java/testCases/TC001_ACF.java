package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

import java.time.Duration;

public class TC001_ACF extends BaseClass {
    @Test(groups = {"firefox"})
    void verifyCartCount(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            logger.info("TC001_ACF started");
            HomePage hp = new HomePage(driver);
            hp.inputSearchbox("samsung");
            logger.info("input given");
            hp.clickSearchbtn();
            logger.info("search button clicked");

            SearchResultPage srp = new SearchResultPage(driver);
            srp.clickProductOne();
            logger.info("p1 clicked");
            CartPage cp = new CartPage(driver);
            wait.until(ExpectedConditions.elementToBeClickable(cp.getCartBtn()));
            cp.clickCartBtn();
            logger.info("cart btn clicked");

            int actrow = cp.cartRows();
            logger.info(actrow);
            int expected = 1;
            Assert.assertEquals(actrow, expected, "invalid product count");
        } catch (Exception e){
            Assert.fail();
        }
    }
}
