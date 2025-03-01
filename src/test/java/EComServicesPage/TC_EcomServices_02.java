package EComServicesPage;

import Pages.EcomServicesPage;
import Pages.HomePage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class TC_EcomServices_02 {
    WebDriver driver;

    @BeforeMethod
    public void TC_EcomServices_02() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");
    }



@Test
    public void TC_EcomServices_02Test() throws AWTException {
        HomePage homePage = new HomePage(driver);
        String OldWindow = driver.getWindowHandle();
        homePage.ClickEcomservises();
        Set<String> handles = driver.getWindowHandles();
        for (String NewWindow : handles) {
            driver.switchTo().window(NewWindow);
        }

        EcomServicesPage ecomServicesPage = new EcomServicesPage(driver);
        ecomServicesPage.EnterFirstname("kavi");
        ecomServicesPage.EnterLastname("Rath");
        ecomServicesPage.EnterEmail("Abx@Gmail.com");
        ecomServicesPage.EnterCompanyName("Abc");
        ecomServicesPage.EnterCountryCode("+94");
        ecomServicesPage.EnterPhone("777834689");
        ecomServicesPage.SelectInteresrs();
//       ecomServicesPage.EnterMessage("elnk");
        ecomServicesPage.FileUpload();
        ecomServicesPage.SelectHearAbout();
        ecomServicesPage.ClickSubmit();

    }
    public void CloseBrowser(){
        driver.quit();
    }
}




