package SpecialDealsPage;

import Pages.HomePage;
import Pages.SpecialDealsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TC_SpecialDeals_01 {
    WebDriver driver;

    @BeforeMethod
    public void TC_SpecialDeals_01(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");
    }

    @Test
    public void TC_SpecialDeals_01Test() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String oldWindow = driver.getWindowHandle();
        homePage.ClickSpecialDeals();
        Set<String> handles =  driver.getWindowHandles();
        for (String newWindow:handles){
            driver.switchTo().window(newWindow);
        }

        SpecialDealsPage specialDealsPage = new SpecialDealsPage(driver);
        String oldWindow2 = driver.getWindowHandle();
        specialDealsPage.ClickBanner();
        Set<String> handles2 =  driver.getWindowHandles();
        for (String newWindow:handles2){
            driver.switchTo().window(newWindow);
            Thread.sleep(2500);
        }
        driver.close();

        driver.switchTo().window(oldWindow2);
        specialDealsPage.ShopNowBtn1();
        driver.navigate().back();
        specialDealsPage.ShopNowBtn2();
        driver.navigate().back();
        specialDealsPage.ShopNowBtn3();
        driver.navigate().back();
        specialDealsPage.RenewNowBtn();
        driver.navigate().back();
        specialDealsPage.ShopNowBtn4();
        driver.navigate().back();
    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }

}
