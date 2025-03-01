package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecialDealsPage {
    WebDriver driver;

    public SpecialDealsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='owl-item active center']//img[@alt='Subscription Deals Magento 2']")
    WebElement Banner1_Loc;
    @FindBy(xpath = "//div[@class='col-12 col-md-4 px-2']//a[@class='py-07 px-5 border-radius-8 button-new-customers'][normalize-space()='Shop now']")
    WebElement ShopNowBtn1_Loc;
    @FindBy(xpath = "//div[@class='pt-4 transition-3d-hover mt-0 mt-md-6 mt-lg-0']//a[@class='py-07 px-5 border-radius-8 button-new-customers'][normalize-space()='Shop now']")
    WebElement ShopNowBtn2_Loc;
    @FindBy(xpath = "//div[@class='col-12 col-md-4 mt-5 mt-md-0 px-2']//div[@class='pt-4 transition-3d-hover']//a[@class='py-07 px-5 border-radius-8 button-new-customers'][normalize-space()='Shop now']")
    WebElement ShopNowBtn3_Loc;
    @FindBy(xpath = "//a[contains(text(),'Renew')]")
    WebElement RenewNowBtn_Loc;
    @FindBy(xpath = "//a[@class='bg-shamrock text-dark py-3 px-5 transition-3d-hover border-radius-8 font-size-18']")
    WebElement ShopNowBtn4_Loc;





    public void ClickBanner(){
        Banner1_Loc.click();
    }
    public void ShopNowBtn1(){
        ShopNowBtn1_Loc.click();
    }
    public void ShopNowBtn2(){
        ShopNowBtn2_Loc.click();
    }
    public void ShopNowBtn3(){
        ShopNowBtn3_Loc.click();
    }
    public void RenewNowBtn(){
        RenewNowBtn_Loc.click();
    }
    public void ShopNowBtn4(){
        ShopNowBtn4_Loc.click();
    }
}


