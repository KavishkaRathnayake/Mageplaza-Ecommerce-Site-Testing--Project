package Checkout;

import Pages.DashboardPage;
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

public class TC_Checkout_02 {
    WebDriver driver;

    @BeforeMethod
    public void TC_Checkout_02(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");

    }
    @Test
    public void TC_Checkout_02Test() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String OldWindow = driver.getWindowHandle();
        homePage.ClickMyAccount();
        Set<String> handles =  driver.getWindowHandles();
        for (String newWindow:handles){
            driver.switchTo().window(newWindow);
        }
        LoginPage loginPage = new LoginPage(driver);
        loginPage.SetEmail("Kavishka6905@gmail.com");
        loginPage.setPassword("Kavishka9600");
        loginPage.ClickSignin();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.ClickCart();
        dashboardPage.ClickCheckoutBtn();
        Thread.sleep(3000);

    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();

    }
}
