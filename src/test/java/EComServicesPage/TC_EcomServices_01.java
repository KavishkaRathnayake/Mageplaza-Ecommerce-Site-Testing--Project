package EComServicesPage;

import Pages.EcomServicesPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TC_EcomServices_01 {
    WebDriver driver;

    @BeforeMethod
    public void TC_EcomServices_01(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");
    }
    @Test
    public void TC_EcomServices_01Test() throws InterruptedException {
       buttonClicktests();
    }

    public void buttonClicktests() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        String oldWindow = driver.getWindowHandle();
        homePage.ClickEcomservises();
        Set<String> handles = driver.getWindowHandles();
        for (String newWindow : handles) {
            driver.switchTo().window(newWindow);
        }
        EcomServicesPage ecomServicesPage = new EcomServicesPage(driver);
        ecomServicesPage.ClickWhatweOfferBtn();
        Thread.sleep(1500);

        String oldWindow2 = driver.getWindowHandle();
        ecomServicesPage.ClickViewMoreBtn();
        Set<String> handles2 = driver.getWindowHandles();
        for (String newWindow : handles2) {
            driver.switchTo().window(newWindow);
            Thread.sleep(2000);

        }
        driver.close();
        driver.switchTo().window(oldWindow2);
        ecomServicesPage.ClickViewAllBtn();
        Set<String> handles3 = driver.getWindowHandles();
        for (String newWindow : handles3) {
            driver.switchTo().window(newWindow);
            Thread.sleep(2000);

        }
        driver.close();
    }


    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
