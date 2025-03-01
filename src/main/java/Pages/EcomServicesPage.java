package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class EcomServicesPage {
    WebDriver driver;

    public EcomServicesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='slick-slide00']//a[@class='btn bg-navy text-white btn-wide btn-change-bg transition-3d-hover bdr-12 js-go-to animated js-animation-was-fired undefined'][normalize-space()='See what we offer']")
    WebElement WhatWeOfferBtn_loc;
    @FindBy(xpath = "//a[normalize-space()='View more']")
    WebElement ViewMoreBtn_loc;
    @FindBy(xpath = "//a[normalize-space()='View All']")
    WebElement ViewAllBtn_loc;
    @FindBy(xpath = "//input[@placeholder='First name']")
    WebElement Firstname_loc;
    @FindBy(xpath = "//input[@placeholder='Last name']")
    WebElement Lasttname_loc;
    @FindBy(xpath = "//input[@placeholder='email@sample.com']")
    WebElement Email_loc;
    @FindBy(xpath = "//input[@id='international_PhoneNumber_countrycodeval']")
    WebElement CountryCode_loc;
    @FindBy(xpath = "//input[@id='international_PhoneNumber_countrycode']")
    WebElement Phone_loc;
    @FindBy(xpath = "//input[@name='SingleLine']")
    WebElement Company_loc;
    @FindBy(xpath = "//select[@name='Dropdown1']")
    WebElement Interests_loc;
    @FindBy(xpath = "//textarea[@placeholder='What's on your mind?']")
    WebElement Message_loc;
    @FindBy(xpath = "//select[@name='Dropdown']")
    WebElement HearAbout_loc;
    @FindBy(xpath = "//div[@class='w-md-50 pb-3 pl-md-4']//div[@class='zf-tempContDiv']")
    WebElement FileUpload_loc;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitbtn_loc;


    public void ClickWhatweOfferBtn(){
        WhatWeOfferBtn_loc.click();
    }
    public void ClickViewMoreBtn(){
        ViewMoreBtn_loc.click();
    }
    public void ClickViewAllBtn(){
        ViewAllBtn_loc.click();
    }
    public void EnterFirstname(String firstname){
        Firstname_loc.sendKeys(firstname);
    }
    public void EnterLastname(String lastname){
        Lasttname_loc.sendKeys(lastname);
    }
    public void EnterEmail(String email){
        Email_loc.sendKeys(email);
    }
    public void EnterCountryCode(String CountryCode){
        CountryCode_loc.clear();
        CountryCode_loc.sendKeys(CountryCode);
    }
    public void EnterPhone(String Phone){
        Phone_loc.sendKeys(Phone);
    }
    public void EnterCompanyName(String CompanyName){
        Company_loc.sendKeys(CompanyName);
    }
    public void SelectInteresrs(){
        Select select = new Select(Interests_loc);
        select.selectByIndex(3);
    }
    public void EnterMessage(String Message) {
        Message_loc.sendKeys(Message);
    }
    public void SelectHearAbout(){
        Select select = new Select(HearAbout_loc);
        select.selectByIndex(3);
    }
    public void FileUpload() throws AWTException {
        FileUpload_loc.click();
        String data = "E:\\QA\\My QA Projects\\Mageplaza-Ecommerce-Site-Test\\TestData\\Kavishka.txt";
        StringSelection Selection = new StringSelection(data);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Selection , null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
    public void ClickSubmit(){
        submitbtn_loc.click();
    }






}



