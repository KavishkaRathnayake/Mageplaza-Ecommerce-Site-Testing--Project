package ShopifyApps;

import Pages.HomePage;
import Pages.ShopifyAppsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TC_ShopifyApps_01 {
    WebDriver driver;

    @BeforeMethod
    public void TC_ShopifyApps_01(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");
    }

    @Test
    public void TC_ShopifyApps_01Test() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.ClickShopifyapps();
        Set<String> handles =  driver.getWindowHandles();
        for (String window:handles){
            driver.switchTo().window(window);
        }

        ShopifyAppsPage shopifyAppsPage = new ShopifyAppsPage(driver);
        shopifyAppsPage.ClickGetStartBtn();
        shopifyAppsPage.ClickOpenStoreBtn();

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
