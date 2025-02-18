package Register;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
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

public class TC_UserRegister {
    WebDriver driver;

    @BeforeMethod
    public void TC_001(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.mageplaza.com/");
    }

    //providing data through Excel file
    @DataProvider(name = "logindata")
    public Object[][] getExcelData() throws IOException {

        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\RegisterTestData.xlsx");
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

        @Test (dataProvider = "logindata" )
        public void TC_001Test(String Firstname, String Lastname, String Email, String Taxno, String pass, String Compass, String expValidation ) throws InterruptedException {
        //Click my account button and switch to a new tab
        HomePage homePage = new HomePage(driver);
        homePage.ClickMyAccount();
        Set<String> handles =  driver.getWindowHandles();
        for (String newWindow:handles){
            driver.switchTo().window(newWindow);
        }

        //click Register Button
        LoginPage loginPage = new LoginPage(driver);
        loginPage.ClickRegisterBtn();

        //verify User landed to the Register page
        String ActualText = loginPage.RegisterPageTitle();
        Assert.assertTrue(ActualText.contains("Create New Customer Account"), "User Not visited to Register Page");

        //Fill the register form and create user account
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setFisrtname(Firstname);
        registerPage.setLastname_loc(Lastname);
        registerPage.setEmail_loc(Email);
        registerPage.setTaxnumber_Loc(Taxno);
        registerPage.setPassword_loc(pass);
        registerPage.setConfirmassword_loc(pass);
        registerPage.ClickAllow();
        registerPage.SelectAbout();
        registerPage.ClickCreateAccountBtn();

            boolean urlVerification = driver.getCurrentUrl().contains("rewards");

            if (expValidation.equals("valid")) {
                Assert.assertTrue(urlVerification, "Expected login success, But not navigated to the dashboard");
            } else {
                Assert.assertFalse(urlVerification, "Expected login fail, But navigated to the dashboard");
            }
            Thread.sleep(1000);


    }


    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}


