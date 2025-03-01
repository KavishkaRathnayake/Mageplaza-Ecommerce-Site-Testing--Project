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

    @DataProvider (name = "log")
    public Object[][] getExcelData() throws IOException {

        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\ContactTestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1"); //work.getsheetAt(indexValue);
        int totalRows = sheet.getLastRowNum();
        int totalColumns = sheet.getRow(0).getLastCellNum();
        System.out.println("total Rows Count: " + totalRows);
        System.out.println("total Columns Count: " + totalColumns);

        String[][] TestData = new String[totalRows][totalColumns];

        for (int r = 1; r <= totalRows; r++) {
            for (int c = 0; c < totalColumns; c++) {
                TestData[r - 1][c] = sheet.getRow(r).getCell(c).toString();
            }
        }

        workbook.close(); //close workbook
        file.close(); //close file

        return TestData;
    }



    @Test (dataProvider = "log")
    public void TC_EcomServices_02Test(String first, String last, String email, String phone, String company) throws AWTException {
        HomePage homePage = new HomePage(driver);
        String OldWindow = driver.getWindowHandle();
        homePage.ClickEcomservises();
        Set<String> handles = driver.getWindowHandles();
        for (String NewWindow : handles) {
            driver.switchTo().window(NewWindow);
        }

        EcomServicesPage ecomServicesPage = new EcomServicesPage(driver);
        ecomServicesPage.EnterFirstname(first);
        ecomServicesPage.EnterLastname(last);
        ecomServicesPage.EnterEmail(email);
        ecomServicesPage.EnterCompanyName(company);
        ecomServicesPage.EnterCountryCode("+94");
        ecomServicesPage.EnterPhone(phone);
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




