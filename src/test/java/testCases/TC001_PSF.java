package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC001_PSF extends BaseClass {
    @Test(groups = {"sanity"})
    void verifyInvalidProductnameMessage(){
        try{
            HomePage hp = new HomePage(driver);
            hp.inputSearchbox("shshshs");
            hp.clickSearchbtn();

            SearchResultPage srp = new SearchResultPage(driver);
            String invalidmsg = srp.getInvalidProductMessageText();
            Assert.assertEquals(invalidmsg, "There is no product that matches the search criteria.", "invalid message mismatch");
        } catch (Exception e){
            Assert.fail();
        }
    }
}
