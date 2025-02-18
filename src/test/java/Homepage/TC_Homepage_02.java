package Homepage;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TC_Homepage_02 {
    WebDriver driver;

    @BeforeMethod
    public void TC_Homepage_02(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");

    }
    @Test
    public void TC_Homepage_02Test1() throws InterruptedException {
        //click on Extensions
        HomePage homePage = new HomePage(driver);
        String OldWindow = driver.getWindowHandle();
        homePage.ClickExtentions();
        Set<String> handles =  driver.getWindowHandles();
        for (String newWindow:handles){
            driver.switchTo().window(newWindow);
            Thread.sleep(2000);
        }
        driver.close();

        //Click on ShopifyApps
        driver.switchTo().window(OldWindow);
        homePage.ClickShopifyapps();

        Set<String> handles2 =  driver.getWindowHandles();
        for (String newWindow:handles2){
            driver.switchTo().window(newWindow);
            Thread.sleep(2000);
        }
        driver.close();

        //Click Ecomservices
        driver.switchTo().window(OldWindow);
        homePage.ClickEcomservises();

        Set<String> handles3=  driver.getWindowHandles();
        for (String newWindow:handles3){
            driver.switchTo().window(newWindow);
            Thread.sleep(2000);
        }
        driver.close();

        //Click Special Deals
        driver.switchTo().window(OldWindow);
        homePage.ClickSpecialDeals();

        Set<String> handles4=  driver.getWindowHandles();
        for (String newWindow:handles4){
            driver.switchTo().window(newWindow);
            Thread.sleep(2000);
        }
        driver.close();

        //Click Blogs
        driver.switchTo().window(OldWindow);
        homePage.ClickBlogs();

        Set<String> handles5=  driver.getWindowHandles();
        for (String newWindow:handles5){
            driver.switchTo().window(newWindow);
            Thread.sleep(2000);
        }
        driver.close();

        //Click our Work
        driver.switchTo().window(OldWindow);
        homePage.ClickOurworks();

        Set<String> handles6=  driver.getWindowHandles();
        for (String newWindow:handles6){
            driver.switchTo().window(newWindow);
            Thread.sleep(2000);
        }
        driver.close();

        //Click cart Button
        driver.switchTo().window(OldWindow);
        homePage.ClickCart();

        //Click Search Button
        homePage.ClickSearchBtn();

        System.out.println("Each menu item redirected to the correct page.");

    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
