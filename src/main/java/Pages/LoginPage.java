package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='action create primary']//span[contains(text(),'Create an Account')]")
    WebElement RegisterBtn_loc;
    @FindBy(xpath = "//input[@id='email']")
    WebElement Email_Loc;
    @FindBy(xpath = "//input[@id='pass']")
    WebElement PasswordP_Loc;
    @FindBy(xpath = "//fieldset[@class='fieldset login']//button[@id='send2']")
    WebElement SigninBtn_loc;


    public void ClickRegisterBtn(){
        RegisterBtn_loc.click();
    }

    public String RegisterPageTitle(){
        String RegisterPagetitle = driver.getTitle();   //get the registerpagetitle
        return RegisterPagetitle;
    }
    public void SetEmail(String Email){
        Email_Loc.sendKeys(Email);
    }
    public void setPassword(String password){
        PasswordP_Loc.sendKeys(password);
    }
    public void ClickSignin(){
        SigninBtn_loc.click();
    }


}
