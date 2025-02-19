package Search;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_Search_05 {
    WebDriver driver;

    @BeforeMethod
    public void TC_Search_03(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");
    }
    @Test
    public void TC_Search_03Test() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.ClickSearchBtn();
        homePage.setSearchBox("Magento 2 SEO Extension");
        Thread.sleep(2000);
    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
