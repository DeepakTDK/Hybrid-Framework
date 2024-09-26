package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
    @Test(groups = {"sanity"})
    void verifyLogin(){
        logger.info("starting TC002_LoginTest");
       try{
           HomePage hp = new HomePage(driver);
           hp.clickMyAccount();
           hp.clickLogin();

           LoginPage lp = new LoginPage(driver);
           lp.setEmail(p.getProperty("email"));
           lp.setPassword(p.getProperty("password"));
           lp.clickLogin();

           MyaccountPage map = new MyaccountPage(driver);
           boolean targetPage = map.isMyAccountPageExists();

           Assert.assertTrue(targetPage);
       }catch (Exception e){
            Assert.fail();
       }
        logger.info("Finished TC002_LoginTest");
    }
}
