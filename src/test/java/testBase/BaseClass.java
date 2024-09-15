package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {
    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
        driver.manage().window().maximize();
    }

    @AfterClass
    void teardown(){
        driver.quit();
    }
}
