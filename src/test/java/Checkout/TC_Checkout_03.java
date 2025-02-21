package Checkout;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TC_Checkout_03 {
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

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setFirstName_lco("Kavishka");
        checkoutPage.setLastName_lco("Rathnayaka");
        checkoutPage.setAddress_lco("Kurunegala, Sri lanka");
        checkoutPage.setCity_lco("Kurunegala");
        checkoutPage.setCountry_lco();
        checkoutPage.setCompany_lco("ABC company");
        checkoutPage.setTaxNo_lco("000011112222333");
        checkoutPage.ClickPlaceOrderBtn();

    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();

    }
}
