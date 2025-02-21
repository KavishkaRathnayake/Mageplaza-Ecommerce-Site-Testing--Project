package Checkout;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ShopNowPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TC_Checkout_01 {
    WebDriver driver;

    @BeforeMethod
    public void TC_Checkout_01(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");

    }
    @Test
    public void TC_Checkout_01Test(){
        HomePage homePage = new HomePage(driver);
        homePage.ClickShopNow();
        ShopNowPage shopNowPage = new ShopNowPage(driver);
        shopNowPage.ViewProuct01();
        shopNowPage.ClickAddtoCart();

        homePage.ClickCart();
        homePage.ClickCheckoutBtn();


    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();

    }
}
