package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement ViewCart_loc;
    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
    WebElement CheckoutBtn_loc;

    public void ClickCart(){
       ViewCart_loc.click();
    }
    public void ClickCheckoutBtn(){
        CheckoutBtn_loc.click();
    }
}
