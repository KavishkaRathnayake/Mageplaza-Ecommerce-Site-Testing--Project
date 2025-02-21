package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='MHHY24J']")
    WebElement FirstName_lco;
    @FindBy(xpath = "//input[@id='L86U0DP']")
    WebElement LastName_lco;
    @FindBy(xpath = "//input[@id='K0HOSWV']")
    WebElement Address_lco;
    @FindBy(xpath = "//input[@id='AOPB44R']")
    WebElement City_lco;
    @FindBy(xpath = "//select[@id='KIGK310']")
    WebElement Country_lco;
    @FindBy(xpath = "//input[@id='KLD4GO5']")
    WebElement Company_lco;
    @FindBy(xpath = "//input[@id='F46TAOE']")
    WebElement TaxNo_lco;
    @FindBy(xpath = "//input[@id='discount-code']")
    WebElement DiscounCode_lco;
    @FindBy(xpath = "//button[@title='Place Order']")
    WebElement PlaceOrderBtn_lco;


    public void setFirstName_lco(String FirstName){
        FirstName_lco.sendKeys(FirstName);
    }
    public void setLastName_lco(String LastName){
        LastName_lco.sendKeys(LastName);
    }
    public void setAddress_lco(String Address){
        Address_lco.sendKeys(Address);
    }
    public void setCity_lco(String City){
        City_lco.sendKeys(City);
    }
    public void setCountry_lco(){
        Select select = new Select(Country_lco);
        select.selectByVisibleText("Sri Lanka");
    }
    public void setCompany_lco(String Company){
        Company_lco.sendKeys(Company);
    }
    public void setTaxNo_lco(String Tax){
        TaxNo_lco.sendKeys(Tax);
    }
    public void setDiscounCode_lco(String Discount){
        DiscounCode_lco.sendKeys(Discount);
    }
    public void ClickPlaceOrderBtn(){
        PlaceOrderBtn_lco.click();
    }
}











