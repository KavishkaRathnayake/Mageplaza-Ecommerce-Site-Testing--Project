package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "firstname")
    WebElement Fisrtname_loc;
    @FindBy(name = "lastname")
    WebElement Lastname_loc;
    @FindBy(name = "taxvat")
    WebElement Taxnumber_Loc;
    @FindBy(name = "email")
    WebElement Email_loc;
    @FindBy(xpath = "//input[@id='password']")
    WebElement Password_loc;
    @FindBy(xpath = "//input[@id='password-confirmation']")
    WebElement Confirmassword_loc;
    @FindBy(id = "assistance_allowed_checkbox")
    WebElement AllowBtn_loc;
    @FindBy(xpath = "//select[@name='who_are_you']")
    WebElement SelectAboutUser_loc;
    @FindBy(xpath = "//button[@title='Create an Account']")
    WebElement CreateAccountBtn_loc;

    public void setFisrtname(String Firstname){
        Fisrtname_loc.sendKeys(Firstname);
    }
    public void setLastname_loc(String Lastname){
        Lastname_loc.sendKeys(Lastname);
    }
    public void setTaxnumber_Loc(String TaxNo){
        Taxnumber_Loc.sendKeys(TaxNo);
    }
    public void setEmail_loc(String Email){
        Email_loc.sendKeys(Email);
    }
    public void setPassword_loc(String Password){
        Password_loc.sendKeys(Password);
    }
    public void setConfirmassword_loc(String Confirmassword){
        Confirmassword_loc.sendKeys(Confirmassword);
    }
    public void ClickAllow(){
        AllowBtn_loc.click();
    }
    public void SelectAbout(){
        Select select = new Select(SelectAboutUser_loc);
        select.selectByIndex(2);
    }
    public void ClickCreateAccountBtn(){
        CreateAccountBtn_loc.click();
    }


}
