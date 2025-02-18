package Homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_Homepage_01 {
    WebDriver driver;

    @BeforeMethod
    public void TC_Homepage(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }
    @Test
    public void TC_HomepageTest(){
        driver.get("https://www.mageplaza.com/");
    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
