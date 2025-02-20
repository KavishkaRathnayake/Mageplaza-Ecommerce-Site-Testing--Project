package Cart;

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

public class TC_Cart_05 {
    WebDriver driver;

    @BeforeMethod
    public void TC_Cart_05(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");
    }

    @Test
    public void TC_Cart_05Test() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String oldWindow = driver.getWindowHandle();
        homePage.ClickMyAccount();
        Set<String> hanles =  driver.getWindowHandles();
        for(String newWindow:hanles){
            driver.switchTo().window(newWindow);
        }

        LoginPage loginPage = new LoginPage(driver);
        loginPage.SetEmail("Kavishka6905@gmail.com");
        loginPage.setPassword("Kavishka9600");
        loginPage.ClickSignin();
        driver.close();
        driver.switchTo().window(oldWindow);

        homePage.ClickShopNow();
        ShopNowPage shopNowPage = new ShopNowPage(driver);
        shopNowPage.ViewProuct01();
        shopNowPage.ClickAddtoCart();

        homePage.ClickCart();
        Thread.sleep(500);
        homePage.RemoveFromCart();
    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
