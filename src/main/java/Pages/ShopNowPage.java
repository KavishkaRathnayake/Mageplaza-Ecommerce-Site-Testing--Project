package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopNowPage {
    WebDriver driver;

    public ShopNowPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Customer Attributes Magento 2']")
    WebElement Prouct01_loc;
    @FindBy(xpath = "//span[normalize-space()='Call for Price Magento 2']")
    WebElement Prouct02_loc;
    @FindBy(xpath = "//span[normalize-space()='Custom Form']")
    WebElement Prouct03_loc;

    @FindBy(xpath = "//input[@id='installation-desktop']")
    WebElement SelectInstallation_loc;
    @FindBy(xpath = "//button[@id='extension-fbt-add-cart-desktop']")
    WebElement AddtoCartBtn_loc;

    public void ViewProuct01(){
        Prouct01_loc.click();
    }
    public void ViewProuct02(){
        Prouct02_loc.click();
    }
    public void ViewProuct03(){
        Prouct03_loc.click();
    }
    public void SelectInstallation(){
        SelectInstallation_loc.click();
    }
    public void ClickAddtoCart(){
        AddtoCartBtn_loc.click();
    }





}
