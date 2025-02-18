package Login;

import Pages.HomePage;
import Pages.LoginPage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class TC_UserLogin {
    WebDriver driver;

    @BeforeMethod
    public void TC_UserLogin(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");
    }

    @DataProvider (name = "SignData")
    public Object[][] getExcelData() throws IOException {

        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\SigninTestData.xlsx");
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

    @Test (dataProvider = "SignData")
    public void TC_UserLoginTest(String Email , String Pass, String Val){
        HomePage homePage = new HomePage(driver);
        homePage.ClickMyAccount();
        Set<String> Handles =  driver.getWindowHandles();
        for (String newWindow:Handles){
            driver.switchTo().window(newWindow);
        }

        LoginPage loginPage = new LoginPage(driver);

        loginPage.SetEmail(Email);
        loginPage.setPassword(Pass);
        loginPage.ClickSignin();

        boolean UrlVerification = driver.getCurrentUrl().contains("rewards");
        if(Val.equals("valid")){
            Assert.assertTrue(UrlVerification, "Expected Login success, but not landed to dashboard");
        }
        else {
            Assert.assertFalse(UrlVerification, "Expected Login failed, but landed to dashboard");
        }


    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }

}
