package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

import java.time.Duration;

public class TC002_ACF extends BaseClass {
    @Test(groups = {"sanity"})
    void verifyQuantityPrice(){
        try {
            HomePage hp = new HomePage(driver);
            hp.inputSearchbox("samsung");
            hp.clickSearchbtn();

            SearchResultPage srp = new SearchResultPage(driver);
            srp.clickProductTwo();

            CartPage cp = new CartPage(driver);
            cp.clickShoppingCartBtn();
            String quantity = "2";
            cp.setInputQuantity(quantity);
            cp.clickQuantityUpdate();
            logger.info(cp.getUpdatedQuantity());
            cp.clickCartBtn();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Assert.assertTrue(cp.getUpdatedQuantity().contains(quantity));
        }catch (Exception e){
            Assert.fail();
        }
    }
}
