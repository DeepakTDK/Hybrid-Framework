package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

import java.time.Duration;

public class TC001_AccountRegistrationTest extends BaseClass{


    @Test
    void verify_account_registration(){
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickRegister();

        AccountRegistrationPage arp = new AccountRegistrationPage(driver);
        arp.setFirstName("Deepak");
        arp.setLastName("TDK");
        arp.setEmail(randomString()+"@gmail.com");
        arp.setTelephone("882881727");
        arp.setPassword("Thamandk25.");
        arp.setConfirmPassword("Thamandk25.");
        arp.setPrivacyPolicy();
        arp.clickContinue();

        String confmsg = arp.getConfirmationMsg();
        Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");
    }

    String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
}
