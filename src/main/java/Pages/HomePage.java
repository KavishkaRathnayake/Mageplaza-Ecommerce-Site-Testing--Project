package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@id='homeMegaMenu']")
    WebElement Extentions_loc;
    @FindBy(xpath = "//a[normalize-space()='Shopify Apps']")
    WebElement ShopifyApps_loc;
    @FindBy(xpath = "//a[@id='homeMegaMenu-Services']")
    WebElement EcomServices_loc;
    @FindBy(xpath = "//a[@class='font-size-18 font-size-md-down-1 text-white-change'][normalize-space()='Special Deals']")
    WebElement SpecialDeals_loc;
    @FindBy(xpath = "//a[@id='homeMegaMenuBlog']")
    WebElement Blog_loc;
    @FindBy(xpath = "//a[normalize-space()='Our Work']")
    WebElement OurWork_loc;
    @FindBy(xpath = "//button[@id='icon-search-t10']")
    WebElement SearchBtn_loc;
    @FindBy (xpath = "//a[@id='sidebarNavToggler']")
    WebElement AccountButton_loc;
    @FindBy(xpath = "//input[@id='search-input']")
    WebElement SearchBox_loc;
    @FindBy (xpath = "//a[@id='shoppingCartDropdownInvoker']")
    WebElement CartBtn_loc;
    @FindBy(xpath = "//a[@id='check-out-now']")
    WebElement checkOutBtn_loc;
    @FindBy(xpath = "//a[@id='contact-us']")
    WebElement ContactUsBtn_loc;


    @FindBy(xpath = "//span[contains(.,'Shop now')]")
    WebElement ShopNowBtn_loc;
    @FindBy(xpath = "//div[@class='owl-item']//img[@alt='Welcome Package']")
    WebElement Offer_loc;
    @FindBy(xpath = "//div[@class='mt-8 d-flex justify-content-center']//a[@class='btn btn-sm btn-block btn-primary transition-3d-hover text-nowrap d-flex align-items-center padding-btn text-btn mp-bg-nav']")
    WebElement ExploreExtension_loc;
    @FindBy(xpath = "//a[normalize-space()='Take quiz']")
    WebElement TakeQuiz_loc;
    @FindBy(xpath = "//div[@class='row our-service-item p-md-5 p-3 transition-3d-hover opacity-1']")
    WebElement OurServices_loc;
    @FindBy(xpath = "//div[@class='mt-6 d-flex justify-content-center']//a[@class='btn btn-sm btn-block btn-primary transition-3d-hover text-nowrap d-flex align-items-center padding-btn text-btn mp-bg-nav']")
    WebElement ViewallServicesBtn_loc;
    @FindBy(xpath = "//div[@class='d-none d-md-block']//a[@class='btn btn-sm btn-block btn-primary transition-3d-hover text-nowrap d-flex align-items-center padding-btn text-btn mp-bg-nav']")
    WebElement BecomeAVIP_loc;
    @FindBy(xpath = "//a[normalize-space()='See our excellent reviews on Trustpilot']")
    WebElement SeeTrustPilot_loc;
    @FindBy (xpath = "//div[@class='mt-8 d-flex justify-content-center']//a[@class='btn btn-sm btn-block btn-primary transition-3d-hover text-nowrap d-flex align-items-center padding-btn text-btn mp-bg-green']")
    WebElement BoostWebSite_loc;
    @FindBy(xpath = "//a[normalize-space()='View blog']")
    WebElement ViewBlog_loc;
    @FindBy(xpath = "//input[@id='subcribe_email2']")
    WebElement Email_loc;
    @FindBy(xpath = "//i[@id='m2-customer-attributes']")
    WebElement RemoveFromCart_loc;


    public void ClickExtentions(){
        Extentions_loc.click();
    }
    public void ClickShopifyapps(){
        ShopifyApps_loc.click();

    }
    public void ClickEcomservises(){
        EcomServices_loc.click();
    }
    public void ClickSpecialDeals(){
        SpecialDeals_loc.click();
    }
    public void ClickBlogs(){
        Blog_loc.click();
    }
    public void ClickOurworks(){
        OurWork_loc.click();
    }

    public void ClickMyAccount(){
        AccountButton_loc.click();
    }
    public void ClickCart(){
        CartBtn_loc.click();
    }
    public void ClickContactUs(){
        ContactUsBtn_loc.click();
    }
    public void ClickSearchBtn(){
        SearchBtn_loc.click();
    }
    public void ClickShopNow(){
        ShopNowBtn_loc.click();
    }
    public void ClickAnOffer(){
        Offer_loc.click();
    }
    public void ClickExploreExtension(){
        ExploreExtension_loc.click();
    }
    public void ClickTakeQuiz(){
        TakeQuiz_loc.click();
    }
    public void ClikcOurServices(){
        OurServices_loc.click();
    }
    public void ClickViewallServices(){
        ViewallServicesBtn_loc.click();
    }
    public void ClickBecomeVIP(){
        BecomeAVIP_loc.click();
    }
    public void ClickseeTrustPilot(){
        SeeTrustPilot_loc.click();
    }
    public void ClickBoostWebSite(){
        BoostWebSite_loc.click();
    }
    public void ClickviewBlog(){
        ViewBlog_loc.click();
    }
    public void setEmail(String email){
        Email_loc.sendKeys(email + Keys.ENTER);
    }
    public void setSearchBox(String Keyword){
        SearchBox_loc.sendKeys(Keyword + Keys.ENTER);
    }
    public void RemoveFromCart(){
        RemoveFromCart_loc.click();
    }
    public void ClickCheckoutBtn(){
        checkOutBtn_loc.click();
    }
}








