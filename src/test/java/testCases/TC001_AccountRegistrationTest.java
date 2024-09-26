package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
    @Test(groups = {"sanity"})
    void verify_account_registration(){
        logger.info("Started TC001_AccountRegistrationTest");
        logger.debug("This is a debug log message");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on MyAccount Link");
            hp.clickRegister();
            logger.info("Clicked on Register Link.. ");

            AccountRegistrationPage arp = new AccountRegistrationPage(driver);
            logger.info("Providing customer details");
            arp.setFirstName("Deepak");
            arp.setLastName("TDK");
            arp.setEmail(randomString() + "@gmail.com");
            arp.setTelephone("882881727");
            arp.setPassword("Thamandk25.");
            arp.setConfirmPassword("Thamandk25.");
            arp.setPrivacyPolicy();
            arp.clickContinue();
            logger.info("Validating expected message");

            String confmsg = arp.getConfirmationMsg();
            Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");
            logger.info("Test passed");
        } catch (Exception e){
            Assert.fail();
        }
    }

    String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
}
