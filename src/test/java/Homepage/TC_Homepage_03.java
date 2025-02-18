package Homepage;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TC_Homepage_03 {
    WebDriver driver;

    @BeforeMethod
    public void TC_Homepage_03(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");

    }
    @Test
    public void TC_Homepage_03Test() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        //Click Shop now
        homePage.ClickShopNow();
        Thread.sleep(1500);
        driver.navigate().back();

        //Click on Offers
        String old = driver.getWindowHandle();
        homePage.ClickAnOffer();
        Set<String> Handles = driver.getWindowHandles();
        for (String newWindow:Handles){
            driver.switchTo().window(newWindow);
            Thread.sleep(2000);

        }
        driver.close();

        driver.switchTo().window(old);

        //Click explore More Extensions
        homePage.ClickExploreExtension();
        Thread.sleep(2000);
        driver.navigate().back();

        //Click Take Quiz
        homePage.ClickTakeQuiz();
        Thread.sleep(1500);
        driver.navigate().back();
        driver.navigate().refresh();

        //Click on our services
        homePage.ClikcOurServices();
        Thread.sleep(1500);
        driver.navigate().back();

        //click view all services
        homePage.ClickViewallServices();
        Thread.sleep(1500);
        driver.navigate().back();

        //click Become a VIP
        homePage.ClickBecomeVIP();
        Thread.sleep(1500);
        driver.navigate().back();

        //click to see trust pilot
        homePage.ClickseeTrustPilot();
        Thread.sleep(1500);
        driver.navigate().back();

        //click to boost website
        homePage.ClickBoostWebSite();
        Thread.sleep(1500);
        driver.navigate().back();

        //click to view blog
        homePage.ClickviewBlog();
        Thread.sleep(1500);
        driver.navigate().back();

        //send email Address
        homePage.setEmail("kavishka6@gmail.com");
        homePage.setEmail("xyz.com");

    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
